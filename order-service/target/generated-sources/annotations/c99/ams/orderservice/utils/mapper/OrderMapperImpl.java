package c99.ams.orderservice.utils.mapper;

import c99.ams.orderservice.dto.OrderInformationDTO;
import c99.ams.orderservice.dto.ProductDTO;
import c99.ams.orderservice.dto.response.OrderResponse;
import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.entity.OrderDate;
import c99.ams.orderservice.entity.Product;
import c99.ams.orderservice.entity.UserInformation;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-18T16:22:47+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toCartResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setEmail( order.getEmail() );
        Set<Product> set = order.getProducts();
        if ( set != null ) {
            orderResponse.setProducts( new ArrayList<Product>( set ) );
        }
        if ( order.getState() != null ) {
            orderResponse.setState( order.getState().name() );
        }

        return orderResponse;
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setAddress( orderUserInformationAddress( order ) );
        orderResponse.setFullName( orderUserInformationFullName( order ) );
        orderResponse.setPhoneNumber( orderUserInformationPhoneNumber( order ) );
        orderResponse.setId( order.getId() );
        orderResponse.setEmail( order.getEmail() );
        Set<OrderDate> set = order.getOrderDates();
        if ( set != null ) {
            orderResponse.setOrderDates( new ArrayList<OrderDate>( set ) );
        }
        Set<Product> set1 = order.getProducts();
        if ( set1 != null ) {
            orderResponse.setProducts( new ArrayList<Product>( set1 ) );
        }
        if ( order.getState() != null ) {
            orderResponse.setState( order.getState().name() );
        }

        return orderResponse;
    }

    @Override
    public UserInformation toUserInformation(OrderInformationDTO orderInformationDTO) {
        if ( orderInformationDTO == null ) {
            return null;
        }

        UserInformation userInformation = new UserInformation();

        userInformation.setFullName( orderInformationDTO.getFullName() );
        userInformation.setAddress( orderInformationDTO.getAddress() );
        userInformation.setPhoneNumber( orderInformationDTO.getPhoneNumber() );

        return userInformation;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setQuantity( productDTO.getQuantity() );
        product.setPrice( productDTO.getPrice() );
        product.setColor( productDTO.getColor() );
        product.setImage( productDTO.getImage() );

        return product;
    }

    private String orderUserInformationAddress(Order order) {
        if ( order == null ) {
            return null;
        }
        UserInformation userInformation = order.getUserInformation();
        if ( userInformation == null ) {
            return null;
        }
        String address = userInformation.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private String orderUserInformationFullName(Order order) {
        if ( order == null ) {
            return null;
        }
        UserInformation userInformation = order.getUserInformation();
        if ( userInformation == null ) {
            return null;
        }
        String fullName = userInformation.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String orderUserInformationPhoneNumber(Order order) {
        if ( order == null ) {
            return null;
        }
        UserInformation userInformation = order.getUserInformation();
        if ( userInformation == null ) {
            return null;
        }
        String phoneNumber = userInformation.getPhoneNumber();
        if ( phoneNumber == null ) {
            return null;
        }
        return phoneNumber;
    }
}
