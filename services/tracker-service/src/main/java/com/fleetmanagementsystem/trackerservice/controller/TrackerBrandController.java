package com.fleetmanagementsystem.trackerservice.controller;


import com.fleetmanagementsystem.trackerservice.mapper.CustomResponse;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandRequest;
import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrandResponse;
import com.fleetmanagementsystem.trackerservice.service.TrackerBrandService;
import com.fleetmanagementsystem.trackerservice.utils.ResponseTypeEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tracker/brands")
public class TrackerBrandController {

    private final TrackerBrandService trackerBrandService;

    @PostMapping
    public ResponseEntity<CustomResponse<TrackerBrand>> createTrackerBrand(
            @RequestBody @Valid TrackerBrandRequest trackerBrandRequest
    ){
        return ResponseEntity.ok(
                new CustomResponse<>(
                        "brand created with success",
                        ResponseTypeEnum.SUCCESS,
                        this.trackerBrandService.createTrackerBrand(trackerBrandRequest)
                )
        );
    }


    @GetMapping("gelAll")
    public ResponseEntity<CustomResponse<List<TrackerBrandResponse>>> getAllBrands(){
        CustomResponse customResponse = new CustomResponse(
                "Result retrieved successfully",
                ResponseTypeEnum.SUCCESS,
                this.trackerBrandService.findAllTrackerBrand()
                );
        return ResponseEntity.ok(customResponse);
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<CustomResponse<TrackerBrandResponse>> getBrandById(
            @PathVariable("brandId") String brandId
    ){
        CustomResponse customResponse = new CustomResponse(
                "Result retrieved successfully",
                ResponseTypeEnum.SUCCESS,
                this.trackerBrandService.findTrackerBrandById(brandId)
        );
        return ResponseEntity.ok(customResponse);
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<CustomResponse<TrackerBrandResponse>> putBrandById(
            @PathVariable("brandId") String brandId,
            @RequestBody @Valid TrackerBrandRequest brandRequest
    ){
        return ResponseEntity.ok(new CustomResponse<>(
                "brand updated with success",
                ResponseTypeEnum.SUCCESS,
                this.trackerBrandService.putTrackerBrandById(brandId, brandRequest)
        ));
    }


    @DeleteMapping("/{brandId}")
    public ResponseEntity<CustomResponse<?>> deleteBrandById(@PathVariable("brandId") String brandId){

        this.trackerBrandService.deleteBrandById(brandId);
        return ResponseEntity.ok(new CustomResponse<>(
                "Brand deleted successfully" ,
                ResponseTypeEnum.SUCCESS ,
                null  // No specific data to return after deletion
        ));
    }
}
