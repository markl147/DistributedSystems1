package Q3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class WorkerThreadWithQueue extends Thread {

    private BlockingQueue<Socket> queue;

    public WorkerThreadWithQueue(BlockingQueue<Socket> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // create input and output streams using given socket
                Socket socket = queue.take();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Scanner scanner = new Scanner(in);
                PrintWriter writer = new PrintWriter(out);

                // wait for file name from user
                String fileName = scanner.nextLine();
                System.out.printf("%s is handling file %s..\n", getName(), fileName);

                // open selected file, send content back to user
                FileInputStream fis = new FileInputStream(fileName);
                Scanner fileScanner = new Scanner(fis);

                while (fileScanner.hasNextLine())
                    writer.println(fileScanner.nextLine());

                writer.flush();
                sleep(15000);
                fileScanner.close();
                System.out.printf("%s has finished handling%s file.", getName(), fileName);

                //housekeeping
                scanner.close();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
