package com.project.aminutesociety.timecalculator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.project.aminutesociety.util.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TimeCalculatorServiceImpl implements TimeCalculatorService{

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @Override
    public ResponseEntity<ApiResponse<?>> getTime(String distance, String arrive) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&mode=transit&origins=" + distance + "&destinations=" + arrive + "&region=KR&key="+ googleMapsApiKey;


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String responseBody = response.getBody();

        int timeValue = 0;


        try {
            // JSON 문자열을 JsonNode로 변환
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            ArrayNode rows = (ArrayNode) root.get("rows");
            JsonNode firstRow = rows.get(0);

            // 첫 번째 요소의 "elements" 배열
            ArrayNode elements = (ArrayNode) firstRow.get("elements");
            JsonNode firstElement = elements.get(0);

            // 거리 계산 실패
            if(firstElement.equals("NOT_FOUND") || firstElement.equals("ZERO_RESULTS") || firstElement.equals("MAX_ROUTE_LENGTH_EXCEEDED"))
                throw new Exception();

            timeValue = firstElement.get("duration").get("value").asInt();

        } catch (Exception e) {
            ApiResponse<String> res = ApiResponse.createFailWithoutData(400, "거리 측정에 실패하였습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        ApiResponse<Integer> res = ApiResponse.createSuccessWithData(timeValue, "거리 측정에 성공하였습니다.");
        return ResponseEntity.ok(res);
    }
}
