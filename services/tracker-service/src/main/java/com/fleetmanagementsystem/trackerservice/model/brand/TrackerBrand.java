package com.fleetmanagementsystem.trackerservice.model.brand;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tracker_brands")
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a no-arguments constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Builder
@Getter
@Setter
public class TrackerBrand {

    @Id
    private String id;

    private String originCountry;
    private String brandName;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
