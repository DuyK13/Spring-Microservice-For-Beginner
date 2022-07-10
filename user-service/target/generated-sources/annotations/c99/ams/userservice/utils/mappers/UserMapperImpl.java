package c99.ams.userservice.utils.mappers;

import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.dto.response.UserResponse;
import c99.ams.userservice.entity.User;
import c99.ams.userservice.utils.enums.Gender;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-18T16:23:11+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User signUpUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( userDTO.getFullName() );
        user.setEmail( userDTO.getEmail() );
        user.setPhoneNumber( userDTO.getPhoneNumber() );
        if ( userDTO.getGender() != null ) {
            user.setGender( Enum.valueOf( Gender.class, userDTO.getGender() ) );
        }
        user.setBirthday( userDTO.getBirthday() );
        user.setAddress( userDTO.getAddress() );

        return user;
    }

    @Override
    public void updateUser(UserDTO userDTO, User user) {
        if ( userDTO == null ) {
            return;
        }

        if ( userDTO.getFullName() != null ) {
            user.setFullName( userDTO.getFullName() );
        }
        else {
            user.setFullName( user.getFullName() );
        }
        if ( userDTO.getPhoneNumber() != null ) {
            user.setPhoneNumber( userDTO.getPhoneNumber() );
        }
        else {
            user.setPhoneNumber( user.getPhoneNumber() );
        }
        if ( userDTO.getGender() != null ) {
            user.setGender( Enum.valueOf( Gender.class, userDTO.getGender() ) );
        }
        else {
            user.setGender( user.getGender() );
        }
        if ( userDTO.getAddress() != null ) {
            user.setAddress( userDTO.getAddress() );
        }
        else {
            user.setAddress( user.getAddress() );
        }
        if ( userDTO.getEmail() != null ) {
            user.setEmail( userDTO.getEmail() );
        }
        else {
            user.setEmail( user.getEmail() );
        }
        if ( userDTO.getBirthday() != null ) {
            user.setBirthday( userDTO.getBirthday() );
        }
        else {
            user.setBirthday( user.getBirthday() );
        }
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setFullName( user.getFullName() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setPhoneNumber( user.getPhoneNumber() );
        userResponse.setGender( user.getGender() );
        userResponse.setBirthday( user.getBirthday() );
        userResponse.setAddress( user.getAddress() );

        return userResponse;
    }
}
