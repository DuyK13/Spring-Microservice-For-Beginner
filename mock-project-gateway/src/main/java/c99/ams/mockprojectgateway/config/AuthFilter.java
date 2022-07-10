package c99.ams.mockprojectgateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/18/2021 11:32 AM
 */
@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);


    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpRequest modifiedRequest =
                    exchange.getRequest().mutate().header("Authorization", "Basic d2ViOnBpbg==").build();
            boolean authorization = request.getHeaders().containsKey("Authorization");
            if (!authorization)
                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            String auth = request.getHeaders().get("Authorization").get(0);
            if (!StringUtils.hasText(auth))
                return this.onError(exchange, "No authentication found", HttpStatus.UNAUTHORIZED);
            if (!"Basic d2ViOnBpbg==".equalsIgnoreCase(auth)) {
                return this.onError(exchange, "Wrong client", HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> onError(final ServerWebExchange exchange, final String err, final HttpStatus httpStatus) {
        log.error("Gateway Auth Error {}", err);
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    static class Config {

    }

}
