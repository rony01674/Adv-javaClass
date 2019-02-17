package creatingThread;

public class MyRunnableTest {

    public static void main(String[] args) {
        //MyRunnable mr = new MyRunnable();

        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
