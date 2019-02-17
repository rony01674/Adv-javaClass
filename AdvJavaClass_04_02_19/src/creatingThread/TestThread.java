package creatingThread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestThread extends Thread {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <= 50; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdvJavaClass_04_02_19.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
