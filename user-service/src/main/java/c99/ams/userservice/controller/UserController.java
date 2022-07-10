package c99.ams.userservice.controller;

import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.dto.response.MessageResponse;
import c99.ams.userservice.dto.response.UserResponse;
import c99.ams.userservice.service.template.IUserService;
import c99.ams.userservice.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserMapper userMapper;
    private final IUserService userService;

    @Autowired
    public UserController(UserMapper userMapper, IUserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }


    // ===================================
    // ============== USER ===============
    // ===================================
    @GetMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<UserResponse> getUser(@RequestParam String email) throws ParseException {
        return new ResponseEntity<>(userMapper.toResponse(userService.findByEmail(email)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> signUp(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(new MessageResponse(userService.signUp(userDTO)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateUserInformation(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return new ResponseEntity<>(new MessageResponse(userService.updateInformation(id, userDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(new MessageResponse(userService.delete(id)), HttpStatus.OK);
    }

}
