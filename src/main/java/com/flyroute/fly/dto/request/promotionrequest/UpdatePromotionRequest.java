package com.flyroute.fly.dto.request.promotionrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePromotionRequest {

    private int id;

    private String code;

    private String description;

    private int discount;

    private LocalDate startDate;

    private LocalDate endDate;

}
