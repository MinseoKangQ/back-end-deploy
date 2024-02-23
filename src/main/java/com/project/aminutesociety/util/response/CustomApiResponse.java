package com.project.aminutesociety.util.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomApiResponse<T> {

    private static final int OK = 200;
    private static final int BAD_REQUEST = 400;
    private static final int NOT_FOUND = 404;

    private int status;
    private T data;
    private String message;

    public static <T> CustomApiResponse<T> createSuccessWithData(T data, String message) {
        return new CustomApiResponse<>(OK, data, message);
    }

    public static <T> CustomApiResponse<T> createSuccessWithoutData(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

    public static <T> CustomApiResponse<T> createFailWithoutData(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

    public static <T> CustomApiResponse<T> loginSuccessWithoutData(T data, String message){
        return new CustomApiResponse<>(OK, data, message);
    }

    public static <T> CustomApiResponse<T> loginFailWithoutData(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

    public static<T> CustomApiResponse<T> checkUserIdFailWithoutData(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

    public static<T> CustomApiResponse<T> checkUserIdSuccessWithData(T data, String message) {
        return new CustomApiResponse<>(OK, data, message);
    }

    public static<T> CustomApiResponse<T> readCategoriesSuccessWithData(T data, String message) {
        return new CustomApiResponse<>(OK, data, message);
    }

    public static<T> CustomApiResponse<T> readCategoriesFailWithoutData(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

    public static <T> CustomApiResponse<T> createFailWithData(int status, BindingResult bindingResult) {
        List<String> errorMessages = bindingResult.getAllErrors().stream()
                .map(ObjectError::getObjectName)
                .collect(Collectors.toList());

        String combinedMessage = String.join("; ", errorMessages);

        return new CustomApiResponse<>(status, null, combinedMessage);
    }

    public CustomApiResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

}
