package org.example.web;

import org.example.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Jersey Spring integration example.
 */
@Path("/")
@Component
public class IndexResource {

  private static final Logger log = LoggerFactory.getLogger(IndexResource.class);

  private final AtomicInteger counter = new AtomicInteger();

  private final HelloService helloService;

  @Value("${message.hello}")
  private String message;

  @Inject
  public IndexResource(HelloService helloService) {
    log.info("IndexResource() ---  ");
    this.helloService = helloService;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getHello(@Context HttpHeaders headers, @QueryParam("p1") String p1) {
    if ("foobar".equals(p1)) {
      throw new IllegalArgumentException("foobar is illegal");
    }
    return String.format("%d: %s", counter.incrementAndGet(), message + "- " + helloService.greet("world"));
  }


  @Path("/slow")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String slow() {
    try {
      Thread.sleep(10000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "done";
  }
}
