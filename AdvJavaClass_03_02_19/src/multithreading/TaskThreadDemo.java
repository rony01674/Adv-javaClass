package multithreading;

import multithreading.PrintNum;
import multithreading.PrintChar;

public class TaskThreadDemo {

    public static void main(String[] args) {
        // Create tasks
        Runnable printA = new PrintChar('a', 1);
        Runnable printB = new PrintChar('b', 1);
        Runnable prin100 = new PrintNum(100);

        //Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(prin100);

        //Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
