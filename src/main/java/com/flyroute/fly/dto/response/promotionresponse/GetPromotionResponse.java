package com.flyroute.fly.dto.response.promotionresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPromotionResponse {

    private int id;

    private String code;

    private String description;

    private int discount;

    private LocalDate startDate;

    private LocalDate endDate;

}
