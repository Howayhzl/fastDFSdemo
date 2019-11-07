package com.fastDFS.test;

import org.csource.fastdfs.*;

public class fastDFStest {
    public static void main(String[] args) throws Exception {
        //1. 加载配置文件
        ClientGlobal.init("G:\\PinyougouProjectDev\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
        //2.创建一个TrackerClient对象,直接new
        TrackerClient trackerClient = new TrackerClient();
        //3.根据TrackerClient对象获取TrackerClient的连接TrackerServier
        TrackerServer trackerServer = trackerClient.getConnection();
        //4.构建一个存储服务器StorageServer,引用Null
        StorageServer storageServer = null;
        //5.创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //6.使用StorageClient对象上传文件
        String[] upload_files = storageClient.upload_file("G:\\PinyougouProjectDev\\pages\\1.jpg", "jpg", null);
        //7.返回file_ID，主要包括组和路径
        for (String upload_file : upload_files) {
            System.out.println(upload_file);
        }
    }
}
