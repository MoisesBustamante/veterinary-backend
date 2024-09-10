package com.softcaribe.veterinary.mensajes;

public record ResponseMessage<T>(
        int code,
        String message,
        T    data
) {
}
