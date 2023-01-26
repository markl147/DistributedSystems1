package Q2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
        try {
            // first in, first out
            queue.put("String 1");
            queue.put("String 2");
            queue.put("String 3");
            queue.put("String 4");

            System.out.println(queue.take());
            queue.put("String 5");

            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
