package com.soullive_b.soullive_be.domain.model.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.domain.model.dto.request.ModelByKeywordRequest;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelByKeywordResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelDetailResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelResponse;
import com.soullive_b.soullive_be.domain.model.service.ModelService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/{modelId}")
    public BaseResponse<ModelDetailResponse> getModelDetail(@PathVariable Long modelId) {
        return new BaseResponse<>(modelService.getModelDtail(modelId));
    }

    @GetMapping
    public BaseResponse<List<ModelResponse>> getModelList() {
        return new BaseResponse<>(modelService.getModelList());
    }

    @PostMapping("/keyword")
    public BaseResponse<List<ModelByKeywordResponse>> getModelsByKeyword(@RequestBody ModelByKeywordRequest modelByKeywordRequest){
        return new BaseResponse<>(modelService.getModelsByKeyword(modelByKeywordRequest));
    }
}
