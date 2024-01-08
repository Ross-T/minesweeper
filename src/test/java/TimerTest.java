import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {

    @Test
    public void testTimer() {
        Timer timer = new Timer();
        timer.start();
        assertTrue(timer.isRunning());
        timer.stop();
        assertFalse(timer.isRunning());
    }
}
