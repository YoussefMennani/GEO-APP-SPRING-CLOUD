package com.fleetmanagementsystem.trackerservice.handler;

import com.fleetmanagementsystem.trackerservice.exception.TrackerBrandNotFoundException;
import com.fleetmanagementsystem.trackerservice.mapper.CustomResponse;
import com.fleetmanagementsystem.trackerservice.utils.ResponseTypeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomResponse<Map<String,String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        Map<String, String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomResponse<>(
                        "Validation failed for request parameters. Please check the errors.",
                        ResponseTypeEnum.FAILED,
                        errors
                ));
    }


    @ExceptionHandler(TrackerBrandNotFoundException.class)
    public ResponseEntity<CustomResponse<?>> handle(TrackerBrandNotFoundException exp) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new CustomResponse<>(exp.getMsg(),ResponseTypeEnum.FAILED,null)
                );
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<CustomResponse<?>> handleGeneralException(Exception ex) {
//        System.out.println(ex);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                new CustomResponse<>("An unexpected error occurred contact your administrator.",ResponseTypeEnum.FAILED,null)
//                );
//    }


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<CustomResponse<?>> handlRunTimeException(RuntimeException ex){
//        System.out.println(ex);
//
////        Map<String,String> errors = new HashMap<>();
////        errors.put("message","Internal Server Error contact your administrator ");
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(
//                        new CustomResponse<>("An unexpected error occurred contact your administrator.",ResponseTypeEnum.FAILED,null)
//                );
//    }
}
