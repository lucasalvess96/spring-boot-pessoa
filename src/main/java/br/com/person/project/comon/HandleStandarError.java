package br.com.person.project.comon;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandleStandarError {
    @ExceptionHandler(EntityNotFoundExceptiion.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundExceptiion e, HttpServletRequest httpServletRequest){
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setError("Recurso não encontrado");
        standardError.setMessage(e.getMessage());
        standardError.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidatition.ErrorDto> handleException(MethodArgumentNotValidException ex) {
        ErroValidatition.ErrorDto dto = new ErroValidatition.ErrorDto(HttpStatus.BAD_REQUEST, "Validation error");
        dto.setDetailedMessages(ex.getBindingResult().getAllErrors().stream()
                .map(err -> err.unwrap(ConstraintViolation.class))
                .map(err -> String.format(err.getMessage()))
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
