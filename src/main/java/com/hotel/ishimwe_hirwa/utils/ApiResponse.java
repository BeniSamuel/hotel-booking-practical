package com.hotel.ishimwe_hirwa.utils;

public class ApiResponse <T> {
    public boolean success;
    public String message;
    public T data;

    public ApiResponse (boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
