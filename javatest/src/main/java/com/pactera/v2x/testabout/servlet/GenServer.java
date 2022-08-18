package com.pactera.v2x.testabout.servlet;


import com.pactera.v2x.testabout.service.thrift.V2xService;
import com.pactera.v2x.testabout.service.thrift.impl.V2XServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;

public class GenServer {
    private void startServer(){


        V2xService.Processor processor = new V2xService.Processor<V2xService.Iface>(new V2XServiceImpl());
        try{
            TServerTransport transport = new TServerSocket(12345);
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
            args.processor(processor);
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.transportFactory(new TTransportFactory());
            args.minWorkerThreads(10);
            args.maxWorkerThreads(20);
            TServer server = new TThreadPoolServer(args);
            server.serve();

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        GenServer server = new GenServer();
        server.startServer();
    }
}
