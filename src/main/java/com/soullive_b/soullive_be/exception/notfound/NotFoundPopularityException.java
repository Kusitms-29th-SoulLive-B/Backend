package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_POPULARITY;

public class NotFoundPopularityException extends NotFoundException {

    public NotFoundPopularityException() {
        super(NOT_FOUND_POPULARITY);
    }
}
