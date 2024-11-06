package com.fleetmanagementsystem.trackerservice.repository;

import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TrackerModelRepository extends MongoRepository<TrackerModel,String> {
}
