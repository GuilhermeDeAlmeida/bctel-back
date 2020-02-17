package com.bctel.back.models;

import com.bctel.back.enums.TalkMorePlan;

public class Simulation {
    private Integer origin, destination, time, plan;
    private Double withPlan, withoutPlan;

    public Simulation(Integer origin, Integer destination, Integer time, Integer plan) {
        this.origin = origin;
        this.destination = destination;
        this.time = time;
        this.plan = plan;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getWithPlan() {
        return withPlan;
    }

    public void setWithPlan(Double withPlan) {
        this.withPlan = withPlan;
    }

    public Double getWithoutPlan() {
        return withoutPlan;
    }

    public void setWithoutPlan(Double withoutPlan) {
        this.withoutPlan = withoutPlan;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }
}
