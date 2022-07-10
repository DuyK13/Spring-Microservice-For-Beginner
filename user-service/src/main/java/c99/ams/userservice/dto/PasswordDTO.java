package c99.ams.userservice.dto;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 9:55 AM
 */
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;

    public PasswordDTO() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
