package com.fleetmanagementsystem.trackerservice.model.model;


import com.fleetmanagementsystem.trackerservice.model.brand.TrackerBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "tracker_models")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackerModel {

    @Id
    private String id;

    private String modelName;
    private List<String> features;
    private String batteryLife;
    private String networkType;

    @DBRef(lazy = false) // Eagerly fetch the Brand data
    private TrackerBrand brand;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}