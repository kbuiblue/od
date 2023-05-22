package com.onlydan.od.exceptions;

import org.springframework.http.HttpStatus;

public class AllExceptions {

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException InvalidInput() {
        return badRequest("INVALID INPUT", "Invalid input, please try again.");
    }

    public static ResponseException ProductInfoNotFound() {
        return notFound("PRODUCT NOT FOUND", "Oops! This product does not exist.");
    }

    public static ResponseException CountryNotFound() {
        return notFound("COUNTRY NOT FOUND", "Sorry, this country does not exist in our database.");
    }
}
