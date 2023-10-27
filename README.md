# Apache-ActiveMQ-RCE
Apache ActiveMQ远程代码执行(RCE)利用工具

# 影响范围
```
5.18.0<=Apache ActiveMQ<5.18.3
5.17.0<=Apache ActiveMQ<5.17.6
5.16.0<=Apache ActiveMQ<5.16.7
5.15.0<=Apache ActiveMQ<5.15.15
```

# 使用教程
1.修改ActiveMQ.java文件中String ip为目标IP,String pocxml为VPS启动的服务

![image-1](images/1.png)

2.修改poc.xml文件中反弹shell地址
![avatar](images/2.png)

3.javac编译成class
```
javac ActiveMQ.java
```

4.运行class文件
```
java ActiveMQ
```
