package c99.ams.userservice.dto.response;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/8/2021 11:03 AM
 */
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
