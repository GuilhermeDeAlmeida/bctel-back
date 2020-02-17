package com.bctel.back.enums;

public enum TalkMorePlan {
    FALE_MAIS_30(30), FALE_MAIS_60(60), FALE_MAIS_120(120),
    ;

    private final int plan;

    TalkMorePlan(int plan) {
        this.plan = plan;
    }

    public Integer getPlan() {
        return plan;
    }
}
