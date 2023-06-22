import java.util.concurrent.atomic.AtomicInteger;

public class EvenThread extends Num {

    public EvenThread(Object lock, AtomicInteger counter) {
        super(lock, counter, true);
    }
}
