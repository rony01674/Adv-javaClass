package multithreading;

public class PrintChar implements Runnable {

    //The task for printing a character a specified number of times
    private char charToPrint; //The character to print
    private int times; // The number of time to repeat

    /**
     * Construct a task with a specified character and number of times to print
     * the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    /**
     * Override the run() method to tell the system what task to perform
     */

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(charToPrint);
        }
    }
}
