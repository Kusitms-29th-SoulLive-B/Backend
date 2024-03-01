package com.soullive_b.soullive_be.domain.issue.dto.response;

import com.soullive_b.soullive_be.domain.issue.entity.Issue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class IssueResponse {
    private Integer negative;

    private Integer positive;

    private String content;

    private String tag;

    public static IssueResponse of(Issue issue){
        return IssueResponse.builder()
                .positive(issue.getPositive())
                .negative(issue.getNegative())
                .content(issue.getContent())
                .tag(issue.getTag())
                .build();
    }
}
