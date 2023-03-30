package com.aprianfirlanda.smarthomestay.error.clienterror;

public class BadRequestError extends Exception {


    private final Integer statusCode;
    private final String name;
    private final Object errors;

    public BadRequestError(Object errors, String message) {
        super(message);
        this.statusCode = 400;
        this.name = "Bad Request";
        this.errors = errors;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getName() {
        return name;
    }

    public Object getErorrs() {
        return errors;
    }
}
