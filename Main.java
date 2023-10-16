import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        // Create a Timer instance for scheduling tasks
        Timer timer = new Timer();

        // Define a TimerTask for the scheduled task
        TimerTask task = new TimerTask() {

            int counter = 10; // Initialize a counter
            @Override
            public void run() {
                if (counter > 0) {
                    // Print the remaining seconds
                    System.out.println(counter+" seconds");
                    counter--;
                }
                else {
                    // Print a message when the countdown reaches 0
                    System.out.println("Happy birthday");
                    timer.cancel(); // Cancel the timer to stop the task
                }
                //System.out.println("Task is complete!");

            }
        };

        // Create a Calendar instance and set it to the target date and time
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR,2023);
        date.set(Calendar.MONTH,Calendar.OCTOBER);
        date.set(Calendar.DAY_OF_MONTH,16);
        date.set(Calendar.HOUR_OF_DAY,0);
        date.set(Calendar.MINUTE,0);
        date.set(Calendar.SECOND,0);
        date.set(Calendar.MILLISECOND,0);

        // Schedule the task to run once after a delay of 1000 milliseconds
        //timer.schedule(task,1000);

        // Schedule the task to run at the specified date and time
        //timer.schedule(task, date.getTime());

        // Schedule the task to run at fixed intervals (every 1000 milliseconds)
        timer.scheduleAtFixedRate(task,0,1000);
    }
}