package com.soullive_b.soullive_be.domain.model.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.domain.model.dto.request.ModelByKeywordRequest;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelByKeywordResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelDetailResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.SearchModelResponse;
import com.soullive_b.soullive_be.domain.model.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
@Tag(name= "model", description = "모델 관련 api")
public class ModelController {
    private final ModelService modelService;

    @Operation(summary = "특정 모델의 상세페이지 데이터 조회하기", description = """
            모델 목록 조회시 반환되는 modelId값을 url 파라미터에 담아주세요.
            
            모델의 상세페이지에 보여질 정보들이 반환됩니다.
            
            연령대별 선호도 데이터는 일단 숫자로 반환시켜놨는데 사용하지 않고 그냥 프론트에서 더미 이미지로 진행하셔도 됩니다!
            
            피그마 데이터와 유사하게 더미 세팅해논 모델은 modelId값 1 사용하시면 됩니다 (모델 "고윤정" 데이터)
            """)
    @GetMapping("/{modelId}")
    public BaseResponse<ModelDetailResponse> getModelDetail(@PathVariable Long modelId) {
        return new BaseResponse<>(modelService.getModelDtail(modelId));
    }

    @Operation(summary = "모델 목록페이지 데이터 조회하기", description = """
            전체 모델의 정보를 반환합니다.
            """)
    @GetMapping
    public BaseResponse<List<ModelResponse>> getModelList() {
        return new BaseResponse<>(modelService.getModelList());
    }

    @Operation(summary = "키워드와 관련된 모델광고들 데이터를 조회", description = """
            홈 화면에서 키워드 선택시 해당 키워드와 관련된 모델광고들 데이터를 조회할때 사용됩니다.
                        
            request body에 키워드를 담아서 요청해주세요.
            담을 수 있는 키워드 목록
            (브랜드 평판 1위, 떠오르는, 고급정스러운, 친근한, 감각있는, 부드러운, 성실한, 밝은, 열정적인, 힙한, 상큼한, 활기찬, 유머스러운, 청순한)
            """)
    @PostMapping("/keyword")
    public BaseResponse<List<ModelByKeywordResponse>> getModelsByKeyword(@Validated @RequestBody ModelByKeywordRequest modelByKeywordRequest){
        return new BaseResponse<>(modelService.getModelsByKeyword(modelByKeywordRequest));
    }

    @GetMapping("/search")
    public BaseResponse<List<SearchModelResponse>> searchModelsByKeyword(@RequestParam String keyword) {
        List<SearchModelResponse> searchModelResponses = modelService.searchModelsByKeyword(keyword);
        return new BaseResponse<>(searchModelResponses);
    }
}
