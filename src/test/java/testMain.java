import com.alibaba.fastjson.JSON;
import com.mine.Crawl.getSource;
import com.mine.Crawl.matchMsg;
import com.mine.Save.saveToFile;
import com.mine.obj.telephone;

import java.util.LinkedList;
import java.util.List;

public class testMain {

    public static void main(String[] args){
        List<telephone>  tel = new LinkedList<telephone>();

        String url = "http://gz.58.com/shouji/0/pn2/?PGTID=0d300024-0000-34ee-3e31-1bdb8c654d73&ClickID=1";
        String content = getSource.source(url);
        matchMsg mat = new matchMsg();

        tel = mat.match(content);

        String all = JSON.toJSONString(tel);
        System.out.println(all);
        saveToFile.toFile(all,"telephone\\2.json");
    }

}
