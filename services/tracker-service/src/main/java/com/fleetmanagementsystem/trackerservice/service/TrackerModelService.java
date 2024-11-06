package com.fleetmanagementsystem.trackerservice.service;

import com.fleetmanagementsystem.trackerservice.mapper.TrackerModelMapper;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModel;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelRequest;
import com.fleetmanagementsystem.trackerservice.model.model.TrackerModelResponse;
import com.fleetmanagementsystem.trackerservice.repository.TrackerModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TrackerModelService {

    private final TrackerModelRepository trackerModelRepository;
    private final TrackerModelMapper trackerModelMapper;

    public List<TrackerModelResponse> getAllTrackerModel() {
        return this.trackerModelRepository
                .findAll()
                .stream()
                .map(this.trackerModelMapper::fromTrackerModel)
                .collect(Collectors.toList());
    }



    public TrackerModel createTrackerModel(TrackerModelRequest trackerBrandRequest) {
        var trackerModel = this.trackerModelRepository.save(trackerModelMapper.toTrackerModel(trackerBrandRequest));
        return trackerModel;
    }

//    public TrackerBrandResponse getTrackerBrandById(String brandId) {
//        return  this.trackerModelRepository
//                .findById(brandId)
//                .map(this.trackerBrandMapper::fromTrackerBrand)
//                .orElseThrow(()-> new TrackerBrandNotFoundException(String.format(
//                        "No Brand found with the provided ID: %s", brandId
//                )));
//    }
//
//    public TrackerBrandResponse putTrackerBrandById(String brandId, TrackerBrandRequest newTrackerBrand) {
//
//        var brand =  this.trackerModelRepository.findById(brandId)
//                .orElseThrow(()-> new TrackerBrandNotFoundException(
//                        String.format("No customer found with the provided ID: %s", brandId)
//                ));
//
//        mergeTrackerBrand(brand,newTrackerBrand);
//        this.trackerModelRepository.save(brand);
//        return this.trackerBrandMapper.fromTrackerBrand(brand);
//    }
//
//
//    public void mergeTrackerBrand(TrackerBrand brand, TrackerBrandRequest trackerBrandRequest){
//
//        Optional.ofNullable(trackerBrandRequest.brandName())
//                .filter(StringUtils::isNotBlank)
//                .ifPresent(brand::setBrandName);
//
//        Optional.ofNullable(trackerBrandRequest.originCountry())
//                .filter(StringUtils::isNotBlank)
//                .ifPresent(brand::setOriginCountry);
//
//    }
//
//    public boolean deleteBrandById(String brandId) {
//       if( this.trackerModelRepository.existsById(brandId) ){
//           this.trackerModelRepository.deleteById(brandId);
//           return true;
//       } else {
//        throw new TrackerBrandNotFoundException("Brand not found with ID: " + brandId);
//    }
//    }
}
