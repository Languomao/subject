package hadoop.mr;

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


public class WordcountRunner implements ISubject {



    static class WordCountMapper extends Mapper<LongWritable, Text,Text,LongWritable>{
        @Override
        protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String domain = line.split(",")[4];
            context.write(new Text(domain),new LongWritable(1));
        }
    }
    static class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable>{
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            Long counter=0l;
            for(LongWritable value:values){
                counter+=value.get();
            }
            context.write(key,new LongWritable(counter));
        }
    }

    @Override
    public void main(String... args) {
      try{
          Configuration conf = new Configuration();
          FileSystem fs = FileSystem.get(conf);
          Job job = Job.getInstance(conf);
          job.setJarByClass(WordcountRunner.class);
          job.setMapperClass(WordCountMapper.class);
          job.setReducerClass(WordCountReducer.class);
          job.setMapOutputKeyClass(Text.class);
          job.setMapOutputValueClass(LongWritable.class);
          job.setOutputKeyClass(Text.class);
          job.setOutputValueClass(LongWritable.class);
          job.setNumReduceTasks(1);
          String inputPath="/usr/zxl/mapreduce/data";
          String outputPath ="/usr/zxl/mapreduce/wordcount";
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
