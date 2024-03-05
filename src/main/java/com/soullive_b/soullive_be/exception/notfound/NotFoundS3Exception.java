package com.soullive_b.soullive_be.exception.notfound;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_FOUND_S3;

public class NotFoundS3Exception extends NotFoundException {
    public NotFoundS3Exception() {
        super(NOT_FOUND_S3);
    }
}
