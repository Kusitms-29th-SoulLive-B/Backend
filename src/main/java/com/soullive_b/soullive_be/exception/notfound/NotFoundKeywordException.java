package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_KEYWORD;

public class NotFoundKeywordException extends NotFoundException {
    public NotFoundKeywordException() {
        super(NOT_FOUND_KEYWORD);
    }
}
