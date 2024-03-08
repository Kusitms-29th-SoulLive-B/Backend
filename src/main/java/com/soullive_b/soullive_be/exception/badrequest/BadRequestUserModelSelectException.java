package com.soullive_b.soullive_be.exception.badrequest;

import static com.soullive_b.soullive_be.exception.ExceptionContent.BAD_REQUEST_SELECT;

public class BadRequestUserModelSelectException extends BadRequestException {
    public BadRequestUserModelSelectException() {
        super(BAD_REQUEST_SELECT);
    }
}
