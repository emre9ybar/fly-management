package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.request.promotionrequest.CreatePromotionRequest;
import com.flyroute.fly.dto.request.promotionrequest.UpdatePromotionRequest;
import com.flyroute.fly.dto.response.promotionresponse.GetPromotionResponse;
import com.flyroute.fly.entity.Promotion;
import com.flyroute.fly.exception.promotionexception.PromotionNotFoundException;
import com.flyroute.fly.message.PromotionMessage;
import com.flyroute.fly.repository.PromotionRepository;
import com.flyroute.fly.rules.PromotionBusinessRules;
import com.flyroute.fly.service.PromotionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final MapperService mapperService;
    private final PromotionRepository promotionRepository;
    private final PromotionBusinessRules promotionBusinessRules;

    @Override
    public GetPromotionResponse save(CreatePromotionRequest createPromotionRequest) {

        promotionBusinessRules.checkIfCodeExists(createPromotionRequest.getCode());

        Promotion promotion = mapperService.forRequest().map(createPromotionRequest, Promotion.class);
        System.out.println("Promotion mapped");

        promotionRepository.save(promotion);

        GetPromotionResponse getPromotionResponse = mapperService.forResponse().map(promotion, GetPromotionResponse.class);

        return getPromotionResponse;

    }

    @Override
    @Transactional
    public GetPromotionResponse update(UpdatePromotionRequest updatePromotionRequest) {

        int promotionId = updatePromotionRequest.getId();

        Promotion promotion = getPromotion(promotionId);

        mapperService.forRequest().map(updatePromotionRequest, promotion);

        Promotion savedPromotion = promotionRepository.save(promotion);

        GetPromotionResponse response = mapperService.forResponse().map(savedPromotion, GetPromotionResponse.class);

        return response;

    }

    @Override
    public GetPromotionResponse getPromotionById(int id) {

        Promotion promotion = getPromotion(id);

        GetPromotionResponse response = mapperService.forResponse().map(promotion, GetPromotionResponse.class);

        return response;
    }

    @Override
    public List<GetPromotionResponse> getAllPromotions() {

        List<Promotion> promotionList = promotionRepository.findAll();

        return promotionList.stream().map(promotion -> mapperService.forResponse().map(promotion, GetPromotionResponse.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public String deleteById(int id) {

        getPromotion(id);

        promotionRepository.deleteById(id);

        return "Promotion has been deleted with id: " + id;
    }

    private Promotion getPromotion(int id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new PromotionNotFoundException(PromotionMessage.PROMOTION_NOT_FOUND + id));
    }

}
