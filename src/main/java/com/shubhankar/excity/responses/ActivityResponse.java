package com.shubhankar.excity.responses;

import com.shubhankar.excity.models.Activity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityResponse {
    private Integer id;
    private String activity;
    private Integer participants;
    private Double cost;
    private String type;

    public ActivityResponse(Activity activity) {
        this.id = activity.getId();
        this.activity = activity.getDescription();
        this.participants = activity.getPeopleRequired();
        this.cost = activity.getPrice();
        this.type = activity.getActivityType().getName();
    }
}
