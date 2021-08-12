package com.shubhankar.excity.repository;

import com.shubhankar.excity.models.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ActivityRepositoryTest {
    @Autowired
    ActivityRepository activityRepository;

    @Test
    public void printActivitiesTest() {
        List<Activity> activityList = activityRepository.findAll();
        for (var activity : activityList) {
            System.out.println(activity);
        }
    }

    @Test
    public void printRandomActivityTest() {
        Activity activity = activityRepository.getRandomActivity();
        System.out.println("activity = " + activity);
    }

    @Test
    public void printActivityByKeyTest() {
        Activity activity = activityRepository.findActivityById(10);
        System.out.println("activity = " + activity);
    }

    @Test
    public void printActivitiesByTypeTest() {
        List<Activity> activityList = activityRepository.findActivitiesByActivityTypeNameLike("education");
        for (var activity : activityList) {
            System.out.println("activity = " + activity);
        }
    }

    @Test
    public void printActivitiesByPeopleRequiredTest() {
        List<Activity> activityList = activityRepository.findActivitiesByPeopleRequired(3);
        for (var activity : activityList) {
            System.out.println("activity = " + activity);
        }
    }

    @Test
    public void printActivitiesByPriceTest() {
        List<Activity> activityList = activityRepository.findActivitiesByPrice(100.00);
        for (var activity : activityList) {
            System.out.println("activity = " + activity);
        }
    }

    @Test
    public void printActivitiesByPriceBetweenTest() {
        List<Activity> activityList = activityRepository.findActivitiesByPriceBetween(300.00, 400.00);
        for (var activity : activityList) {
            System.out.println("activity = " + activity);
        }
    }
}