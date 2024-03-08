package com.soullive_b.soullive_be.exception.notfound;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_SELECT;

public class NotFoundSelectException extends NotFoundException {
    public NotFoundSelectException() {
        super(NOT_FOUND_SELECT);
    }
}
