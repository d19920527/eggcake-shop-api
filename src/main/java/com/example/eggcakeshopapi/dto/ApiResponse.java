package com.example.eggcakeshopapi.dto;

public class ApiResponse <T>  {
    private boolean success;
    private T data;
    private String message;

    public ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(boolean success, String errorMessage) {
        this.success =success;
        this.message = errorMessage;
    }

    public static <T> ApiResponse<T> success(T data){
        return  new ApiResponse<>(true,data,"success");
    }
    public static <T>ApiResponse<T> fail(String errorMessage) {
        return new ApiResponse<>(false,errorMessage);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
