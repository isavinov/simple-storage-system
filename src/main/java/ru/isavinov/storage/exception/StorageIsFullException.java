package ru.isavinov.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StorageIsFullException extends RuntimeException{

    public StorageIsFullException(String message) {
        super(message);
    }

    public StorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
