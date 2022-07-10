package c99.ams.orderservice.service.template;

import c99.ams.orderservice.dto.OrderInformationDTO;
import c99.ams.orderservice.dto.ProductDTO;
import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {
    String createCart(String email);

//    Order updateCart(ProductDTO productsDTO, Long id);

    Order getCartOrOrder(Long id);

    List<Order> getAllByEmailAndNotState(String email, String state);

    List<Order> getAllByEmailAndState(String email, String state);

    Order cartAction(ProductDTO productDTO, Long id, String action);

    Order orderAction(OrderInformationDTO orderInformationDTO, Long id, String action);
}
