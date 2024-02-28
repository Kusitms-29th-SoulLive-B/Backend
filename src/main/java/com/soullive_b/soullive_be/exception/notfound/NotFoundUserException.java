package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_USER;

public class NotFoundUserException extends NotFoundException {
    public NotFoundUserException() {
        super(NOT_FOUND_USER);
    }
}
