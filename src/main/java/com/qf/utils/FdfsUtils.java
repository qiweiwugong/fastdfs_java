package com.qf.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FdfsUtils {

   private TrackerClient trackerClient ;
   private TrackerServer trackerServer;
   private StorageServer storageServer ;
   private   StorageClient1 storageClient ;
   private String conf;
   public  FdfsUtils(String conf){
       if(conf.startsWith("classpath")){
           conf = conf.replace("classpath:",getClass().getResource("/").getPath());
       }
       try {
           ClientGlobal.init(conf);
           trackerClient = new TrackerClient();
           trackerServer = trackerClient.getConnection();
           storageClient =new StorageClient1(trackerServer, storageServer);
       } catch (IOException e) {
           e.printStackTrace();
       } catch (MyException e) {
           e.printStackTrace();
       }
   }
   //传入
   public String uploadFile(String filePath,String extName){
       try {
           return   storageClient.upload_file1(filePath,extName,null);
       } catch (IOException e) {
           e.printStackTrace();
       } catch (MyException e) {
           e.printStackTrace();
       }
       return null;
   }
   //传入文件内容
    public String uploadBytes(byte[] contents,String extName){

        if(extName.lastIndexOf(".")>=1){
            extName=extName.substring(extName.lastIndexOf(".")+1);
        }
        try {
            return storageClient.upload_file1(contents,extName,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }



}
