package dev.gabrafo.EsportsAI.error;

import dev.gabrafo.EsportsAI.error.address.PostalCodeNotFoundException;
import dev.gabrafo.EsportsAI.error.general.UnavailableClientException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UnavailableClientException.class)
    private ResponseEntity<ErrorMessage> unavailableClientExceptionHandler(UnavailableClientException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(PostalCodeNotFoundException.class)
    private ResponseEntity<ErrorMessage> postalCodeNotFoundExceptionHandler(PostalCodeNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));

        ErrorMessage error = new ErrorMessage(
                HttpStatus.BAD_REQUEST,
                "Validation error: " + errorMessage
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        String errorMessage = "Data integrity violation.";

        if (e.getCause() instanceof ConstraintViolationException constraintEx) {
            boolean emailUniqueViolated = constraintEx.getConstraintViolations().stream()
                    .anyMatch(violation -> violation.getMessage().contains("EMAIL_UNIQUE"));
            if (emailUniqueViolated) {
                errorMessage = "E-mail already in use.";
            }
        }

        ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT, errorMessage);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}