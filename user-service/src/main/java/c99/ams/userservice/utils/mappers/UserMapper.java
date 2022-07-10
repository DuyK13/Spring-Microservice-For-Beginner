package c99.ams.userservice.utils.mappers;

import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.dto.response.UserResponse;
import c99.ams.userservice.entity.User;
import c99.ams.userservice.utils.mappers.annotation.EncodeStringMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {MapperHelper.class})
public interface UserMapper {

    @Mappings({
//            @Mapping(target = "password", source = "password", qualifiedBy = EncodeStringMapping.class),
            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "roles", expression = "java(new java.util.HashSet<>(java.util.Arrays.asList(new c99.ams" +
//                    ".userservice.entity.Role(c99.ams.userservice.utils.enums.ERole.ROLE_CUSTOMER))))")
    })
    User signUpUser(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "password", ignore = true),
            @Mapping(target = "fullName", source = "fullName", defaultExpression = "java(user.getFullName())"),
            @Mapping(target = "phoneNumber", source = "phoneNumber", defaultExpression = "java(user.getPhoneNumber()" +
                    ")"),
            @Mapping(target = "gender", source = "gender", defaultExpression = "java(user.getGender())"),
            @Mapping(target = "address", source = "address", defaultExpression = "java(user.getAddress())"),
            @Mapping(target = "email", source = "email", defaultExpression = "java(user.getEmail())"),
            @Mapping(target = "birthday", source = "birthday", defaultExpression = "java(user.getBirthday())")
    })
    void updateUser(UserDTO userDTO, @MappingTarget User user);

    UserResponse toResponse(User user);
}
