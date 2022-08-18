from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
import sys

sys.path.append("./gen-py/")
from v2x import V2XService
import random


class DemoServer:
    def __init__(self):
        self.log = {}

    def ping(self, param):
        print(param)
        return "echo:" + param

    def get_int_string_mapping_result(self, key, value):
        if key == "v2x":
            print("**************")
        elif key == "case_1":
            print(value)

        return {key:value}

    def get_bool_result(self):
        return random.choice([True, False])


if __name__ == '__main__':
    # 创建处理器
    handler = DemoServer()
    processor = V2XService.Processor(handler)

    # 监听端口
    transport = TSocket.TServerSocket(port=9999)

    # 选择传输层
    tfactory = TTransport.TBufferedTransportFactory()

    # 选择传输协议
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    # 创建服务端
    server = TServer.TThreadPoolServer(processor, transport, tfactory, pfactory)

    # 设置连接线程池数量
    server.setNumThreads(10)

    # 启动服务
    server.serve()