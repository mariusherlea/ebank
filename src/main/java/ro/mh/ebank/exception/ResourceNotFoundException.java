package ro.mh.ebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(Long id) {
        System.out.println("Id non-existent "+ id);
    }
}