package com.fleetmanagementsystem.trackerservice.model.model;

import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TrackerModelResponse(
        String id,
        String modelName,
        String networkType,
        String batteryLife,
        List<String> features,
        TrackerBrandResponse brand
) {
}
