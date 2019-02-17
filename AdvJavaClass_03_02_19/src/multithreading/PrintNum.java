package multithreading;

public class PrintNum implements Runnable {

    //The task class for printing numbers from 1 to n for a given n
    private int lastName;

    /**
     * Construct a task for printing1,2,....,n
     */
    public PrintNum(int n) {
        lastName = n;
    }

    @Override
    /**
     * Tell the thread how to run
     */
    public void run() {
        for (int i = 1; i <= lastName; i++) {
            System.out.println(" " + i);
        }
    }

}
