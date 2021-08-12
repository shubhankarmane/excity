package com.shubhankar.excity.controllers;

import com.shubhankar.excity.models.Activity;
import com.shubhankar.excity.responses.ActivityResponse;
import com.shubhankar.excity.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excity/api/activities")
@Validated
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/get")
    public ActivityResponse get() {
        return new ActivityResponse(activityService.getActivity());
    }

    @GetMapping(value = "/get", params = "id")
    public ActivityResponse getById(@RequestParam @Min(value = 0, message = "Id cannot be negative") Integer id) {
        return new ActivityResponse(activityService.getActivityById(id));
    }

    @GetMapping(value = "/get", params = "type")
    public List<ActivityResponse> getByType(@RequestParam String type) {
        List<Activity> activities = activityService.getActivitiesByType(type);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/get", params = "participants")
    public List<ActivityResponse> getByParticipants(@RequestParam @Min(value = 0, message = "Id cannot be negative") int participants) {
        List<Activity> activities = activityService.getActivitiesByNumberOfPeopleRequired(participants);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/get", params = "price")
    public List<ActivityResponse> getByPrice(@RequestParam @Min(value = 0, message = "Id cannot be negative") Double price) {
        List<Activity> activities = activityService.getActivitiesByPrice(price);
        return convertActivityToActivityResponse(activities);
    }

    @GetMapping(value = "/get", params = {"start", "end"})
    public List<ActivityResponse> getByPriceBetween(@RequestParam @Min(value = 0, message = "Id cannot be negative") Double start, @RequestParam @Min(value = 0, message = "Id cannot be negative") Double end) {
        List<Activity> activities = activityService.getActivitiesByPriceRange(start, end);
        return convertActivityToActivityResponse(activities);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleConstraintViolationException(ValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    private List<ActivityResponse> convertActivityToActivityResponse(List<Activity> activities) {
        List<ActivityResponse> result = new ArrayList<>();
        activities.stream().forEach(activity -> result.add(new ActivityResponse(activity)));
        return result;
    }
}
