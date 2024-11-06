package com.fleetmanagementsystem.trackerservice.controller;


import com.fleetmanagementsystem.trackerservice.mapper.CustomResponse;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModel;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelRequest;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelResponse;
import com.fleetmanagementsystem.trackerservice.service.TrackerModelService;
import com.fleetmanagementsystem.trackerservice.utils.ResponseTypeEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tracker/models")
public class TrackerModelController {

    private final TrackerModelService trackerModelService;



    @GetMapping("gelAll")
    public ResponseEntity<CustomResponse<List<TrackerModelResponse>>> getAllBrands(){
        CustomResponse customResponse = new CustomResponse(
                "Result retrieved successfully",
                ResponseTypeEnum.SUCCESS,
                this.trackerModelService.getAllTrackerModel()
                );
        return ResponseEntity.ok(customResponse);
    }


    @PostMapping
    public ResponseEntity<CustomResponse<TrackerModel>> createTrackerBrand(
            @RequestBody @Valid TrackerModelRequest trackerModelRequest
    ){
        return ResponseEntity.ok(
                new CustomResponse<>(
                        "model brand created with success",
                        ResponseTypeEnum.SUCCESS,
                        this.trackerModelService.createTrackerModel(trackerModelRequest)
                )
        );
    }
//
//
//    @GetMapping("/{brandId}")
//    public ResponseEntity<CustomResponse<TrackerBrandResponse>> getBrandById(
//            @PathVariable("brandId") String brandId
//    ){
//        CustomResponse customResponse = new CustomResponse(
//                "Result retrieved successfully",
//                ResponseTypeEnum.SUCCESS,
//                this.trackerBrandService.getTrackerBrandById(brandId)
//        );
//        return ResponseEntity.ok(customResponse);
//    }
//
//    @PutMapping("/{brandId}")
//    public ResponseEntity<CustomResponse<TrackerBrandResponse>> putBrandById(
//            @PathVariable("brandId") String brandId,
//            @RequestBody @Valid TrackerBrandRequest brandRequest
//    ){
//        return ResponseEntity.ok(new CustomResponse<>(
//                "brand updated with success",
//                ResponseTypeEnum.SUCCESS,
//                this.trackerBrandService.putTrackerBrandById(brandId, brandRequest)
//        ));
//    }
//
//
//    @DeleteMapping("/{brandId}")
//    public ResponseEntity<CustomResponse<?>> deleteBrandById(@PathVariable("brandId") String brandId){
//
//        this.trackerBrandService.deleteBrandById(brandId);
//        return ResponseEntity.ok(new CustomResponse<>(
//                "Brand deleted successfully" ,
//                ResponseTypeEnum.SUCCESS ,
//                null  // No specific data to return after deletion
//        ));
//    }
}
