
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    public Runnable getRunnable() throws UnknownHostException, IOException {
        return () -> {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);
                try (
                    PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                    String line = fromSocket.readLine();
                    System.out.println("Response from Server " + line);
                } catch (IOException e) {
                    System.err.println("IOException: " + e.getMessage());
                }
                // The socket will be closed automatically when leaving the try-with-resources block
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
            }
        };
    }
    
    public static void main(String[] args){
        Client client = new Client();
        for(int i=0; i<100; i++){
            try{
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            } catch (IOException ex) {
                System.err.println("Exception: " + ex.getMessage());
            }
        }
        
    }
}