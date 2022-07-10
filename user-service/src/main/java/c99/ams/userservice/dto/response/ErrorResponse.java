package c99.ams.userservice.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 10:14 AM
 */
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
