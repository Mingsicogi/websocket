package mins.study.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(websocketHandler(), "/mins/ws")
                .setAllowedOriginPatterns("*") // cors allow
//                .addInterceptors(new HttpSessionHandshakeInterceptor())
        ;
    }

    @Bean
    public WebsocketHandler websocketHandler() {
        return new WebsocketHandler();
    }
}
