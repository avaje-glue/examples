package org.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The "/assets" path passes through the Jersey Filter.
 */
@Singleton
@ServerEndpoint(value = "/assets/ws")
public class MyWebSocket {

  private static final Logger log = LoggerFactory.getLogger(MyWebSocket.class);

  private Map<String,Session> sessions = new ConcurrentHashMap<>();

  @OnOpen
  public void onOpen(Session session) {
    log.info("onOpen " + session.getId() + " " + session);
    sessions.put(session.getId(), session);
  }

  @OnMessage
  public void onMessage(Session session, String message) throws IOException {
    log.info("onMessage " + session.getId() + " message:" + message);
    if (message.contains("echo")) {
      Collection<Session> values = sessions.values();
      for (Session sess : values) {
        sess.getBasicRemote().sendText("back "+message);
      }
    }
  }

  @OnClose
  public void onClose(Session session) {
    log.info("onClose " + session.getId() + " " + session);
    sessions.remove(session.getId());
  }

  @OnError
  public void onError(Session session, Throwable e) {
    log.info("onError " + session.getId() + " " + session, e);
  }
}
