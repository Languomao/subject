package parse.telemetryparse;

import main.ISubject;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import parse.telemetryparse.topologybeans.ContentObject;
import parse.telemetryparse.topologybeans.DataModel;
import parse.telemetryparse.topologybeans.KeysObject;
import parse.telemetryparse.topologybeans.RowsObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static parse.telemetryparse.DataPretreatment.data2str;
import static parse.telemetryparse.DataPretreatment.getDataStr;
import static parse.utils.Write2Local.write2Local;

/**
 * Classname TopologyParse
 * Date 2020/6/12 16:09
 * Created by LanKorment
 * path : Cisco-IOS-XR-infra-xtc-agent-oper:xtc/topology-summary
 * 需要传入个参数，分别为
 */
public class TopologyParse implements ISubject{
    /*public static void main(String[] args){
        StringBuffer strbuff = getDataStr("D:\\WorkSpace\\Telemetry\\dump-topology-summary.txt");
        String[] result = data2str(strbuff);
        parse(result);
    }*/

    @Override
    public void main(String... args){
        if(args.length == 2){
            String inputpath=args[0];
            String outputpath = args[1];
            //String topic = args[2];

            StringBuffer strbuff = getDataStr(inputpath);
            String[] result = data2str(strbuff);
            try {
                parse(result,outputpath);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("异常");
            }
        }else{
            System.out.println("TopologyParse Usage: "+
                    "inputpath  outputpath"
            );
            System.exit(-3);
        }
    }

    //解析json数据
    public static void parse(String[] strarr,String outputpath){

        for(int i = 1 ; i < strarr.length ; i++){

            String str = strarr[i].replace("-------\n","");

            //System.out.println(json);
            //要解析的对象
            //String json = "";

            //获取Topology的数据
            DataModel dataModel = new DataModel();

            //获取标头信息
            String header = StringUtils.substringBetween(str,"2020-","]") + "]";
            //String header = "预处理获取标头信息";
            dataModel.header = header;

            String json = StringUtils.substringAfter(str,header);
            //System.out.println(json);
            //首先看到的是一个{}所以用JSON Object来进行解析
            //获得外部的TopologyObject
            JSONObject obj = new JSONObject(json);


            String source = obj.getString("Source");
            dataModel.source = source;


            //获取Telemetry的数据
            JSONObject obj1 = obj.getJSONObject("Telemetry");
            TelemetryObject telemetry = new TelemetryObject();
            telemetry.node_id_str = obj1.getString("node_id_str");
            telemetry.subscription_id_str = obj1.getString("subscription_id_str");
            telemetry.encoding_path = obj1.getString("encoding_path");
            telemetry.collection_id = obj1.getInt("collection_id");
            telemetry.collection_start_time = obj1.getLong("collection_start_time");
            telemetry.msg_timestamp = obj1.getLong("msg_timestamp");
            telemetry.collection_end_time = obj1.getLong("collection_end_time");
            dataModel.telemetry = telemetry;

            //获取Rows数组
            List<RowsObject> rows=new ArrayList<>();
            JSONArray jArr = obj.getJSONArray("Rows");
            for (int j = 0; j < jArr.length(); j++) {
                JSONObject obj2 = jArr.getJSONObject(j);
                RowsObject row = new RowsObject();
                row.row_timestamp = obj2.getLong("Timestamp");

                //获取Keys数据
                //Object obj3 = obj2.get("Keys");
                KeysObject keys = new KeysObject();
                //keys.interface_name = obj3.getString("interface_name");
                keys.interface_name = "null";
                row.keys = keys;

                //获取Content的数据
                JSONObject obj4 = obj2.getJSONObject("Content");
                ContentObject content = new ContentObject();
                content.adjacency_sids = obj4.getInt("adjacency-sids");
                content.links = obj4.getInt("links");
                content.nodes = obj4.getInt("nodes");
                content.prefix_sids = obj4.getInt("prefix-sids");
                content.prefixes = obj4.getInt("prefixes");
                //ContentObject content = obj2.getJSONObject("");
                row.content = content;

                rows.add(row);
            }
            dataModel.row = rows;
            //输出字段
            System.out.println(dataModel);
            try {
                write2Local(outputpath,dataModel.toString());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("写入异常。。。。。。");
            }
        }

    }

}
