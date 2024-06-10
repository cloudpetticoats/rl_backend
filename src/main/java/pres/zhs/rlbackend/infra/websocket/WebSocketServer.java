package pres.zhs.rlbackend.infra.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@ServerEndpoint("/springboot/backend/getStrategy/{name}")
public class WebSocketServer {

    /**
     *  与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户名
     */
    private String name;


    /**
     *  用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name){

        this.session = session;
        this.name = name;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(name, this);
        log.info("[WebSocketServer] 连接成功，当前连接人数为：{}", webSocketSet.size());
        log.info(String.valueOf(webSocketSet.containsKey("zhs")));
    }

    @OnClose
    public void OnClose(){
        webSocketSet.remove(this.name);
        log.info("[WebSocketServer] 退出成功，当前连接人数为：{}", webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message){
        log.info("[WebSocketServer] 收到消息：{}", message);
    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message){
        for (String name : webSocketSet.keySet()){
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     * @param name
     * @param message
     */
    public void AppointSending(String name, String message) throws Exception {
        try {
            log.info(message);
            if (webSocketSet == null || webSocketSet.isEmpty() || !webSocketSet.containsKey(name)) {
                throw new Exception("无任何客户端连接,已终止线程池");
            } else {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
