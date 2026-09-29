package barbershop_vk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> handleRuntime(RuntimeException e) {

            HttpStatus status;

            switch (e.getMessage()) {

                case "Horário indisponível.":
                    status = HttpStatus.CONFLICT;
                    break;

                case "Cliente não encontrado":
                case "Barbeiro não encontrado":
                case "Serviço não encontrado":
                    status = HttpStatus.NOT_FOUND;
                    break;

                default:
                    status = HttpStatus.BAD_REQUEST;
            }

            return ResponseEntity.status(status).body(Map.of(
                    "timestamp", LocalDateTime.now(),
                    "status", status.value(),
                    "error", e.getMessage()
            ));
        }
    }

