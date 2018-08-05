package com.mine.Crawl;

import com.mine.Save.saveToFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class getSource {

//    public static void main(String[] args){
//        String content = getSource.source("http://gz.58.com/shouji/0/pn2/?PGTID=0d300024-0000-34ee-3e31-1bdb8c654d73&ClickID=1");
//        saveToFile.toFile(content,"test.txt");
//    }

    /**
     * 获取源码的方法
     * @param url 链接（String）
     * @return content 网页源码（String）
     */
    public static String source(String url){
        //参数为网页链接
        //返回内容为网页源码全部内容
        String content = "";
        BufferedReader in = null;
        try{
            URL readUrl = new URL(url);
            URLConnection connection = readUrl.openConnection(); //请求连接
            connection.connect();
            //注意网页的编码
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8") );
            String line;
            while((line = in.readLine()) != null){
//                content += line + "\n";
                 content += line ;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return content;
    }
}
