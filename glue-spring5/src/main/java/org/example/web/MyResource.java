package org.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("my")
@Component
public class MyResource {

  private static final Logger log = LoggerFactory.getLogger(MyResource.class);

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public SomeBean getSomeBean() {

    log.debug("hello bean");

    SomeBean bean = new SomeBean();
    bean.setId(42);
    bean.setName("Foo");
    return bean;
  }
}
