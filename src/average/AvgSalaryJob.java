package average;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import average.*;

public class AvgSalaryJob {  //job with max salary is "Data Analytics Lead 405000"

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		String[] pathArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		if (pathArgs.length != 2)
		{
		System.err.println("MR Project Usage: wordcount <input-path> […] <output-path>");
		System.exit(2);
		}
		Job job = Job.getInstance(conf, "Average Salary");
		job.setJarByClass(AvgSalaryJob.class);
	 
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));

	    job.setMapperClass(AvgSalaryJobMapper.class);
	    job.setReducerClass(AvgSalaryJobReducer.class);
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(LongWritable.class);
	    
	    System.exit(job.waitForCompletion(true) ? 0 : 1);


	}

}
