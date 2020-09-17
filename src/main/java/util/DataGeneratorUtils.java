package util;

import main.ISubject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class DataGeneratorUtils implements ISubject {
    public static final Random random = new Random();
    public static String[] names={"含蕊","亦玉","靖荷","碧萱","寒云","向南","书雁","怀薇","思菱","忆文","翠巧","怀山","若山","向秋","凡白","绮烟","从蕾","天曼","又亦","依琴","曼彤","沛槐","又槐","元绿","安珊","夏之","易槐","宛亦","白翠","丹云","问寒","易文","傲易","青旋","思真","妙之","半双","若翠","初兰","怀曼","惜萍","初之","宛丝","寄南","小萍","幻儿","千风","天蓉","雅青","寄文","代天","春海","惜珊","向薇","冬灵","惜芹","凌青","谷芹","香巧","雁桃","映雁","书兰","盼香","向山","寄风","访烟","绮晴","傲柔","寄容","以珊","紫雪","芷容","书琴","寻桃","涵阳","怀寒","易云","采蓝","代秋","惜梦","尔烟","谷槐","怀莲","涵菱","水蓝","访冬","半兰","又柔","冬卉","安双","冰岚","香薇","语芹","静珊","幻露","访天","静柏"};
    public static String[] courses={"计算机类课程：C/C++语言","数据结构","算法","计算机组成原理","编译原理","操作系统","数据库原理","汇编语言","数理逻辑","数字电路","模拟电路","计算机网络"};
    static String[] interfaces={"1","4","6","7" ,"13","14","3","4"};
    static int interfaceslen = interfaces.length;
    static  String[] IMSIs={"53","37","00","28","47","66","35","07","30","46","60"};
    static int  IMSIlen=IMSIs.length;
    static String[] MSISDN={"133","132","131","177","178","191","135","136","137","198","199"};
    static int MSISDNlen =MSISDN.length;
    static String[] abc={"a","b","c","d","e","f","g","h"};
    static int abcLen=abc.length;
    static DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * studentNO uuid
     * name string comment '用户的国际移动用户识别码',
     * course string comment '用户手机号码',
     * score string comment '移动台设备标识'
     */
    public static void generateStudentInfo(String filePath,int num){
        File file = new File(filePath);
        int namelen = names.length;
        int courselen= courses.length;
        ArrayList<String> studentsInfos = new ArrayList<>();
        for(int i=0;i<num;i++){
            String studentNO= UUID.randomUUID().toString().replace("-","");
            String name = names[random.nextInt(namelen-1)];
            String course = courses[random.nextInt(courselen-1)];
            String score =String.valueOf(random.nextInt(100));
            String line=studentNO+","+name+","+course+","+score;
            studentsInfos.add(line);
        }
        try{
            FileUtils.writeLines(file,studentsInfos,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Interface
     * IMSI
     * MSISDN
     * IMInterface
     * IMSI
     * MSISDN
     * IMEISV
     * APN
     * DestinationIP
     * DestinationPort
     * SourceIP
     * SourcePort
     * SGWIP
     * MMEIP
     * PGWIP
     * ECGI
     * TAI
     * VisitedPLMNId
     * RATType
     * ProtocolID
     * ServiceType
     * StartTime
     * EndTime
     * Duration
     * InputOctets
     * OutputOctets
     * InputPacket
     * OutputPacket
     * PDNConnectionId
     * BearerID
     * BearerQoS
     * RecordCloseCause
     * ENBIP
     * SGWPort
     * eNBPort
     * eNBGTP_TEID
     * SGWGTP_TEID
     * PGWPort
     * MMEUES1APID
     * eNBUES1APID
     * MMEGroupID
     * MMECode
     * eNBID
     * Home_Province
     * UserIP
     * UserPort
     * L4protocol
     * AppServerIP
     * AppServerPort
     * ULTCPReorderingPacke
     * DLTCPReorderingPacke
     * ULTCPRetransPacket
     * DLTCPRetransPacket
     * TCPSetupResponseDela
     * TCPSetupACKDelay
     * ULIPFragPacks
     * DLIPFragPacks
     * Delay_Setup_FirstTra
     * Delay_FirstTransacti
     * WindowSize
     * MSSSize
     * TCPSynNumber
     * TCPConnectState
     * SessionStopFlag
     * UEAMBRUL
     * UEAMBRDL
     * BearerQCI
     * VideoPlaySuccess
     * VideoPlayWaitTime
     * VideoPlayHaltCount
     * VideoRecoverTime
     * FirstDataPkgTime
     * LastDataPkgTime
     * VideoApp
     * VideoSize
     * VideoThroughput
     * VideoType
     * VideoBitRate
     * VideoCacheThroughput
     * DestinationURL
     * Host
     * CachedVideoSize
     * CachedVideoDuration
     * @param filePath
     * @param num
     */
    public static void genVideoData(String filePath,int num){
        File file = new File(filePath);
        //460-03-100001|460-03-10000|46003|6|27|02000301|20190401092318|24620620215350|50000|24422|31541|79|64|512161122042000|1|FF|1|10.10.13.2|9|2|1001|2001|6|303|59|10|2|12|GD|d8c4:d8c4:d8c4:d8c4:d8c4:d8c4:d8c4:d8c4|36283|0|c46:c46:c46:c46:c46:c46:c46:c46|80|8|0|5|6|162|18|23|111|181|86|1400|800|1|0|1|2201|4412|1|1|4614|0|0|1554081798000570|1554081802999570|02000301|114007|2280|2|360|2000|c46:c46:c46:c46:c46:c46:c46:c46|c46:c46:c46:c46:c46:c46:c46:c46|9228000|4614

        ArrayList<String> VideoDatas = new ArrayList<>();
        for(int i=0;i<num;i++){

            String l1=interfaces[random.nextInt(interfaceslen-1)];
            String l2=IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+random.nextInt(9);
            String l3=MSISDN[random.nextInt(MSISDNlen-1)]+getNum();
            String l4=l3;
            String l5="CTCC";
            String tmp6="c"+random.nextInt(100)+":";
            String l6="";
            for(int j=0;j<=8;j++){
                l6+=tmp6;
            }
            l6=l6.substring(0,l6.length()-1);
            String l7=random.nextInt(100)+"";
            //
            String tmm8=abc[random.nextInt(abcLen-1)]+random.nextInt(10)+abc[random.nextInt(abcLen-1)]+random.nextInt(10)+":";
            String l8="";
            for(int k=0;k<=8;k++){
                l8+=tmm8;
            }
            l8=l8.substring(0,l8.length()-1);
            //50000|24422|31541|79|64|512161122042000|1|FF|1|10.10.13.2|9|2|1001|2001|6|303|59|10|2|12|GD|d8c4:d8c4:d8c4:d8c4:d8c4:d8c4:d8c4:d8c4|36283|0|c46:c46:c46:c46:c46:c46:c46:c46|80|8|0|5|6|162|18|23|111|181|86|1400|800|1|0|1|2201|4412|1|1|4614|0|0|1554081798000570|1554081802999570|02000301|114007|2280|2|360|2000|c46:c46:c46:c46:c46:c46:c46:c46|c46:c46:c46:c46:c46:c46:c46:c46|9228000|4614
            String l9 =random.nextInt(1000000)+"";
            String l10=getRandomIp();
            String l11=getRandomIp();
            String l12=getRandomIp();
            String l13=random.nextInt(100)+"-"+random.nextInt(50)+"-"+random.nextInt(1000000);
            String l14 =l13;
            String l15=random.nextInt(100000)+"";
            String l16=random.nextInt(10)+"";
            String l17=random.nextInt(100)+"";
            String l18="02000301";
            String l19=df.format(new Date());
            String l20=df.format(new Date());
            String l21=random.nextInt(1000000)+"";
            String l22=random.nextInt(10000)+"";
            String l23=random.nextInt(100000)+"";
            String l24=random.nextInt(100)+"";
            String l25=random.nextInt(100)+"";
            String l26=System.currentTimeMillis()+"";
            String l27=random.nextInt(10)+"";
            String l28=abc[random.nextInt(abcLen)]+abc[random.nextInt(abcLen)];
            l28=l28.toUpperCase();
            String l29=random.nextInt(2)+"";
            String l30=getRandomIp();
            String l31=random.nextInt(10)+"";
            String l32=random.nextInt(10)+"";
            String l33=random.nextInt(10000)+"";
            String l34=random.nextInt(10000)+"";
            String l35=random.nextInt(10)+"";
            String l36=random.nextInt(1000)+"";
            String l37=random.nextInt(100)+"";
            String l38=random.nextInt(10)+"";
            String l39=random.nextInt(10)+"";
            String l40=random.nextInt(100)+"";
            String l41=abc[random.nextInt(abcLen)]+abc[random.nextInt(abcLen)];
            l41=l41.toUpperCase();
            //
            String l42=l8;
            String l43=random.nextInt(50000)+"";
            String l44="0";
            String l45=l6;
            String l46=random.nextInt(100)+"";
            String l47=random.nextInt(10)+"";
            String l48="0";
            String l49=random.nextInt(10)+"";
            String l50=random.nextInt(10)+"";
            String l51=random.nextInt(1000)+"";
            String l52=random.nextInt(100)+"";
            String l53=random.nextInt(100)+"";
            String l54=random.nextInt(1000)+"";
            String l55=random.nextInt(1000)+"";
            String l56=random.nextInt(100)+"";
            String l57=random.nextInt(10000)+"";
            String l58=random.nextInt(1000)+"";
            String l59="1";
            String l60="0";
            String l61="1";
            //2|360|2000|c46:c46:c46:c46:c46:c46:c46:c46|c46:c46:c46:c46:c46:c46:c46:c46|9228000|4614
            String l62=random.nextInt(10000)+"";
            String l63=random.nextInt(10000)+"";
            String l64="1";
            String l65="1";
            String l66=random.nextInt(10000)+"";
            String l67="0";
            String l68="0";
            String l69=System.currentTimeMillis()+"";
            String l70=l68;
            String l71="02000301";
            String l72=random.nextInt(200000)+"";
            String l73=random.nextInt(10000)+"";
            String l74=random.nextInt(10)+"";
            String l75=random.nextInt(1000)+"";
            String l76=random.nextInt(10000)+"";
            String l77=l6;
            String l78=l6;
            String l79=random.nextInt(10000000)+"";
            String l80=random.nextInt(10000)+"";
            String line=l1+"|"+l2+"|"+l3+"|"+l4+"|"+l5+"|"+l6
                    +"|"+l7+"|"+l8+"|"+l9+"|"+l10+"|"+l11+"|"+l12+"|"+l13
                    +"|"+l14+"|"+l15+"|"+l16+"|"+l17+"|"
                    +l18+"|"+l19+"|"+l20+"|"+l21+"|"+l22
                    +"|"+l23+"|"+l24+"|"+l25+"|"+l26+"|"+l27
                    +"|"+l28+"|"+l29+"|"+l30+"|"+l31+"|"+l32
                    +"|"+l33+"|"+l34+"|"+l35+"|"+l36+"|"+l37+"|"
                    +l38+"|"+l39+"|"+l40+"|"+l41+"|"+l42+"|"+l43+"|"
                    +l44+"|"+l45+"|"+l46+"|"+l47+"|"+l48+"|"+l49+"|"
                    +l50+"|"+l51+"|"+l52+"|"+l53+"|"+l54+"|"+l55+"|"
                    +l56+"|"+l57+"|"+l58+"|"+l59+"|"+l60+"|"+l61+"|"
                    +l62+"|"+l63+"|"+l64+"|"+l65+"|"+l66+"|"+l67+"|"
                    +l68+"|"+l69+"|"+l70+"|"+l71+"|"+l72+"|"+l73+"|"+l74
                    +"|"+l75+"|"+l76+"|"+l77+"|"+l78+"|"+l79+"|"+l80;
            VideoDatas.add(line);
        }
        try{
            FileUtils.writeLines(file,VideoDatas,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void genHttpData(String filePath,int num){
        File file = new File(filePath);
        ArrayList<String> httpDatas = new ArrayList<>();
        for(int i=0;i<num;i++){
            String l1=interfaces[random.nextInt(interfaceslen)];
            String l2=IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+IMSIs[random.nextInt(IMSIlen-1)]+random.nextInt(9);
            String l3=MSISDN[random.nextInt(MSISDNlen-1)]+getNum();
            String l4=l3;
            String l5="CTCC";
            String tmp6="c"+random.nextInt(100)+":";
            String l6="";
            for(int j=0;j<=8;j++){
                l6+=tmp6;
            }
            l6=l6.substring(0,l6.length()-1);
            String l7="8080";
            String tmm8=abc[random.nextInt(abcLen-1)]+random.nextInt(10)+abc[random.nextInt(abcLen-1)]+random.nextInt(10)+":";
            String l8="";
            for(int k=0;k<=8;k++){
                l8+=tmm8;
            }
            l8=l8.substring(0,l8.length()-1);
            //1001|2001|4|56|491|10|2|12|GD|7e3d:7e3d:7e3d:7e3d:7e3d:7e3d:7e3d:7e3d|49600|0|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|8080|3|4|3|0|172|58|18|156|125|276|1400|800|1|0|1|5715|6434|1|test-useragent|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|172|text|0||6|200|950|0|1554081756000030|1554081756000130|1554081756000230|1554081756000330|1554081756000430|1554081760999830|1554081760999830|16663|4|1554081756000430|1554081760999930||||78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|0|0|0|0|0|1554081760999830||1
            String l9=random.nextInt(1000000)+"";
            String l10=getRandomIp();
            String l11=getRandomIp();
            String l12=getRandomIp();
            String l13=random.nextInt(1000)+"-"+random.nextInt(10)+"-"+random.nextInt(100100);
            String l14=l13;
            String l15=random.nextInt(50000)+"";
            String l16=random.nextInt(10)+"";
            String l17=random.nextInt(100)+"";
            String l18="07001500";
            String l19=df.format(new Date());
            String l20=df.format(new Date());
            String l21=random.nextInt(10000)+"";
            String l22=random.nextInt(10000)+"";
            String l23=random.nextInt(100000)+"";
            String l24=random.nextInt(100)+"";
            String l25=random.nextInt(100)+"";
            String l26=System.currentTimeMillis()+"";
            String l27="1";
            String l28=abc[random.nextInt(abcLen)]+abc[random.nextInt(abcLen)];
            l28=l28.toUpperCase();
            String l29="1";
            String l30=getRandomIp();
            String l31=random.nextInt(10)+"";
            String l32=random.nextInt(10)+"";
            //58|18|156|125|276|1400|800|1|0|1|5715|6434|1|test-useragent|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|172|text|0||6|200|950|0|1554081756000030|1554081756000130|1554081756000230|1554081756000330|1554081756000430|1554081760999830|1554081760999830|16663|4|1554081756000430|1554081760999930||||78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|78cc:78cc:78cc:78cc:78cc:78cc:78cc:78cc|0|0|0|0|0|1554081760999830||1
            String l33=random.nextInt(10000)+"";
            String l34=random.nextInt(10000)+"";
            String l35=random.nextInt(10)+"";
            String l36=random.nextInt(100)+"";
            String l37=random.nextInt(1000)+"";
            String l38=random.nextInt(100)+"";
            String l39=random.nextInt(10)+"";
            String l40=random.nextInt(100)+"";
            String l41=abc[random.nextInt(abcLen)]+abc[random.nextInt(abcLen)];
            l41=l41.toUpperCase();
            String l42=l8;
            String l43=random.nextInt(100000)+"";
            String l44="0";
            String l45=l6;
            String l46="8080";
            String l47=random.nextInt(10)+"";
            String l48=random.nextInt(10)+"";
            String l49=random.nextInt(10)+"";
            String l50=random.nextInt(10)+"";
            String l51=random.nextInt(200)+"";
            String l52=random.nextInt(100)+"";
            String l53=random.nextInt(100)+"";
            String l54=random.nextInt(200)+"";
            String l55=random.nextInt(200)+"";
            String l56=random.nextInt(300)+"";
            String l57=random.nextInt(2000)+"";
            String l58=random.nextInt(1000)+"";
            String l59="1";
            String l60="0";
            String l61="1";
            String l62=random.nextInt(10000)+"";
            String l63=random.nextInt(10000)+"";
            String l64="1";
            String l65="useragent";
            String l66=l6;
            String l67=l6;
            String l68=l6;
            String l69=random.nextInt(1000)+"";
            String l70="text";
            String l71="0";
            String l72="1";
            String l73=random.nextInt(10)+"";
            String l74=random.nextInt(1000)+"";
            String l75=random.nextInt(1000)+"";
            String l76="0";
            //|0|0|0|0|0|1554081760999830||1
            String l77=System.currentTimeMillis()+"";
            String l78=l77;
            String l79=System.currentTimeMillis()+"";
            String l80=System.currentTimeMillis()+"";
            String l81=System.currentTimeMillis()+"";
            String l82=System.currentTimeMillis()+"";
            String l83=System.currentTimeMillis()+"";
            String l84=random.nextInt(20000)+"";
            String l85=random.nextInt(10)+"";
            String l86=System.currentTimeMillis()+"";
            String l87=System.currentTimeMillis()+"";
            String l88=random.nextInt(10)+"";
            String l89=random.nextInt(10)+"";
            String l90=random.nextInt(10)+"";
            String l91=l6;
            String l92=l6;
            String l93="0";
            String l94="0";
            String l95="0";
            String l96="0";
            String l97="0";
            String l98=System.currentTimeMillis()+"";
            String l99=random.nextInt(100)+"";
            String l100=random.nextInt(2)+"";
            String line =l1+"|"+l2+"|"+l3+"|"+l4+"|"+l5+"|"+l6+"|"+l7+"|"+l8+"|"+l9+"|"+l10+"|"
                    +l11+"|"+l12+"|"+l13+"|"+l14+"|"+l15+"|"+l16+"|"+l17+"|"+l18+"|"+l19+"|"+l20+"|"+l21+"|"
                    +l22+"|"+l23+"|"+l24+"|"+l25+"|"+l26+"|"+l27+"|"+l28+"|"+l29+"|"+l30+"|"+l31+"|"+l32+"|"+l33+"|"+l34+"|"
                    +l35+"|"+l36+"|"+l37+"|"+l38+"|"+l39+"|"+l40+"|"+l41+"|"+l42+"|"+l43+"|"+l44+"|"+l45+"|"+l46+"|"+l47+"|"
                    +l48+"|"+l49+"|"+l50+"|"+l51+"|"+l52+"|"+l53+"|"+l54+"|"+l55+"|"+l56+"|"+l57+"|"+l58+"|"+l59+"|"+l60+"|"+l61+"|"
                    +l62+"|"+l63+"|"+l64+"|"+l65+"|"+l66+"|"+l67+"|"+l68+"|"+l69+"|"+l70+"|"+l71+"|"+l72+"|"+l73+"|"+l74+"|"
                    +l75+"|"+l76+"|"+l77+"|"+l78+"|"+l79+"|"+l80+"|"+l81+"|"+l82+"|"+l83+"|"+l84+"|"+l85+"|"+l86+"|"+l87+"|"
                    +l88+"|"+l89+"|"+l90+"|"+l91+"|"+l92+"|"+l93+"|"+l94+"|"+l95+"|"+l96+"|"+l97+"|"+l98+"|"+l99+"|"+l100;
            httpDatas.add(line);
        }
        try{
            FileUtils.writeLines(file,httpDatas,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getNum(){
        String num="";
        for(int i=0;i<8;i++){
            num+=random.nextInt(10);
        }
        return num;
    }
    /*
     * 随机生成国内IP地址
     */
    public static String getRandomIp() {

        // ip范围
        int[][] range = { { 607649792, 608174079 },// 36.56.0.0-36.63.255.255
                { 1038614528, 1039007743 },// 61.232.0.0-61.237.255.255
                { 1783627776, 1784676351 },// 106.80.0.0-106.95.255.255
                { 2035023872, 2035154943 },// 121.76.0.0-121.77.255.255
                { 2078801920, 2079064063 },// 123.232.0.0-123.235.255.255
                { -1950089216, -1948778497 },// 139.196.0.0-139.215.255.255
                { -1425539072, -1425014785 },// 171.8.0.0-171.15.255.255
                { -1236271104, -1235419137 },// 182.80.0.0-182.92.255.255
                { -770113536, -768606209 },// 210.25.0.0-210.47.255.255
                { -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成ip地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";

        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }

    @Override
    public void main(String... args) {
        if(args.length < 3){
            System.out.println("DataGeneratorUtils  Usage:\r\n"+
                    "genVideoData|genHttpData\r\n"+
                    "文件全路径 \r\n"+
                    "记录数"
            );
            System.exit(-5);
        }
        //DataGeneratorUtils.generateStudentInfo(args[0],Integer.parseInt(args[1]));
        String arg0= args[0];
        if("genVideoData".equalsIgnoreCase(arg0)){
            System.out.println("video data begin generating...");
            DataGeneratorUtils.genVideoData(args[1],Integer.parseInt(args[2]));
            System.out.println("video data generated.");
        }else if("genHttpData".equalsIgnoreCase(arg0)){
            System.out.println("http data begin generating...");
            DataGeneratorUtils.genHttpData(args[1],Integer.parseInt(args[2]));
            System.out.println("http data generated.");
        }

    }
}
