package average;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context; 
import org.apache.hadoop.io.LongWritable;
                                      // input key , input value , output key , output value
public class AvgSalaryJobMapper extends Mapper<  LongWritable, Text, Text , LongWritable> {

	  @Override
	  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		  String value1 = value.toString();
		  String[] splitted = value1.split(",");

		  
		  Text job = new Text(); //Key
		  LongWritable Salary = new LongWritable(); //value
		  
		  
		  job.set(splitted[1]);
		  Salary.set(Long.parseLong(splitted[2]));
		  
		  context.write(job, Salary);
 
	  }

}
