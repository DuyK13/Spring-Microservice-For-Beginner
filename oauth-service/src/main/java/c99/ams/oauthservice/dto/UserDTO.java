package c99.ams.oauthservice.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 1:38 PM
 */
public class UserDTO implements Serializable {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date birthday;
    private String address;

    public UserDTO(UserAuthDTO userAuthDTO) {
        this.fullName = userAuthDTO.getFullName();
        this.email = userAuthDTO.getEmail();
        this.phoneNumber = userAuthDTO.getPhoneNumber();
        this.gender = userAuthDTO.getGender();
        this.birthday = userAuthDTO.getBirthday();
        this.address = userAuthDTO.getAddress();
    }

    public UserDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
