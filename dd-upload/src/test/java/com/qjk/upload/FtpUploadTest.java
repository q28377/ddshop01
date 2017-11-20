package com.qjk.upload;

import com.qjk.ddshop.common.util.FtpUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class FtpUploadTest {
    /*@Test
    public void testFTPClient() throws Exception{
        //创建FTPClient客户端	导入含commons的包
        FTPClient ftpClient = new FTPClient();
        //创建/发送FTP连接        相当于在命令提示窗口中ftp ip地址
        ftpClient.connect("10.31.161.120",21);
        //使用登录方法
        ftpClient.login("ftpuser","qjk521qjk");
        //读取本地文件,封装一个输入流
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\lty.jpg"));
        //配置上传参数
            //上传到的路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
            //文件类型为二进制
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件  //上传后的文件名
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        ftpClient.logout();
    }*/

    //使用工具类来FTP上传文件
    /*@Test
    public void testFtpUtils() throws Exception{
        FileInputStream fs = new FileInputStream(new File("d:\\lty.jpg"));
        boolean bool = FtpUtils.uploadFile("10.31.161.120", 21, "ftpuser", "qjk521qjk", "/home/ftpuser/www/images", "/2017/11/16", "hello2.jpg", fs);
        System.out.println(bool);
        fs.close();
    }*/
}
