import java.util.concurrent.atomic.AtomicInteger;

public class OddThread extends Num {
    public OddThread(Object lock, AtomicInteger counter) {
        super(lock, counter, false);
    }
}
