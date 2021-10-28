package com.search.fifa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class MatchType {

    @Id
    @Column
    private int matchType;

    @Column
    private String desc;

    @Builder
    public MatchType(int matchType, String desc) {
        this.matchType = matchType;
        this.desc = desc;
    }
}