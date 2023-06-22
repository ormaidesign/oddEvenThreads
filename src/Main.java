import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Object lock = new Object();
        AtomicInteger counter = new AtomicInteger(1);
        Thread evenThread = new EvenThread(lock, counter);
        Thread oddThread = new OddThread(lock, counter);
        evenThread.start();
        oddThread.start();
    }
}

