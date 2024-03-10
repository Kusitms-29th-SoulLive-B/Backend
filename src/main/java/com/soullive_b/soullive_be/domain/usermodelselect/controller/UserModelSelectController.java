package com.soullive_b.soullive_be.domain.usermodelselect.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.domain.usermodelselect.dto.request.UserModelSelectRequest;
import com.soullive_b.soullive_be.domain.usermodelselect.service.UserModelSelectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scrap")
@RequiredArgsConstructor
@Slf4j
public class UserModelSelectController {

    private final UserModelSelectService userModelSelectService;

    @PostMapping
    public BaseResponse<String> saveScrap(@RequestBody UserModelSelectRequest req) {
        userModelSelectService.createScrap(req.getModelId(), req.getUserId());
        return new BaseResponse<>("하트를 눌렀습니다.");
    }

    @DeleteMapping
    public BaseResponse<String> deleteScrap(@RequestBody UserModelSelectRequest req) {
        userModelSelectService.cancelScrap(req.getModelId(), req.getUserId());
        return new BaseResponse<>("하트를 취소했습니다");
    }
}
