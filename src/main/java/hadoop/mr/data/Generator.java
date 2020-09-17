package hadoop.mr.data;

import com.xiaoleilu.hutool.io.FileUtil;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Generator {
    private static final Random random = new Random();
    private static final String[] languages ={"zh-CN","English","japanese","Franch","korea"};
    private static final String[] domains={"google.com","sina.com","yahoo.com","baidu.com","anta.com","pornhub.com","github.com","bilibli.com","youtube.com"};
    private static LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();
    public static void main(String[] args) throws InterruptedException{
        ArrayList<String> list = new ArrayList<>();
//        iPhone4s
//        3.5英寸
//        320  *  480
//        iPhoneSE
//        4.0英寸
//        320  *  568
//        iPhone6
//        4.7英寸
//        375  *  667
//        iPhone6s
//        4.7英寸
//        375  *  667
//        iPhone7
//        4.7英寸
//        375  *  667
//        iPhone6P
//        5.5英寸
//        414  *  736
//        iPhone6sP
//        5.5英寸
//        414  *  736
//        iPhone7P
//        5.5英寸
//        414  *  736
//        iPadPro
//        9.7英寸
//        768  *  1024
//        iPadPro
//        12.9英寸
//        1024 *  1366
        lhm.put(320  , 480);
        lhm.put(375   , 667);
        lhm.put(414  , 736);
        lhm.put(768  , 1024);
        lhm.put(1024  , 1366);
        Object[] keys = lhm.keySet().toArray();
        for(int i=0;i<10000;i++){
            String user_ip=random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255);
            String tracecode = UUID.randomUUID().toString().replace("-", "");
            String seesionId = UUID.randomUUID().toString().replace("-", "");
            String domain = domains[random.nextInt(domains.length)];
            Object width = keys[random.nextInt(keys.length-1)];
            String language = languages[random.nextInt(languages.length-1)];
            //TimeUnit.MILLISECONDS.sleep(10);
            Log log = new Log(String.valueOf(System.currentTimeMillis()),user_ip,tracecode,seesionId,domain,Integer.parseInt(width+""),lhm.get(width),random.nextInt(99999),language,"http://"+domain,domain,"","","","","",String.valueOf(random.nextInt(999999)));
            list.add(log.toString());
        }
        FileUtil.writeLines(list,new File("/home/hzxlciny/job/test/log.txt"),"utf-8",true);
    }
}
