package com.appdirect.skillassesment.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by RahulGupta on 2017-12-04.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {
    private boolean success;
    private String accountIdentifier;
    private String errorCode;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
