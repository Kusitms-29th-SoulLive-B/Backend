package com.soullive_b.soullive_be.domain.usermodelselect.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserModelSelectRequest {
    Long modelId;
    Long userId;
}
