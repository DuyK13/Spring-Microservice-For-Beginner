package c99.ams.oauthservice.interceptor;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 1:46 PM
 */
public class EntityException extends RuntimeException {
    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable e) {
        super(message, e);
    }
}
