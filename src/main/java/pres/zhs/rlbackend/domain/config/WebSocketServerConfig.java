package pres.zhs.rlbackend.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 自动注册使用@ServerEndpoint注解声明的websocket endpoint
 *
 * @author 张海硕
 */
@Component
public class WebSocketServerConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
