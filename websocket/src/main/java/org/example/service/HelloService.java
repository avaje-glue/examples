package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public String greet(String who) {
    return String.format("hello, %s! Whatasdasdsup!!", who);
  }

}
