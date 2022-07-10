package c99.ams.userservice.utils.exceptionhandler.bind;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 10:08 AM
 */
public class ExistsEntityException extends RuntimeException {

    public ExistsEntityException(String message) {
        super(message);
    }

    public ExistsEntityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
