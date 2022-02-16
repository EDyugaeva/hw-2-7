package pro.sky.java.course2.hw27.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongTypeOfNameException extends RuntimeException {
    public WrongTypeOfNameException(String message) {
        super(message);
    }
}
