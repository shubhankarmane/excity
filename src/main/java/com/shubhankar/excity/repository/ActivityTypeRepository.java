package com.shubhankar.excity.repository;

import com.shubhankar.excity.models.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {
}
