package c99.ams.userservice.utils.exceptionhandler.bind;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 10:32 AM
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
