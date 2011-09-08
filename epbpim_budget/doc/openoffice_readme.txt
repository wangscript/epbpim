1.windows下安装文件下载地址：
http://download.services.openoffice.org/files/stable/3.3.0/OOo_3.3.0_Win_x86_install-wJRE_en-US.exe

2.安装成功后，进入“安装目录\OpenOffice.org 3\program”文件夹下。运行一下命令来启动服务
soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard

3.测试一下8100端口是否能使用。cmd命令“telnet localhost 8100”。如果没开启，就会出现连接不上的消息。

