package com.xinchao.websocket.socket;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @Auther: 杜威
 * @Date: 2018/10/25 9:40
 * @Description:
 */
@ServerEndpoint("/webSocketServer")
@Component
public class WebSocketDemo {

    private static ConfigurableApplicationContext applicationContext;

    //当需要在websocket服务端注入Service或者Dao进行其他的业务逻辑时，常规注入是会产生空指针异常的。
    //我们需要在websocket中注入applilcationContext对象，从上下文对象中获取。
    //private GatewayDao gatewayDao;
    /*
    public void setGetewayDao() {
        if(gatewayDao == null) {
            gatewayDao = applicationContext.getBean(GatewayDao.class);
        }
    }
    */

    public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        WebSocketDemo.applicationContext = applicationContext;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("新开启了一个webSocket连接" + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("收到客户端发送的信息:"+message);
        System.out.println("当前的sessionId:"+session.getId());
        return "SUCCESS";
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("webSocket连接关闭：sessionId:"+session.getId() + "关闭原因是："+reason.getReasonPhrase() + "code:"+reason.getCloseCode());
    }


    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
