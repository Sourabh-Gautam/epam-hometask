package com.epam.microservices.libraryservice.globalexceptionhandling;

public class ApiErrorResponse {

    private String error;
    private int status;
    private String message;
    private long timeStamp;
    private String path;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String error, int status, String message, long timeStamp) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "error='" + error + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", path=" + path +
                '}';
    }

}
