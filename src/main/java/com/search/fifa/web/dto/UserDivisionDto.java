package com.search.fifa.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class UserDivisionDto {
    private int matchType;
    private String division;
    private String achievementDate;
}
