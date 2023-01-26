import java.net.Socket;

public class WorkerThread extends Thread {

    private Socket socket;

    public WorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // create input and output streams using socket
    }
}
