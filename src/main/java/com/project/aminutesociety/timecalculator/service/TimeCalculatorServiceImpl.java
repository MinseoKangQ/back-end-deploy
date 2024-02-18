package com.project.aminutesociety.timecalculator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.project.aminutesociety.timecalculator.dto.SetDistanceDto;
import com.project.aminutesociety.util.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
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
            // ObjectMapper를 사용하여 JSON 문자열을 JsonNode로 변환합니다.
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            // "rows" 배열을 가져옵니다.
            ArrayNode rows = (ArrayNode) root.get("rows");

            // "rows" 배열의 첫 번째 요소를 가져옵니다.
            JsonNode firstRow = rows.get(0);

            // 첫 번째 요소의 "elements" 배열을 가져옵니다.
            ArrayNode elements = (ArrayNode) firstRow.get("elements");

            // "elements" 배열의 첫 번째 요소를 가져옵니다.
            JsonNode firstElement = elements.get(0);

            // 첫 번째 요소의 "duration" 객체에서 "value" 값을 가져옵니다.
            timeValue = firstElement.get("duration").get("value").asInt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ApiResponse<Integer> res = ApiResponse.createSuccessWithData(timeValue, "거리 측정에 성공하였습니다.");
        return ResponseEntity.ok(res);
    }
}
