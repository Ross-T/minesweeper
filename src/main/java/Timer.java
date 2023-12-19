import java.time.Duration;
import java.time.Instant;

public class Timer {
    private Instant start;
    private Instant end;
    private boolean isRunning = false;

    public void start() {
        this.start = Instant.now();
        this.isRunning = true;
    }

    public void stop() {
        this.isRunning = false;
        this.end = Instant.now();
    }

    public void displayTime() {
        if (!isRunning) {
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Time taken: " + timeElapsed.toMinutesPart() + "m " + timeElapsed.toSecondsPart() + "s");
        } else {
            System.out.println("Timer is still running...");
        }
    }
}
