package com.shubhankar.excity.services;

import com.shubhankar.excity.models.Activity;
import com.shubhankar.excity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity getActivity() {
        return activityRepository.getRandomActivity();
    }

    public Activity getActivityById(Integer id) {
        return activityRepository.getById(id);
    }

    public List<Activity> getActivitiesByType(String type) {
        return activityRepository.findActivitiesByActivityTypeNameLike(type);
    }

    public List<Activity> getActivitiesByNumberOfPeopleRequired(int numberOfPeople) {
        return activityRepository.findActivitiesByPeopleRequired(numberOfPeople);
    }

    public List<Activity> getActivitiesByPrice(Double price) {
        return activityRepository.findActivitiesByPrice(price);
    }

    public List<Activity> getActivitiesByPriceRange(Double start, Double end) {
        return activityRepository.findActivitiesByPriceBetween(start, end);
    }
}
