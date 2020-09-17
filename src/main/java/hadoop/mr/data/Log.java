package hadoop.mr.data;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Log  implements Writable {
    private String timestamp;
    private String user_ip;
    private String user_tracecode;
    private String user_sessionid;
    private String domain;
    private Integer screen_width;
    private Integer screen_height;
    private Integer color_dept;
    private String  language;
    private String url;
    private String referer;
    private String user_agent;
    private String account;
    private String event;
    private String event_data;
    private String referer2;
    private String referer_code;

    public Log() {
    }

    public Log(String timestamp, String user_ip, String user_tracecode, String user_sessionid, String domain, Integer screen_width, Integer screen_height, Integer color_dept, String language, String url, String referer, String user_agent, String account, String event, String event_data, String referer2, String referer_code) {
        this.timestamp = timestamp;
        this.user_ip = user_ip;
        this.user_tracecode = user_tracecode;
        this.user_sessionid = user_sessionid;
        this.domain = domain;
        this.screen_width = screen_width;
        this.screen_height = screen_height;
        this.color_dept = color_dept;
        this.language = language;
        this.url = url;
        this.referer = referer;
        this.user_agent = user_agent;
        this.account = account;
        this.event = event;
        this.event_data = event_data;
        this.referer2 = referer2;
        this.referer_code = referer_code;
    }

    public Log(String user_ip, String user_sessionid) {
        this.user_ip = user_ip;
        this.user_sessionid = user_sessionid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public String getUser_tracecode() {
        return user_tracecode;
    }

    public void setUser_tracecode(String user_tracecode) {
        this.user_tracecode = user_tracecode;
    }

    public String getUser_sessionid() {
        return user_sessionid;
    }

    public void setUser_sessionid(String user_sessionid) {
        this.user_sessionid = user_sessionid;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getScreen_width() {
        return screen_width;
    }

    public void setScreen_width(Integer screen_width) {
        this.screen_width = screen_width;
    }

    public Integer getScreen_height() {
        return screen_height;
    }

    public void setScreen_height(Integer screen_height) {
        this.screen_height = screen_height;
    }

    public Integer getColor_dept() {
        return color_dept;
    }

    public void setColor_dept(Integer color_dept) {
        this.color_dept = color_dept;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent_data() {
        return event_data;
    }

    public void setEvent_data(String event_data) {
        this.event_data = event_data;
    }

    public String getReferer2() {
        return referer2;
    }

    public void setReferer2(String referer2) {
        this.referer2 = referer2;
    }

    public String getReferer_code() {
        return referer_code;
    }

    public void setReferer_code(String referer_code) {
        this.referer_code = referer_code;
    }

//    @Override
//    public String toString(){
//        return user_ip+"\t"+user_sessionid;
//    }
    @Override
    public String toString() {
        return timestamp + "," +
                user_ip + ","+
                user_tracecode + "," +
                user_sessionid + "," +
                domain + "," +
                 screen_width +","
               + screen_height +","+
                 color_dept +","+
                 language + "," +
                url + ","+
                referer + "," +
                 user_agent + "," +
                 account + "," +
                event + "," +
                event_data + "," +
                referer2 + "," +
                referer_code
                ;
    }
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(user_ip);
        dataOutput.writeUTF(user_sessionid);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        user_ip = dataInput.readUTF();
        user_sessionid = dataInput.readUTF();
    }
}
