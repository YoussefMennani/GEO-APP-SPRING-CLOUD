package com.fleetmanagementsystem.trackerservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TrackerBrandNotFoundException extends RuntimeException {

    private final String msg;
}
