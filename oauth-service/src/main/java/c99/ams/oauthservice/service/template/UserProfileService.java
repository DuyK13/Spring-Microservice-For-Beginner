package c99.ams.oauthservice.service.template;

import c99.ams.oauthservice.dto.UserDTO;
import c99.ams.oauthservice.dto.response.MessageResponse;
import c99.ams.oauthservice.service.UserProfileServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 11:41 AM
 */
@FeignClient(name = "user-service", fallback = UserProfileServiceFallback.class)
public interface UserProfileService {
    @PostMapping("/users")
    public MessageResponse signUp(@RequestBody UserDTO userDTO);
}
