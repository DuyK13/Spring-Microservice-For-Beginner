package c99.ams.oauthservice.interceptor;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 7/3/2021 7:50 PM
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable e){
        super(message, e);
    }
}
