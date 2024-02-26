package com.project.aminutesociety.video.service;

import com.project.aminutesociety.util.response.CustomApiResponse;
import com.project.aminutesociety.video.dto.EditRecommendVideo;
import org.springframework.http.ResponseEntity;

public interface VideoService {

    ResponseEntity<CustomApiResponse<?>> recommendVideo(String userId, Integer time); // 시간 설정 후 영상 추천 - 핵심 기능
    ResponseEntity<CustomApiResponse<?>> editRecommendVideo(String userId, Integer time, EditRecommendVideo.Req req); // 영상 추천 수정
    ResponseEntity<CustomApiResponse<?>> getVideoRecommend(String userId); // 홈에서 영상 추천
}
