package com.fleetmanagementsystem.trackerservice.mapper;


import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandRequest;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandResponse;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModel;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelRequest;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelResponse;
import com.fleetmanagementsystem.trackerservice.repository.TrackerBrandRepository;
import com.fleetmanagementsystem.trackerservice.repository.TrackerModelRepository;
import com.fleetmanagementsystem.trackerservice.service.TrackerBrandService;
import com.fleetmanagementsystem.trackerservice.service.TrackerModelService;
import jakarta.ws.rs.NotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackerModelMapper {

    @Autowired
    private TrackerBrandRepository trackerBrandRepository;
    @Autowired
    private TrackerBrandMapper trackerBrandMapper;

    @Autowired
    private TrackerBrandService trackerBrandService;

    public TrackerModel toTrackerModel(TrackerModelRequest trackerModelRequest){
        if (trackerModelRequest == null){
            return null;
        }

        TrackerBrand brand = trackerBrandRepository
                .findById(trackerModelRequest.brand())
                .orElseThrow(() -> new NotFoundException("Model not found"));

//        TrackerBrandResponse trackerBrandResponse = trackerBrandService.findTrackerBrandById(trackerModelRequest.id());

        return TrackerModel.builder()
                .id(trackerModelRequest.id())
                .modelName(trackerModelRequest.modelName())
                .batteryLife(trackerModelRequest.batteryLife())
                .networkType(trackerModelRequest.networkType())
                .features(trackerModelRequest.features())
                .brand(brand)
                .build();
    }


    public TrackerModelResponse fromTrackerModel(TrackerModel trackerModel){
        if (trackerModel == null){
            return null;
        }

        TrackerBrand brand = trackerBrandRepository
                .findById(trackerModel.getBrand().getId())
                .orElseThrow(() -> new NotFoundException("Model not found"));

        TrackerBrandResponse trackerBrandResponse = trackerBrandService.findTrackerBrandById(trackerModel.getId());

        return new TrackerModelResponse(
                trackerModel.getId(),
                trackerModel.getModelName(),
                trackerModel.getNetworkType(),
                trackerModel.getBatteryLife(),
                trackerModel.getFeatures(),
                trackerBrandResponse
         );
    }

}
