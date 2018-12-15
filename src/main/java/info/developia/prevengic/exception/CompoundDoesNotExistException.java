package info.developia.prevengic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Compound not found")
public class CompoundDoesNotExistException extends RuntimeException {
}
