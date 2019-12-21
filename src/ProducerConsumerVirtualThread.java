import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;

public class ProducerConsumerVirtualThread {

    private static SynchronousQueue queue = new SynchronousQueue();
    private static void produce(){
        int c = 0;
        for (int i = 0; i <5 ; i++) {
            try {
                queue.put(++c);
                System.out.println("put: "+c+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        }
    }

    private static void consume(){
        for (int i = 0; i <5 ; i++) {
            try {
                System.out.println("take: "+queue.take()+Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args) {
        try (ExecutorService scheduler = Executors.newFixedThreadPool(1)) {
            ThreadFactory factory = Thread.builder().virtual(scheduler).factory();
            try (ExecutorService executor = Executors.newUnboundedExecutor(factory)) {
                executor.submit(() -> produce());
                executor.submit(() -> consume());

            }
        }
    }
}
