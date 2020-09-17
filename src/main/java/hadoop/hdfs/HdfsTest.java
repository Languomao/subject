package hadoop.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class HdfsTest {
    FileSystem fs=null;
    //创建文件夹
    public static void mkdir(String path)throws IOException{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        boolean success = fs.mkdirs(new Path(path));
        if(success){
            System.out.println(path+" create success!");
        }else{
            System.out.println(path+ " create fail!");
        }

    }
    //创建新文件
    public static void createNewFile(String dst,byte[] contents) throws IOException {
        Configuration conf= new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path dstPath = new Path(dst);
        FSDataOutputStream outputs = fs.create(dstPath);
        outputs.write(contents);
        outputs.close();
        fs.close();
        System.out.println("create success");
    }
    //上传本地文件
    public static void uploadFile(String src,String dst) throws IOException{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path srcPath = new Path(src);
        Path dstPath = new Path(dst);
        fs.copyFromLocalFile(false,srcPath,dstPath);
        System.out.println("Upload to "+
                conf.get("fs.default.name"));
        System.out.println("------------list files----------------");
        FileStatus[] fileStatuses = fs.listStatus(dstPath);

        for(FileStatus file: fileStatuses){
            System.out.println(file.getPath());
        }
        fs.close();
    }
    //删除文件
    public static void delete(String path) throws IOException{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        boolean success = fs.deleteOnExit(new Path(path));
        if(success)
            System.out.println("delete success");
        else
            System.out.println("delete failed");
    }
    //读取文件的内容
    public static void readFile(String filePath) throws IOException{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path srcPath = new Path(filePath);
        InputStream in =null;
        try{
            in = fs.open(srcPath);
            IOUtils.copyBytes(in,System.out,4096,false);
        }finally{
            IOUtils.closeStream(in);
        }
    }

    public static void main(String[] args) throws IOException{
        //mkdir("/doc");
        //uploadFile("/home/hzxlciny/job/doc","/doc");
        readFile("/doc/doc/spider.txt");
        delete("/doc");
    }
}
