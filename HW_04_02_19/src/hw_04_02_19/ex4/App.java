package hw_04_02_19.ex4;

/**
 *
 * @author J2EE-33
 */
public class App {

    public static void main(String[] args) {
        new TestThreadYield("Thread 1");
        new TestThreadYield("Thread 2");
        new TestThreadYield("Thread 3");
        new TestThreadYield("Thread 4");
        new TestThreadYield("Thread 5");
    }
}
