package c99.ams.oauthservice.service;

import c99.ams.oauthservice.interceptor.EntityException;
import c99.ams.oauthservice.model.User;
import c99.ams.oauthservice.repository.UserDetailsRepository;
import c99.ams.oauthservice.service.template.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/23/2021 11:34 AM
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String signUp(User user) {
        if(userDetailsRepository.existsByEmail(user.getEmail()))
            throw new EntityException("Email exists");
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDetailsRepository.saveAndFlush(user);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new EntityException("Sign up fail", ex);
        }
        return "Sign up success";
    }
}
