package com.mine.Save;

import java.io.*;

/**
 * 将内容存到文件的类
 * 方法：toFile
 * 属性：basePath (默认的存储文件的基本路径：在data文件夹下)
 */
public class saveToFile {
    static String basePath = new File("").getAbsolutePath() + "\\src\\main\\java\\data\\";

    /**
     * 将文件内容存到文件里的方法
     * @param content ：存储的内容（String）
     * @param path：路径（String） 写文件名即可，如test.txt。亦可写相对于data文件夹的路径 ，如：“test\\t.txt”
     */
    public static void toFile(String content,String path){
        File f = new File(basePath + path);
        File parent = f.getParentFile();
        if((parent != null)&&(!parent.exists())){
            parent.mkdirs();
        }if(!f.exists())try{
            f.createNewFile();
            DataOutputStream output = new DataOutputStream(new FileOutputStream(f));
            output.write(content.getBytes("utf-8"));
            output.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        getSource.toFile("哈航啊哈","test.txt");
//    }
}
