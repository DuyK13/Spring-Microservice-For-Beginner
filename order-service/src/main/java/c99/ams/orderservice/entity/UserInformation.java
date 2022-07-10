package c99.ams.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 7/15/2021 4:31 PM
 */
@Embeddable
public class UserInformation {
    @Column(name = "full_name")
    private String fullName;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    public UserInformation(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UserInformation() {
    }

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

    @Override
    public String toString() {
        return "UserInformation{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
