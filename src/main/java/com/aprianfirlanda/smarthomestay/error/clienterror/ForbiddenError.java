package com.aprianfirlanda.smarthomestay.error.clienterror;

public class ForbiddenError extends Exception{

    private final Integer statusCode;
    private final String name;

    public ForbiddenError(String message) {
        super(message);
        this.statusCode = 403;
        this.name = "Forbidden";
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getName() {
        return name;
    }
}
