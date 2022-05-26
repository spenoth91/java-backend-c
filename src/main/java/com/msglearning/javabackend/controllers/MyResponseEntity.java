package com.msglearning.javabackend.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * the default response entity for REST services.
 * @param <T> the type of the data
 */

@Data
@AllArgsConstructor
public class MyResponseEntity<T> {
    private boolean success;
    private String message;
    private T data;

    /**
     * builder for a general success message.
     *
     * @return an instance of MyResponseEntity
     */
    public static <T> MyResponseEntity<T> buildSuccessMessage() {
        return new MyResponseEntity<>(true, "success", null);
    }

    /**
     * builder for a success response containing data
     * @param <T> the type of the data
     * @return an instance of MyResponseEntity
     */
    public static <T> MyResponseEntity<T> buildSuccessMessage(T data) {
        return new MyResponseEntity<>(true, "success", data);
    }

    /**
     * builder for an error response containing a message and data
     * @param <T> the type of the data
     * @return an instance of MyResponseEntity
     */
    public static <T> MyResponseEntity<T> buildErrorMessage(String errorMessage, T data) {
        return new MyResponseEntity<>(false, errorMessage, data);
    }

    /**
     * builder for an error response containing a message
     * @return an instance of MyResponseEntity
     */
    public static <T> MyResponseEntity<T> buildErrorMessage(String errorMessage) {
        return new MyResponseEntity<>(false, errorMessage, null);
    }
}
