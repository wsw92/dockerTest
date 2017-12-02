#基础镜像
FROM centos

#维护人员信息
MAINTAINER wsw92 "wsw92@163.com"

#设置工作目录，这个命令是用来切换工作目录的，相当于cd命令
WORKDIR /home

#安装JDK
#创建JDK目录，等一下的JDK安装到这个目录
RUN mkdir JDK

#上篇文章中已经下载了jdk，为了节省时间我这里使用COPY命令将宿主机中的jdk压缩包复制到镜像中，这样做存在的问题是使用Dockerfile创建镜像的宿主机必须在对应的路
#径下有这个包。我这里的包和Dockerfile文件在同一个目录下，源文件的路径需要是Dockerfile文件所在目录(上下文根目录)的相对路径
#也可以使用wget、 apt-get等命令在线下载
ADD ./target/classes/jdk-8u151-linux-x64.tar.gz /home/

#解压复制到镜像中的jdk压缩包，完成后删除，RUN命令可以使用 && 将两条命令放到一起，减少镜像的层数
#RUN tar zxf /home/jdk-8u151-linux-x64.tar.gz -C /home/JDK && rm -rf /home/jdk-8u151-linux-x64.tar.gz

#设置环境变量
ENV JAVA_HOME /home/jdk1.8.0_151
ENV PATH $PATH:$JAVA_HOME/bin

#安装tomcat，同JDK
#RUN mkdir Tomcat
ADD ./target/classes/apache-tomcat-8.0.47.tar.gz /home/
#RUN tar zxf /home/apache-tomcat-8.0.47.tar.gz -C /home/Tomcat && rm -rf /home/apache-tomcat-8.0.47.tar.gz

#暴露tomcat的内部端口，如果没有修改tomcat的配置文件的话，默认是8080端口
EXPOSE 8080

#启动容器时，执行脚本文件启动Tomcat并持续输出日志，防止容器退出。
#ENTRYPOINT /home/Tomcat/apache-tomcat-8.0.47/bin/startup.sh && tail -f /home/Tomcat/apache-tomcat-8.0.47/logs/catalina.out