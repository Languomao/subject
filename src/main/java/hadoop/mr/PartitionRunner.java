package hadoop.mr;

import hadoop.mr.data.Log;
import main.ISubject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class PartitionRunner implements ISubject {
    static class PartitionMapper extends Mapper<LongWritable, Text,Text, Log> {
        @Override
        protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields=line.split(",");
            String domain = fields[4];
            context.write(new Text(domain),new Log(fields[1],fields[3]));
        }
    }
    static class PartitionReducer extends Reducer<Text,Log,Text,Log> {
        @Override
        protected void reduce(Text key, Iterable<Log> values, Context context) throws IOException, InterruptedException {
            for(Log log:values){
                context.write(key,log);
            }
        }
    }

    @Override
    public void main(String... args) {
        try{
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Job job = Job.getInstance(conf);
            job.setJarByClass(PartitionRunner.class);
            job.setMapperClass(PartitionMapper.class);
            job.setReducerClass(PartitionReducer.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Log.class);
            //指定自定义partitioner类
            job.setPartitionerClass(DomainPartitioner.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Log.class);
            job.setNumReduceTasks(9);
            String inputPath="/usr/zxl/mapreduce/data";
            String outputPath ="/usr/zxl/mapreduce/partitioner";
            Path path = new Path(outputPath);
            if(fs.exists(path))
                fs.delete(path,true);
            FileInputFormat.setInputPaths(job,new Path(inputPath));
            FileOutputFormat.setOutputPath(job,new Path(outputPath));
            job.waitForCompletion(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
