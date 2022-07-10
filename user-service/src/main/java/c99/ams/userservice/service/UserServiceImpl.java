package c99.ams.userservice.service;

import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.entity.User;
import c99.ams.userservice.repository.UserRepository;
import c99.ams.userservice.service.template.IOrderService;
import c99.ams.userservice.service.template.IUserService;
import c99.ams.userservice.utils.enums.Gender;
import c99.ams.userservice.utils.exceptionhandler.bind.BadRequestException;
import c99.ams.userservice.utils.exceptionhandler.bind.ExistsEntityException;
import c99.ams.userservice.utils.exceptionhandler.bind.NotFoundException;
import c99.ams.userservice.utils.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/7/2021 9:56 AM
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final IOrderService orderService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, IOrderService orderService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.orderService = orderService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String signUp(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail()))
            throw new ExistsEntityException("User email exists");
        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber()))
            throw new ExistsEntityException("User phone number exists");
        User user = userMapper.signUpUser(userDTO);
        try {
            orderService.createCart(userRepository.saveAndFlush(user).getId());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Sign up failed");
        }
        return "Sign up successful";
    }

    @Override
    public String updateInformation(Long id, UserDTO userDTO) {
        User user = this.findById(id);
        if (userRepository.existsByEmail(userDTO.getEmail()) && !userDTO.getEmail().equalsIgnoreCase(user.getEmail()))
            throw new ExistsEntityException("User email exists");
        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber()) && !userDTO.getPhoneNumber().equalsIgnoreCase(user.getPhoneNumber()))
            throw new ExistsEntityException("User phone number exists");
        userMapper.updateUser(userDTO, user);
        try {
            userRepository.saveAndFlush(user);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Update failed");
        }
        return "Update successful";
    }

    @Override
    public String delete(Long id) {
        User user = this.findById(id);
        try {
            userRepository.delete(user);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Delete failed");
        }
        return "Delete successful";
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @PostConstruct
    public void initUser() {
        if (!userRepository.existsByEmail("trantheduyk13@gmail.com"))
            try {
                orderService.createCart(userRepository.saveAndFlush(new User(1L, "Trần Thế Duy", "trantheduyk13@gmail.com", "07984555595",
                        Gender.MALE, new GregorianCalendar(1999, Calendar.AUGUST, 20).getTime(), "Vũng Tàu")).getId());
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
    }
}
