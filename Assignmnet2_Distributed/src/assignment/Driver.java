package assignment;
import java.util.concurrent.*;
import assignment.*;

public class Driver 
{
    public static void main(String args[]) throws InterruptedException 
    {
        // creating a Semaphore object with number of permits 1
        Semaphore sem = new Semaphore(1);
          
        //TODO create two threads with name A and B
        MyThread ThreadA = new MyThread(sem, "A");
        MyThread ThreadB = new MyThread(sem, "B");

        // Note that thread A will increment the CumSum
        
        // and thread B will decrement the CumSum
          
        //TODO start threads A and B
        ThreadA.start();
        ThreadB.start();
        //TODO wait for threads A and B 
        ThreadA.join();
        ThreadB.join();
 
          
        //TODO Print the CumSum Value after executing the 2 threads
        System.out.println("final value for CumSum:" + Shared.CumSum);
    }
}