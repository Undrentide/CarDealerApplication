package carDealerApplication.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NoSuchElementFoundException.class, EmptyResultDataAccessException.class, IllegalStateException.class, EntityNotFoundException.class})
    ErrorResponse nullResult(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ErrorResponse.builder(exception, HttpStatusCode.valueOf(404), "Wrong ID, maboy, this thing doesn't exist :C").build();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUnexpectedException(Exception ex,
                                                               WebRequest request) {

        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {InvalidJwtException.class})
    protected ResponseEntity<Object> handleEntityNotFoundException(InvalidJwtException ex, WebRequest request) {

        log.debug(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}