package com.fleetmanagementsystem.trackerservice.repository;

import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TrackerBrandRepository extends MongoRepository<TrackerBrand,String> {
}
