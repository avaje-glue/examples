package org.example.config;

import org.example.service.HelloService;
import org.example.web.IndexResource;
import org.example.web.MyResource;
import org.example.web.MyWebSocket;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({IndexResource.class, HelloService.class, MyResource.class, MyWebSocket.class})
@Configuration
public class AppConfig {

}
