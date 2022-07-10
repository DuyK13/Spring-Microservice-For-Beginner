package c99.ams.oauthservice.service;

import c99.ams.oauthservice.dto.UserDTO;
import c99.ams.oauthservice.dto.response.MessageResponse;
import c99.ams.oauthservice.interceptor.BadRequestException;
import c99.ams.oauthservice.service.template.UserProfileService;
import org.springframework.stereotype.Component;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 2:05 PM
 */
@Component
public class UserProfileServiceFallback implements UserProfileService {
    @Override
    public MessageResponse signUp(UserDTO userDTO) {
        System.out.println("fall-back");
        throw new BadRequestException("Service unavailable");
    }
}
