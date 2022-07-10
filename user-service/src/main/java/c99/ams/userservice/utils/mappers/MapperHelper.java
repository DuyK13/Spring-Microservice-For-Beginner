package c99.ams.userservice.utils.mappers;

import c99.ams.userservice.utils.mappers.annotation.EncodeStringMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 9:35 AM
 */
@Component
public class MapperHelper {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @EncodeStringMapping
    public String encodeString(String text) {
        return passwordEncoder.encode(text);
    }
}
