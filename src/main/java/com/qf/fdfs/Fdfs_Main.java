package com.qf.fdfs;

import com.qf.utils.FdfsUtils;
import org.csource.common.MyException;

import java.io.IOException;

public class Fdfs_Main {
    public static void main(String[] args) throws IOException, MyException {
        String url="http://10.0.127.179/";
        String xml = new FdfsUtils("classpath:fastdfs-client.properties").uploadFile("pom.xml", "xml");
        System.out.println(url+xml);
    }
}
