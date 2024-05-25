package mx.uv.fca.restAPI.config;

import com.mongodb.MongoException;
import java.util.LinkedList;
import java.util.List;
import mx.uv.fca.restAPI.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationErrors(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new LinkedList<>();

        // Extraer los mensajes de error de la excepción
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }

        return new ErrorDTO("LIS001", "Error validación datos de entrada", errors);
    }

    @ExceptionHandler(MongoException.class)
    public ResponseEntity<ErrorDTO> handleMongoException(MongoException ex) {
        List<String> errors = new LinkedList<>();
        errors.add(ex.getMessage());

        ErrorDTO errorDTO = new ErrorDTO("DB001", "Error de conectividad con MongoDB", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
