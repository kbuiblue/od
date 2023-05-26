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
        return notFound("PRODUCT NOT FOUND", "Sorry, this product does not exist.");
    }

    public static ResponseException ProductInfoAlreadyExists() {
        return badRequest("PRODUCT ALREADY EXISTS", "Oops! This product already exists.");
    }

    public static ResponseException CountryNotFound() {
        return notFound("COUNTRY NOT FOUND", "Sorry, this country does not exist in our database.");
    }

    public static ResponseException AccountNameAlreadyExists() {
        return badRequest("NAME ALREADY EXISTS", "Sorry, this account name already exists.");
    }

    public static ResponseException AccountNotFound() {
        return notFound("ACCOUNT NOT FOUND", "Sorry, this account does not exist.");
    }

    public static ResponseException RoleAssignmentNotFound() {
        return notFound("ROLE ASSIGNMENT NOT FOUND", "Sorry, this role assignment does not exist.");
    }
}
