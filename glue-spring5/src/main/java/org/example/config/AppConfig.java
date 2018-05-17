package org.example.config;

import org.example.service.HelloService;
import org.example.web.IndexResource;
import org.example.web.MyResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({IndexResource.class, HelloService.class, MyResource.class})
@Configuration
public class AppConfig {

  // To supply our own ObjectMapper have one as a Spring bean
  // ... and then it will be used by Jersey

//  private ObjectMapper mapper = newObject();
//
//  @Bean
//  ObjectMapper mapper() {
//    return mapper;
//  }
//
//  private ObjectMapper newObject() {
//
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY);
//    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//    mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//    return mapper;
//  }
}
