package c99.ams.userservice.service.template;

import c99.ams.userservice.dto.PasswordDTO;
import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.entity.User;
import org.springframework.security.access.prepost.PostAuthorize;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 9:54 AM
 */
public interface IUserService {
    String signUp(UserDTO userDTO);

    String updateInformation(Long id, UserDTO userDTO);

    String delete(Long id);

    @PostAuthorize("returnObject.email == authentication.name")
    User findById(Long id);

    @PostAuthorize("returnObject.email == authentication.name")
    User findByEmail(String email);
}
