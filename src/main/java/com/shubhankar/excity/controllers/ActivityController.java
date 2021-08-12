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

    @GetMapping(value = "/getActivity", params = "id")
    public ActivityResponse getById(@RequestParam Integer id) {
        return new ActivityResponse(activityService.getActivityById(id));
    }

    @GetMapping(value = "/getActivities", params = "type")
    public List<ActivityResponse> getByType(@RequestParam String type) {
        List<Activity> activities = activityService.getActivitiesByType(type);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/getActivities", params = "participants")
    public List<ActivityResponse> getByParticipants(@RequestParam int participants) {
        List<Activity> activities = activityService.getActivitiesByNumberOfPeopleRequired(participants);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/getActivities", params = "price")
    public List<ActivityResponse> getByPrice(@RequestParam Double price) {
        List<Activity> activities = activityService.getActivitiesByPrice(price);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/getActivities", params = {"start", "end"})
    public List<ActivityResponse> getByPriceBetween(@RequestParam Double start, @RequestParam Double end) {
        List<Activity> activities = activityService.getActivitiesByPriceRange(start, end);
        return convertActivityToActivityResponse(activities);
    }

    private List<ActivityResponse> convertActivityToActivityResponse(List<Activity> activities) {
        List<ActivityResponse> result = new ArrayList<>();
        activities.stream().forEach(activity -> result.add(new ActivityResponse(activity)));

        return result;
    }
}
