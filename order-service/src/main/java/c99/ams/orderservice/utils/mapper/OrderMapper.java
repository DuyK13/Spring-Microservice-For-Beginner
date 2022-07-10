package c99.ams.orderservice.utils.mapper;

import c99.ams.orderservice.dto.OrderInformationDTO;
import c99.ams.orderservice.dto.ProductDTO;
import c99.ams.orderservice.dto.response.OrderResponse;
import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.entity.Product;
import c99.ams.orderservice.entity.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/8/2021 10:43 AM
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({@Mapping(target = "orderDates", ignore = true),
            @Mapping(target = "address", ignore = true)})
    OrderResponse toCartResponse(Order order);

    @Mappings({
            @Mapping(target = "address", source= "userInformation.address"),
            @Mapping(target = "fullName", source= "userInformation.fullName"),
            @Mapping(target = "phoneNumber", source= "userInformation.phoneNumber")
    })
    OrderResponse toOrderResponse(Order order);

    UserInformation toUserInformation(OrderInformationDTO orderInformationDTO);

    Product toProduct(ProductDTO productDTO);
}
