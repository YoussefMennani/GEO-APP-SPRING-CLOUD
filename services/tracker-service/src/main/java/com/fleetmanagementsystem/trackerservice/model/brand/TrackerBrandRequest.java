package com.fleetmanagementsystem.trackerservice.model.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TrackerBrandRequest(
        String id,
        @NotBlank(message = "brand origin country is required")
        String originCountry,
        @NotBlank(message = "brand name is required")
        String brandName
) {

}