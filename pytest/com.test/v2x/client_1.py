import time

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
import sys

sys.path.append("./gen-py/")

from v2x import V2xService

if __name__ == '__main__':
    transport = TSocket.TSocket('127.0.0.1', 9999)
    transport = TTransport.TBufferedTransport(transport)
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    client = V2xService.Client(protocol)
   
    # 连接服务端
    transport.open()

    recv = client.ping("test")
    print(recv)
    # print(time.time())
    # i = 0
    # while i < 100000:
    #     recv = client.get_int_string_mapping_result("v2x_1", data)
    #     i += 1
    # print(time.time())
    # recv = client.get_bool_result()
    # print(recv)

    # 断连服务端
    transport.close()