package Q1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedFileServerApp {

    public static void main(String[] args) {
        //Start the socket, to receive connection
        try {
            ServerSocket ss = new ServerSocket(2001);
            System.out.println("Server is running...");

            //using while loop, wait for incoming cnnection
            while(true) {
                //Create socket and pass it to worker thread
                Socket s = ss.accept();

                //start the worker thread

                Thread thread = new WorkerThread(s);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
