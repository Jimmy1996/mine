package com.mine.Crawl;

import com.mine.obj.telephone;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchMsg{

//    public static void main(String[] args){
//        String url = "http://gz.58.com/shouji/0/pn2/?PGTID=0d300024-0000-34ee-3e31-1bdb8c654d73&ClickID=1";
//        String content = getSource.source(url);
//        matchMsg aa = new matchMsg();
////        System.out.println(content);
//        aa.match(content);
//    }

    public List<telephone> match(String content){
        List<telephone> tel = new LinkedList<telephone>();
//        String reg = "<tr class=\"zzinfo \">.*?<td class=\"t\".*?class=\"t\">(.*?)</a>.*?<span  class=\"pricebiao\">(.*?\"price\".*?)</span>.*?<span class=\"fl\">(.*?)<i class=\"clear\"></i>.*?</tr>";
        String reg = "<tr class=\"zzinfo \">.*?<td class=\"t\".*?class=\"t\">(.*?)</a>.*?class=\"pricebiao\">(.*?)</span>.*?<span class=\"fl\">(.*?)<i class=\"clear\">.*?</tr>";
        //正则表达式，第一个匹配的是标题，第二是 价格 ，第三是 地区。

        Pattern pattern = Pattern.compile(reg);   
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            telephone oneTel = new telephone();

            String title = matcher.group(1);
            String price = matcher.group(2).replaceAll("<.*?>","");
            String area = matcher.group(3).replaceAll("\t","").replaceAll("<.*?>","").replaceAll(" ","");
//            String one = title + '`' + price + '`'+ area;
//            System.out.println(one);
            oneTel.setTitle(title);
            oneTel.setPrice(price);
            oneTel.setArea(area);
            tel.add(oneTel);
        }
        return tel;
    }
}
