package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_ENTERPRISE_TYPE;

public class NotFoundEnterpriseTypeException extends NotFoundException {
    public NotFoundEnterpriseTypeException() {
        super(NOT_FOUND_ENTERPRISE_TYPE);
    }
}
