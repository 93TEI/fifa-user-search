package com.search.fifa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Division {
    @Id
    private int matchType;

    private String division;

    private String achievementDate;

    @Builder
    public Division(int matchType, String division, String achievementDate)
    {
        this.division = division;
        this.matchType = matchType;
        this.achievementDate = achievementDate;
    }
}
