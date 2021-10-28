package com.search.fifa.web.dto;

import com.search.fifa.domain.MatchType;
import lombok.Getter;

@Getter
public class MatchTypeDto {
    private int matchtype;
    private String desc;

    public MatchType toEntity() {
        return MatchType.builder()
                .matchType(matchtype)
                .desc(desc).build();
    }
}