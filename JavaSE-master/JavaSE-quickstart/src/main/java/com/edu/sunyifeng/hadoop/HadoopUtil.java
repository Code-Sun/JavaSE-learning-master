package com.edu.sunyifeng.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


import java.io.IOException;

public class HadoopUtil {

    static String ipAndPort="hdfs://192.168.205.122:9000";

    /**
     * 创建目录
     *
     * @param ipAndPort
     * @param dir
     * @return
     * @throws IOException
     */
    public static String mkdir(String ipAndPort,String dir) throws IOException {
        //配置参数，指定NameNode地址
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", ipAndPort);
        //创建客服端
        FileSystem client = FileSystem.get(conf);
        //创建目录
        client.mkdirs(new Path(dir));
        //关闭客户端
        client.close();
        return ipAndPort+"/"+dir;
    }

    public static void main(String[] args) throws Exception{

        // 创建目录测试
        /*String dir="/suntest/test1";
        String newdir = mkdir(ipAndPort, dir);
        System.out.println(newdir);*/



    }
}
