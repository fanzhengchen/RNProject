package com.rnproject.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by mark on 17-1-14.
 */
@ServerEndpoint("/websocket")
@Component
public class WebsocketComponent {


    private final static Logger logger = LoggerFactory.getLogger(WebsocketComponent.class);

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebsocketComponent> websocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocketSet.add(this);
    }

    @OnClose
    public void onClose() {
        websocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.debug(message);
        logger.debug("{}", session);
        System.out.println(message + " " + session.toString());
    }


    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    private synchronized void changeOnlineCount(boolean increase) {
        if (increase) {
            ++onlineCount;
        } else {
            --onlineCount;
        }
    }

}
