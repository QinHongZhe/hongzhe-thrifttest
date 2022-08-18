package com.pactera.v2x.testabout.service.thrift.impl;


import com.pactera.v2x.testabout.service.thrift.V2xService;
import org.apache.thrift.TException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2XServiceImpl implements V2xService.Iface {

    public String ping(String data) throws TException {
        return null;
    }

    public String get_car_list() throws TException {
        return null;
    }

    public String write_file_heard(List<String> data, String filename) throws TException {
        return null;
    }

    public String get_mapping_result(Map<String, String> data) throws TException {
        return null;
    }

    public String get_data_list(Map<String, String> data, String filename, String device_ip) throws TException {
        return null;
    }

    public String set_traffic_light(String data) throws TException {
        System.out.println("数据:"+data);
        return null;
    }

    public String generate_world_client(Map<String, String> data) throws TException {
        return "SUCCESS";
    }

    public String stop_world(Map<String, String> data) throws TException {
        return null;
    }

    @Override
    public String start_carla_server(Map<String, String> data) throws TException {
        return null;
    }
}
