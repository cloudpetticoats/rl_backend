package pres.zhs.rlbackend.infra.websocket;

import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * websocket client 客户端端控制
 */
public class WebSocketClient extends org.java_websocket.client.WebSocketClient {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketClient.class);

    // 复制请留意，该位置url需要进行更改
    private static String wsUrl = "ws://127.0.0.1:8765";

    private static WebSocketClient instance;

    private volatile int sendFlag = 0;
    private String result = null;

    static {
        try {
            instance = new WebSocketClient(wsUrl);
            instance.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // 获取到当前实例
    public static WebSocketClient getInstance(){
        try{
            if(instance != null){
                if(instance.getReadyState() == ReadyState.NOT_YET_CONNECTED
                        || instance.getReadyState() == ReadyState.CLOSED){
                    if(instance.isClosed()){
                        instance.reconnect();
                    }
                }
            }else{
                instance = new WebSocketClient(wsUrl);
                instance.connect();
            }
        }catch (Exception ex){
            instance = null;
            logger.error(" websocket 构建实例出现问题！！" + ex);
        }
        return instance;
    }

    // 发送字符串消息
    public String sendStr(String text){
        synchronized(this){
            sendFlag = 1;
            this.send(text);
            while(sendFlag != 0){
                logger.debug(" 等待返回值中 =============== " + sendFlag);
            }
            return result;
        }
    }


    private WebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        logger.debug(" ws 服务正常打开！！");
    }

    @Override
    public void onMessage(String s) {
        result = s;
        sendFlag = 0;
        logger.debug(" ws 接收服务器推送的消息！！" + s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        result = null;
        sendFlag = 0;
        logger.debug(" ws 客户端正常关闭！！");
    }

    @Override
    public void onError(Exception e) {
        result = null;
        sendFlag = 0;
        logger.debug(" ws 客户端连接出现错误！！");
    }
}