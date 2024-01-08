import java.time.Duration;
import java.time.Instant;

// The Timer class keeps track of the time taken by the player
public class Timer {

    // Variables to store the start and end times
    private Instant start;
    private Instant end;

    // A boolean to indicate if the timer is running
    private boolean isRunning = false;

    // Method to start the timer
    public void start() {
        this.start = Instant.now();
        this.isRunning = true;
    }

    // Method to stop the timer
    public void stop() {
        this.isRunning = false;
        this.end = Instant.now();
    }

    // Method to display the elapsed time
    public void displayTime() {
        if (!isRunning) {
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Time taken: " + timeElapsed.toMinutesPart() + "m " + timeElapsed.toSecondsPart() + "s");
        } else {
            System.out.println("Timer is still running...");
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
