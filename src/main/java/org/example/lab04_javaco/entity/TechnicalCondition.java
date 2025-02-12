package org.example.lab04_javaco.entity;

import lombok.Getter;

@Getter
public enum TechnicalCondition {
    REPAIR("Ремонт"),
    SIMPLE("Простий"),
    WORKING("В роботі");

    private final String description;

    TechnicalCondition(String description) {
        this.description = description;
    }

}


