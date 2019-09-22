package ThreadLocalTest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.schedule(() -> {
            try{
                TimeUnit.MICROSECONDS.sleep(1000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        },1000, TimeUnit.MICROSECONDS);
    }
}
