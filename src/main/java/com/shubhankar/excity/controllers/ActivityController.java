package com.shubhankar.excity.controllers;

import com.shubhankar.excity.models.Activity;
import com.shubhankar.excity.responses.ActivityResponse;
import com.shubhankar.excity.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excity/api")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/home")
    public String getMethod() {
        return "Hello, World!";
    }

    @GetMapping("/getActivity")
    public ActivityResponse get() {
        return new ActivityResponse(activityService.getActivity());
    }

    @GetMapping("/getActivityById/{id}")
    public ActivityResponse getById(@PathVariable Integer id) {
        return new ActivityResponse(activityService.getActivityById(id));
    }

    @GetMapping("/getActivitiesByType/{type}")
    public List<ActivityResponse> getByType(@PathVariable String type) {
        List<Activity> activities = activityService.getActivitiesByType(type);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping("/getActivitiesByParticipants/{numberOfParticipants}")
    public List<ActivityResponse> getByParticipants(@PathVariable int numberOfParticipants) {
        List<Activity> activities = activityService.getActivitiesByNumberOfPeopleRequired(numberOfParticipants);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping("/getActivitiesByPrice/{price}")
    public List<ActivityResponse> getByPrice(@PathVariable Double price) {
        List<Activity> activities = activityService.getActivitiesByPrice(price);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping("/getActivitiesByPrice/{start}/{end}")
    public List<ActivityResponse> getByPriceBetween(@PathVariable Double start, @PathVariable Double end) {
        List<Activity> activities = activityService.getActivitiesByPriceRange(start, end);
        return convertActivityToActivityResponse(activities);
    }

    private List<ActivityResponse> convertActivityToActivityResponse(List<Activity> activities) {
        List<ActivityResponse> result = new ArrayList<>();
        activities.stream().forEach(activity -> result.add(new ActivityResponse(activity)));

        return result;
    }
}
