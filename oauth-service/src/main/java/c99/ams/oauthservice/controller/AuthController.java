package c99.ams.oauthservice.controller;

import c99.ams.oauthservice.dto.UserAuthDTO;
import c99.ams.oauthservice.dto.UserDTO;
import c99.ams.oauthservice.dto.response.MessageResponse;
import c99.ams.oauthservice.model.User;
import c99.ams.oauthservice.service.template.UserProfileService;
import c99.ams.oauthservice.service.template.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 11:32 AM
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Qualifier("c99.ams.oauthservice.service.template.UserProfileService")
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> signUp(@RequestBody UserAuthDTO userAuthDTO) {
        userProfileService.signUp(new UserDTO(userAuthDTO));
        return ResponseEntity.ok(new MessageResponse(userService.signUp(new User(userAuthDTO))));
    }

}
