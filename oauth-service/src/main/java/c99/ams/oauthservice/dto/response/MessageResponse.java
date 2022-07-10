package c99.ams.oauthservice.dto.response;

import java.io.Serializable;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 1:21 PM
 */
public class MessageResponse implements Serializable {

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
