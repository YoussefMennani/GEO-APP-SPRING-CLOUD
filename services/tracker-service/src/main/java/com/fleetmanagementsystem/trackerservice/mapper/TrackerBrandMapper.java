package com.fleetmanagementsystem.trackerservice.mapper;


import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandRequest;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandResponse;
import org.springframework.stereotype.Component;

@Component
public class TrackerBrandMapper {

    public TrackerBrand toTrackerBrand(TrackerBrandRequest trackerBrandRequest){
        if (trackerBrandRequest == null){
            return null;
        }
        return TrackerBrand.builder()
                .id(trackerBrandRequest.id())
                .brandName(trackerBrandRequest.brandName())
                .originCountry(trackerBrandRequest.originCountry())
                .build();
    }


    public TrackerBrandResponse fromTrackerBrand(TrackerBrand trackerBrand){
        if (trackerBrand == null){
            return null;
        }
        return new TrackerBrandResponse(
                trackerBrand.getId(),
                trackerBrand.getOriginCountry(),
                trackerBrand.getBrandName()
         );
    }

}
