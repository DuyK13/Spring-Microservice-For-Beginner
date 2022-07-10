package c99.ams.orderservice.controller;

import c99.ams.orderservice.dto.OrderInformationDTO;
import c99.ams.orderservice.dto.ProductDTO;
import c99.ams.orderservice.dto.response.MessageResponse;
import c99.ams.orderservice.dto.response.OrderResponse;
import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.service.template.IOrderService;
import c99.ams.orderservice.utils.enums.State;
import c99.ams.orderservice.utils.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(IOrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    // ===================================
    // ============== ALL ================
    // ===================================

    /**
     * USED
     */
    @GetMapping
    public ResponseEntity<?> getCartOrOrderByEmail(@RequestParam(name = "email") String email, @RequestParam(name =
            "state", defaultValue = "ALL") String state) {
        state = state.toUpperCase();
        if (state.equals("ALL")) {
            List<OrderResponse> resultList =
                    orderService.getAllByEmailAndNotState(email, "CART").stream().map(orderMapper::toOrderResponse).collect(Collectors.toList());
            return new ResponseEntity<>(resultList, HttpStatus.OK);
        } else if (state.equals("CART")) {
            OrderResponse orderResponse = orderMapper.toOrderResponse(orderService.getAllByEmailAndState(email, state).get(0));
            return ResponseEntity.ok(orderResponse);
        } else {
            List<OrderResponse> resultList =
                    orderService.getAllByEmailAndState(email, state).stream().map(orderMapper::toOrderResponse).collect(Collectors.toList());
            return new ResponseEntity<>(resultList, HttpStatus.OK);

        }
    }

    @PostMapping("/{email}")
    public ResponseEntity<MessageResponse> createCart(@PathVariable String email) {
        return new ResponseEntity<>(new MessageResponse(orderService.createCart(email)), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getCartOrOrder(@PathVariable Long id) {
        Order order = orderService.getCartOrOrder(id);
        System.out.println(order);
        return new ResponseEntity<>(order.getState() == State.CART ? orderMapper.toCartResponse(order) :
                orderMapper.toOrderResponse(order), HttpStatus.OK);
    }

    // ===================================
    // =============== CART ==============
    // ===================================

    @PutMapping("/{id}/cart")
    public ResponseEntity<OrderResponse> cartAction(@RequestBody(required = false) ProductDTO product,
                                                    @PathVariable Long id,
                                                    @RequestParam(name = "action") String action) {
        return ResponseEntity.ok(orderMapper.toOrderResponse(orderService.cartAction(product, id, action)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> orderAction(
            @RequestBody(required = false) OrderInformationDTO orderInformationDTO,
            @PathVariable Long id,
            @RequestParam(name = "action") String action) {
        return ResponseEntity.ok(orderMapper.toOrderResponse(orderService.orderAction(orderInformationDTO, id, action)));
    }
}
