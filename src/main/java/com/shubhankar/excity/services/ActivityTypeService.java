package com.shubhankar.excity.services;

import com.shubhankar.excity.models.ActivityType;
import com.shubhankar.excity.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {
    @Autowired
    ActivityTypeRepository activityTypeRepository;

    public List<ActivityType> getAllActivities() {
        return activityTypeRepository.findAll();
    }
}
