package com.shubhankar.excity.controllers;

import com.shubhankar.excity.models.ActivityType;
import com.shubhankar.excity.services.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excity/api/types")
public class ActivityTypeController {
    @Autowired
    ActivityTypeService activityTypeService;

    @GetMapping("/get")
    public List<ActivityType> getAll() {
        return activityTypeService.getAllActivities();
    }
}
