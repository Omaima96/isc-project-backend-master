package com.isc.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config> {

    final Logger logger
            = LoggerFactory.getLogger(LogFilter.class);

    public LogFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Pre-processing
            if (config.preLogger) {
                logger.info("Pre GatewayFilter logging: "
                        + config.baseMessage);
            }
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Post-processing
                        if (config.postLogger) {
                            logger.info("Post GatewayFilter logging: "
                                    + config.baseMessage);
                        }
                    }));
        };
    }

    public static class Config {

        public String baseMessage;

        public boolean preLogger;

        public boolean postLogger;
    }
}
