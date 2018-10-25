package com.xinchao.websocket;

import com.xinchao.websocket.socket.WebSocketDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebsocketDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(WebsocketDemoApplication.class, args);
		WebSocketDemo.setApplicationContext(applicationContext);
	}
}
