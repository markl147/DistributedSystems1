import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ReadFileClient {

    public static void main(String[] args) {
        try {
        // create socket connection with server
        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, 2001);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(in);
        PrintWriter writer = new PrintWriter(out);

        // request file content using file name
        writer.println("text.txt");
        writer.flush();

        // display file content
        while(scanner.hasNextLine())
            System.out.println(scanner.nextLine());

        scanner.close();
        writer.close();
        in.close();
        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
