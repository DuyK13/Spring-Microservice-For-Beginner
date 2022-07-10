package c99.ams.oauthservice.interceptor;

import c99.ams.oauthservice.dto.response.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 1:45 PM
 */
@RestControllerAdvice
public class HandleError extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(HandleError.class);

    private final LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));

    private final ObjectMapper objectMapper;

    @Autowired
    public HandleError(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<?> existsEntityExceptionHandler(EntityException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, now);
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(objectMapper.writeValueAsString(errorResponse), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<?> existsFeignExceptionBadRequestHandler(FeignException.BadRequest ex) throws JsonProcessingException {
        String message = ex.getMessage().split(": ")[1].replaceAll("[\\[\\]]", "");
        ErrorResponse errorResponse = objectMapper.readValue(message, ErrorResponse.class);
        logger.error(message, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<?> existsFeignExceptionNotFoundHandler(FeignException.NotFound ex) throws JsonProcessingException {
        String message = ex.getMessage().split(": ")[1].replaceAll("[\\[\\]]", "");
        ErrorResponse errorResponse = objectMapper.readValue(message, ErrorResponse.class);
        logger.error(message, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, now);
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(objectMapper.writeValueAsString(errorResponse), HttpStatus.BAD_REQUEST);
    }
}
