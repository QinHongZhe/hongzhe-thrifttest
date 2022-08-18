import jpype
import os

JVM_path = "D:\root\DataRoot\04_软件\02_编程\01_JAVA\01_JDK\JDK1.8_64\jre\bin\server\jvm.dll" # jvm.dll 是必须的，在jdk文件夹jre\bin\server\jvm.dll下
jarpath ='D:\root\DataRoot\08_源码\01_工作\01_文思\worksapce\thrifttest\javatest\target\thrifttest-1.0-SNAPSHOT.jar' # 生成的 jar 包路径

Djava = "-Djava.class.path="+jarpath
jpype.startJVM(JVM_path,"-ea",Djava)
jpype.java.lang.System.out.println("HelloWorld") # 测试调用 Java 的环境 print
JDClass =jpype.JClass("com.pactera.v2x.JpypeDemo") # jar 包中，Java 脚本中定义的类
jd = JDClass() # 实例化
print(jd.calc(1,2)) # 调用方法
# 关闭JVM
jpype.shutdownJVM()