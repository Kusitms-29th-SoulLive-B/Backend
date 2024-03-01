package com.soullive_b.soullive_be.exception.notfound;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_MODEL;

public class NotFoundModelException extends NotFoundException {
    public NotFoundModelException() {
        super(NOT_FOUND_MODEL);
    }
}
