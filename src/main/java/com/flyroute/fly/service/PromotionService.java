package com.flyroute.fly.service;

import com.flyroute.fly.dto.request.promotionrequest.CreatePromotionRequest;
import com.flyroute.fly.dto.request.promotionrequest.UpdatePromotionRequest;
import com.flyroute.fly.dto.response.promotionresponse.GetPromotionResponse;

import java.util.List;

public interface PromotionService {

    GetPromotionResponse save(CreatePromotionRequest createPromotionRequest);

    GetPromotionResponse update(UpdatePromotionRequest updatePromotionRequest);

    GetPromotionResponse getPromotionById(int id);

    List<GetPromotionResponse> getAllPromotions();

    String deleteById(int id);
}
