package com.fleetmanagementsystem.trackerservice.model.brand;

import jakarta.validation.constraints.NotNull;

public record TrackerBrandResponse(
        String id,
        String originCountry,
        String brandName
) {
}
