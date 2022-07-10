package c99.ams.userservice.service;

import c99.ams.userservice.dto.response.MessageResponse;
import c99.ams.userservice.service.template.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/10/2021 1:56 PM
 */
@Component
public class OrderServiceFallback implements IOrderService {
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceFallback.class);
    @Override
    public ResponseEntity<MessageResponse> createCart(Long userId) {
        logger.error("Can not connect to order service");
        return new ResponseEntity<>(new MessageResponse("Order service can connect right now"), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
