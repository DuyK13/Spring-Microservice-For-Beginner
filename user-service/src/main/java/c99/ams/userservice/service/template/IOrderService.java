package c99.ams.userservice.service.template;

import c99.ams.userservice.dto.response.MessageResponse;
import c99.ams.userservice.service.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-service", fallback = OrderServiceFallback.class)
public interface IOrderService {

    @PostMapping("/orders/{userId}")
    ResponseEntity<MessageResponse> createCart(@PathVariable Long userId);

}
