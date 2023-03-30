package com.aprianfirlanda.smarthomestay.error.clienterror;

public class NotFoundError extends Exception{

    private final Integer statusCode;
    private final String name;

    public NotFoundError(String message) {
        super(message);
        this.statusCode = 404;
        this.name = "Not Found";
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getName() {
        return name;
    }
}
