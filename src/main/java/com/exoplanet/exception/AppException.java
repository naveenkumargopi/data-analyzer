package com.exoplanet.exception;

import static com.exoplanet.exception.AppException.ErrorCode.*;

public class AppException extends RuntimeException {

    private ErrorCode code;

    public AppException(ErrorCode code, String msg) {
        super(msg);
        this.code = code;
    }

    public AppException(String msg) {
        super(msg);
        this.code = UNKNOWN;
    }

    public static AppException technicalError(String message) {
        return new AppException(TECHNICAL_ERROR, message);
    }

    public static AppException invalidRequest(String message) {
        return new AppException(INVALID_REQUEST, message);
    }


    public enum ErrorCode {

        INVALID_REQUEST,

        UNKNOWN,

        TECHNICAL_ERROR;
    }
}
