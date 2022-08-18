package com.pactera.v2x.testabout.client;

import com.pactera.v2x.testabout.service.thrift.V2xService;
import com.pactera.v2x.testabout.service.thrift.hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.HashMap;
import java.util.Map;

public class DemoClient {
    private static final String SERVER_IP = "172.17.5.41";
    private static final int SERVER_PORT = 12345;
    private static final int TIMEOUT = 1000;

    private void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT);
            TProtocol protocol = new TBinaryProtocol(transport);
//            hello.Client client = new hello.Client(protocol);
            com.pactera.v2x.testabout.service.thrift.V2xService.Client client = new com.pactera.v2x.testabout.service.thrift.V2xService.Client(protocol);
            transport.open();
            // 调用服务端的方法
            Map<String,String> map = new HashMap<String, String>();
            map.put("ip","123456");
            map.put("port","12345");
            String res = client.start_carla_server(map);
            System.out.println("调用返回结果为：" + res);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        DemoClient client = new DemoClient();
        client.startClient("hello");
    }
}
