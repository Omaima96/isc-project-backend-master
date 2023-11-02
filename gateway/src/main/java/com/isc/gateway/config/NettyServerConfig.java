package com.isc.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class NettyServerConfig implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Value("${server.max-http-header-size}")
    private DataSize maxHttpHeaderSize;

    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        factory.addServerCustomizers(
                server -> server.httpRequestDecoder(
                        reqDecorator -> reqDecorator
                                .maxInitialLineLength((int) maxHttpHeaderSize.toBytes())
                                .maxHeaderSize((int) maxHttpHeaderSize.toBytes())
                )
        );
    }
}
