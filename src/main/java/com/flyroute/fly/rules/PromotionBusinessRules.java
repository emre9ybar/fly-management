package com.flyroute.fly.rules;

import com.flyroute.fly.entity.Promotion;
import com.flyroute.fly.message.PromotionMessage;
import com.flyroute.fly.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PromotionBusinessRules {

    private final PromotionRepository promotionRepository;

    public void checkIfCodeExists(String code) {

        Optional<Promotion> optionalPromotion = promotionRepository.findByCode(code);

        if (optionalPromotion.isPresent()){
            throw new RuntimeException(PromotionMessage.CODE_ALREADY_EXISTS);
        }

    }

}
