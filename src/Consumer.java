import java.io.IOException;

public class Consumer extends PrimeNumbers implements Runnable {


    Consumer(int n, int b, String out) {
        super(n, b, out);
    }

    @Override
    public void run() {
        try {
            Consumer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}