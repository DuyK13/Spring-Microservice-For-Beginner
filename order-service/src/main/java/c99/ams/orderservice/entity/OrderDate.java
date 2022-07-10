package c99.ams.orderservice.entity;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/8/2021 4:13 PM
 */
@Embeddable
public class OrderDate {
    private LocalDateTime dateTime;
    private String message;

    public OrderDate(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public OrderDate() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderDate{" +
                "dateTime=" + dateTime +
                ", message='" + message + '\'' +
                '}';
    }
}
