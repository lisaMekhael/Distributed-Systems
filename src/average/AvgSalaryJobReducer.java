package average;


import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
public class AvgSalaryJobReducer extends Reducer<Text , LongWritable,Text, LongWritable> {
	
	 
	 public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
			int salary=0;
			int number=0;
			long avg=0;
		 for (LongWritable Salaries : values) {
			 salary+=Salaries.get();
			 number++;
			 System.out.println(number);
		}
		 avg=salary/number;
		 context.write(key, new LongWritable(avg));

	 }
}
