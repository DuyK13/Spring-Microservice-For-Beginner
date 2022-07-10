package c99.ams.orderservice.dto;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 7/15/2021 5:04 PM
 */
public class OrderInformationDTO implements Serializable {
    private String fullName;
    private String address;
    private String phoneNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
