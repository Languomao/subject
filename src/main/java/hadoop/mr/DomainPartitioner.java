package hadoop.mr;

import hadoop.mr.data.Log;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class DomainPartitioner extends Partitioner<Text, Log> {
//    anta.com        1088
//    baidu.com       1121
//    bilibli.com     1116
//    github.com      1150
//    google.com      1041
//    pornhub.com     1121
//    sina.com        1124
//    yahoo.com       1097
//    youtube.com     1142
    private static final HashMap<String,Integer> DOMAIN_DICT = new HashMap<>();
    static {
        DOMAIN_DICT.put("anta.com",0);
        DOMAIN_DICT.put("baidu.com",1);
        DOMAIN_DICT.put("bilibli.com",2);
        DOMAIN_DICT.put("github.com",3);
        DOMAIN_DICT.put("google.com",4);
        DOMAIN_DICT.put("pornhub.com",5);
        DOMAIN_DICT.put("sina.com",6);
        DOMAIN_DICT.put("yahoo.com",7);
        DOMAIN_DICT.put("youtube.com",8);
    }

    @Override
    public int getPartition(Text text, Log log, int i) {
        return DOMAIN_DICT.get(text.toString())==null?9:DOMAIN_DICT.get(text.toString());
    }
}
