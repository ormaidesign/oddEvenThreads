import java.util.concurrent.atomic.AtomicInteger;

public class Num extends Thread {
    protected Object lock;
    protected AtomicInteger counter;
    final protected boolean isEven;

    public Num(Object lock, AtomicInteger counter, boolean isEven) {
        this.lock = lock;
        this.counter = counter;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while(true && counter.get() < 100) {
                if ((counter.get() % 2 == 0 && isEven) || (counter.get() % 2 == 1 && !isEven)) {
                    System.out.println(counter.get());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    counter.incrementAndGet();
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
