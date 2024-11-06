package com.fleetmanagementsystem.trackerservice.mapper;

import com.fleetmanagementsystem.trackerservice.utils.ResponseTypeEnum;

import java.util.List;

public record CustomResponse<T>(
        String message,
        ResponseTypeEnum status,
        T data
        //long timestamp
) {
//        public CustomResponse(String message, String status, Object data) {
//                this(message, status, data, System.currentTimeMillis());
//        }
}
