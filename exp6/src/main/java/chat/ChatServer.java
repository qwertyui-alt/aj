package chat;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class ChatServer {

    private static final Set<Session> clients =
            Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session)
            throws IOException {

        synchronized (clients) {

            for (Session client : clients) {

                if (client.isOpen()) {
                    client.getBasicRemote().sendText(message);
                }

            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }
}