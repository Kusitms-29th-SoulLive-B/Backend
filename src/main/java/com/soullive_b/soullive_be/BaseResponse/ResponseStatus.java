/**
 * ResponseStatus
 *
 * 0.0.1
 *
 * 2024.01.23
 *
 * Majorfolio
 */
package com.soullive_b.soullive_be.BaseResponse;

public interface ResponseStatus {
    int getCode();

    int getStatus();

    String getMessage();
}
