package com.project.aminutesociety.scrap.service;

import com.project.aminutesociety.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ScrapService {

    ResponseEntity<CustomApiResponse<?>> createScrap(String userId, Long videoId);
    ResponseEntity<CustomApiResponse<?>> deleteScrap(String userId, Long videoId);
    ResponseEntity<CustomApiResponse<?>> getUserScrap(String userId, String type);
}
