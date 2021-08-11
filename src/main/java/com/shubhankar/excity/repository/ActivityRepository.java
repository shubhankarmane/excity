package com.shubhankar.excity.repository;

import com.shubhankar.excity.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query(nativeQuery = true, value = "select * from activity order by RAND() limit 1")
    public Activity getRandomActivity();

    public Activity findActivityById(int id);

    public List<Activity> findActivitiesByActivityTypeNameLike(String type);

    public List<Activity> findActivitiesByPeopleRequired(int numberOfPeople);

    public List<Activity> findActivitiesByPrice(Double price);

    public List<Activity> findActivitiesByPriceBetween(Double priceStart, Double priceEnd);
}