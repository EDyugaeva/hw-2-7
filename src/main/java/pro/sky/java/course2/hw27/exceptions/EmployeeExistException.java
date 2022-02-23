package pro.sky.java.course2.hw27.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeExistException extends RuntimeException {
    public EmployeeExistException(String message) {
        super(message);
    }

}
