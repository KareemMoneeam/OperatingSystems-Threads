import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class PrimeNumbers {
    private int num;
    private int BufferSize;
    private int check =0;
    protected long start;
    protected long duration;
    int LargestPrime=0;
    int count=0;
    String output;
    private Queue<Integer> primeQueue= new LinkedList<>();
    PrimeNumbers(int n,int b,String out){
        num=n;
        BufferSize=b;
        output=out;

    }
    public synchronized Queue Producer(){
        start = System.currentTimeMillis();
        while (primeQueue.size() >= BufferSize){
            try{ wait();} catch(Exception e){}
        }
        for(int i=2;i<num;i++){
            for(int j=2;j<=(i/2);j++){
                if(i%j==0){
                    check=1;
                    continue;
                }
            }
            if (check==0){primeQueue.add(i); count++; LargestPrime=i;}
            else{check=0;}
        }
        return primeQueue;
    }
    public synchronized void Consumer() throws IOException{
        Queue<Integer> q2=new LinkedList<>();
        q2=Producer();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter(output + ".txt"));
            while(q2.size() ==0){
                try{ wait();} catch(Exception e){}
            }
            while(q2.size()!=0){
                String value=Integer.toString(q2.poll());
                writer.write(value+" , ");
            }
            writer.close();
        }catch(IOException e){e.printStackTrace();}
        duration = System.currentTimeMillis() - start;
    }
}