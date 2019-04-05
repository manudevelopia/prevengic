package info.developia.prevengic.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity handleException(UserDoesNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Error(e.getMessage()));
    }

    @ExceptionHandler(CompoundDoesNotExistException.class)
    public ResponseEntity handleException(CompoundDoesNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Error(e.getMessage()));
    }

    @Data
    @AllArgsConstructor
    private class Error {
        private final String error;
    }

}
