package com.erremauro.restfulapi.type;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    public boolean isOk;
    public int code;
    public String status;
    public String message;
    public Object data;
    public List<String> errors;
    
    public static ApiResponse ok(String message) {
        return new ApiResponse()
                .withStatus(200, "OK")
                .withMessage(message);
    }
    
    public static ApiResponse ok() {
        return ApiResponse.ok("Success");
    }
    
    public static ApiResponse ok(Object data) {
        return ApiResponse.ok().encode(data);
    }
    
    public static ApiResponse badRequest(String message) {
        return new ApiResponse()
                .withStatus(400, "Bad Request")
                .withMessage(message);
    }
    
    public static ApiResponse created(String message) {
        return new ApiResponse()
                .withStatus(201, "Created")
                .withMessage(message);
    }
    
    public static ApiResponse notFound(String message) {
        return new ApiResponse()
                .withStatus(404, "Not Found")
                .withMessage(message);
    }
    
    public static ApiResponse notModified(String message) {
        return new ApiResponse()
                .withStatus(304, "Not Modified")
                .withMessage(message);
    }
    
    public static ApiResponse permissionDenied(String message) {
        return new ApiResponse()
                .withStatus(550, "Permission Denied")
                .withMessage(message);
    }
    
    public ApiResponse() {}
    
    public ApiResponse withStatus(int code, String status) {
        this.isOk = code >= 200 && code < 300;
        this.code = code;
        this.status = status;
        return this;
    }
    
    public ApiResponse withMessage(String message) {
        this.message = message;
        return this;
    }
    
    public ApiResponse withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }
    
    public ApiResponse addError(String error) {
        if (this.errors == null) this.errors = new ArrayList<>();
        this.errors.add(error);
        return this;
    }
    
    public ApiResponse encode(Object data) {
        this.data = data;
        return this;
    }
}
