package c99.ams.oauthservice.service;

import c99.ams.oauthservice.model.AuthUserDetails;
import c99.ams.oauthservice.model.User;
import c99.ams.oauthservice.repository.UserDetailsRepository;
import c99.ams.oauthservice.service.template.UserProfileService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/22/2021 4:13 PM
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDetailsRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " +
                "not " +
                "found"));
        return new AuthUserDetails(user);
    }
}
