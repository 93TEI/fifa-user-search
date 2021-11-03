package com.search.fifa.web.dto;

import lombok.*;

@Data
@Getter
public class UserDivisionResponseDto {
    private int matchType;
    private String division;
    private String date;

    @Builder
    public UserDivisionResponseDto(int matchType, String division, String date)
    {
        this.matchType = matchType;
        this.division = division;
        this.date = date;
    }
}
