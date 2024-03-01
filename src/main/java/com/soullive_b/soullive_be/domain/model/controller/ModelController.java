package com.soullive_b.soullive_be.domain.model.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelDetailResponse;
import com.soullive_b.soullive_be.domain.model.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/{modelId}")
    public BaseResponse<ModelDetailResponse> getModelDetail(@PathVariable Long modelId) {
        return new BaseResponse<>(modelService.getModelDtail(modelId));
    }
}
