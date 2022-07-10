package c99.ams.orderservice.utils.exceptionhandler.bind;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 11:46 AM
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
