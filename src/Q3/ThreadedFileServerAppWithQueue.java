package Q3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadedFileServerAppWithQueue {
    private final static int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        //Start the socket, to receive connection
        try {
            ServerSocket ss = new ServerSocket(2001);
            System.out.println("Server is running...");

            BlockingQueue<Socket> queue = new ArrayBlockingQueue<Socket>(10);

            for(int i = 0; i < NUMBER_OF_THREADS; i++)
                new WorkerThreadWithQueue(queue).start();

            //using while loop, wait for incoming cnnection
            while(true) {
                //Create socket and pass it to worker thread
                queue.put(ss.accept());

                //start the worker thread

//                Thread thread = new WorkerThread(s);
//                thread.start();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
