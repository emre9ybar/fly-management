package com.flyroute.fly.controller;

import com.flyroute.fly.dto.request.promotionrequest.CreatePromotionRequest;
import com.flyroute.fly.dto.request.promotionrequest.UpdatePromotionRequest;
import com.flyroute.fly.dto.response.promotionresponse.GetPromotionResponse;
import com.flyroute.fly.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    @PostMapping
    ResponseEntity<GetPromotionResponse> save(@RequestBody CreatePromotionRequest createPromotionRequest){
        GetPromotionResponse response = promotionService.save(createPromotionRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    ResponseEntity<GetPromotionResponse> update(@RequestBody UpdatePromotionRequest updatePromotionRequest){
        GetPromotionResponse response = promotionService.update(updatePromotionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<GetPromotionResponse> getPromotionById(@PathVariable int id){
        GetPromotionResponse response = promotionService.getPromotionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<List<GetPromotionResponse>> getAllPromotions(){
        List<GetPromotionResponse> response = promotionService.getAllPromotions();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById(@PathVariable int id){
        String response = promotionService.deleteById(id);
        return ResponseEntity.ok(response);
    }

}
