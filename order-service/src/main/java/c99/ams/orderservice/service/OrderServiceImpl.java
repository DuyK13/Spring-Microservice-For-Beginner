package c99.ams.orderservice.service;

import c99.ams.orderservice.dto.OrderInformationDTO;
import c99.ams.orderservice.dto.ProductDTO;
import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.entity.OrderDate;
import c99.ams.orderservice.entity.Product;
import c99.ams.orderservice.repository.OrderRepository;
import c99.ams.orderservice.service.template.IOrderService;
import c99.ams.orderservice.utils.enums.State;
import c99.ams.orderservice.utils.exceptionhandler.bind.BadRequestException;
import c99.ams.orderservice.utils.exceptionhandler.bind.NotFoundException;
import c99.ams.orderservice.utils.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements IOrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public String createCart(String email) {
        if (orderRepository.existsByEmailAndState(email, State.CART))
            throw new BadRequestException("User already have a cart");
        try {
            orderRepository.saveAndFlush(new Order(email));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Create failed");
        }
        return "Create successful";
    }

//    @Override
//    public Order updateCart(ProductDTO productsDTO, Long id) {
//        Order order = this.findByIdAndState(id, State.CART);
//        order.setProducts(productsDTO.getProducts());
//        try {
//            order = orderRepository.saveAndFlush(order);
//        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
//            throw new BadRequestException("Update failed");
//        }
//        return order;
//    }

    @Override
    public Order getCartOrOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }

    private Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }

    @Override
    public List<Order> getAllByEmailAndState(String email, String state) {
        return orderRepository.findAllByEmailAndState(email, Enum.valueOf(State.class, state));
    }

    @Override
    public List<Order> getAllByEmailAndNotState(String email, String state) {
        return orderRepository.findAllByEmailAndStateNot(email, Enum.valueOf(State.class, state));
    }

    @Override
    public Order orderAction(OrderInformationDTO orderInformationDTO, Long id, String action) {
        Order order = this.findById(id);
        switch (action) {
            case "place":
                return placeOrder(order, orderInformationDTO);
            case "receive":
                return receiveOrder(order);
            case "cancel":
                return cancelOrder(order);
        }
        return order;
    }

    private Order placeOrder(Order order, OrderInformationDTO orderInformationDTO) {
        order.setState(State.PLACED);
        order.setUserInformation(orderMapper.toUserInformation(orderInformationDTO));
        order.getOrderDates().add(new OrderDate(now, "Placed Order"));
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Placed order failed");
        }
        this.createCart(order.getEmail());
        return order;
    }

    private Order receiveOrder(Order order) {
        order.setState(State.RECEIVED);
        order.getOrderDates().add(new OrderDate(now, "Received Order"));
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Receiveed order failed");
        }
        return order;
    }

    private Order cancelOrder(Order order) {
        order.setState(State.CANCELED);
        order.getOrderDates().add(new OrderDate(now, "Canceled Order"));
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Canceled order failed");
        }
        return order;
    }

    @Override
    public Order cartAction(ProductDTO productDTO, Long id, String action) {
        Order order = this.findByIdAndState(id, State.CART);
        Product product = orderMapper.toProduct(productDTO);
        switch (action) {
            case "add":
                return addToCart(product, order);
            case "remove":
                return removeItem(product, order);
            case "clear":
                return clearCart(order);
            case "inc":
                return increaseAmount(product, order);
            case "dec":
                return decreaseAmount(product, order);
        }
        return order;
    }

    private Order increaseAmount(Product product, Order order) {
        Set<Product> products = order.getProducts();
        Product currentProduct = products.stream().filter(p -> p.getId().equals(product.getId())
        ).findFirst().get();
        products.remove(currentProduct);
        currentProduct.setQuantity(currentProduct.getQuantity() + 1);
        products.add(currentProduct);
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Increase failed");
        }
        return order;
    }

    private Order decreaseAmount(Product product, Order order) {
        Set<Product> products = order.getProducts();
        Product currentProduct = products.stream().filter(p -> p.getId().equals(product.getId())
        ).findFirst().get();
        products.remove(currentProduct);
        currentProduct.setQuantity(currentProduct.getQuantity() - 1);
        if (currentProduct.getQuantity() != 0) {
            products.add(currentProduct);
        }
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Decrease failed");
        }
        return order;
    }

    private Order clearCart(Order order) {
        order.setProducts(Collections.EMPTY_SET);
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Clear failed");
        }
        return order;
    }

    private Order removeItem(Product product, Order order) {
        Set<Product> products = order.getProducts();
        products.remove(product);
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Remove failed");
        }
        return order;
    }

    private Order addToCart(Product product, Order order) {
        Set<Product> products = order.getProducts();
        Optional<Product> currentProduct = products.stream().filter(p -> p.getId().equals(product.getId())
        ).findFirst();
        if (currentProduct.isPresent()) {
            Product p = currentProduct.get();
            products.remove(p);
            p.setQuantity(p.getQuantity() + product.getQuantity());
            products.add(p);
        } else {
            products.add(product);
        }
        try {
            order = orderRepository.saveAndFlush(order);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadRequestException("Add failed");
        }
        return order;
    }

    private Order findByEmailAndState(String email, State state) {
        return orderRepository.findByEmailAndState(email, state).orElseThrow(() -> new NotFoundException("Not found"));
    }

    private Order findByIdAndState(Long id, State state) {
        return orderRepository.findByIdAndState(id, state).orElseThrow(() -> new NotFoundException("Not found"));
    }
}
