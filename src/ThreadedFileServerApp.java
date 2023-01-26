import java.net.ServerSocket;

public class ThreadedFileServerApp {

    public static void main(String[] args) {
        //Start the socket, to receive connection

        ServerSocket ss = new ServerSocket(2001);
        System.out.println("Server is running...");

        //using while loop, wait for incoming cnnection
        while (true) {
            //Create socket and pass it to worker thread
            Socket s = ss.accept();

            //start the worker thread

            Thread thread = new WorkerThread(s);
            thread.start();
        }
    }
}
