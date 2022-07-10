package c99.ams.userservice.utils.exceptionhandler;

import c99.ams.userservice.dto.response.ErrorResponse;
import c99.ams.userservice.utils.exceptionhandler.bind.BadRequestException;
import c99.ams.userservice.utils.exceptionhandler.bind.ExistsEntityException;
import c99.ams.userservice.utils.exceptionhandler.bind.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.format.DateTimeFormatter;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 10:06 AM
 */
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final LocalDateTime nowUTC =
            LocalDateTime.parse(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).format(dtf), dtf);

    private final ObjectMapper objectMapper;

    @Autowired
    public ControllerExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(ExistsEntityException.class)
    public ResponseEntity<?> existsEntityExceptionHandler(ExistsEntityException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, nowUTC);
        System.out.println(nowUTC);
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(objectMapper.writeValueAsString(errorResponse), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(BadRequestException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, nowUTC);
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(objectMapper.writeValueAsString(errorResponse), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, nowUTC);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
