import java.rmi.*;
public class Server {
    public static void main(String[] args) {
        try {
            ServerImpl serverImpl = new ServerImpl();
            String addressUrl = "rmi://127.0.0.1/Server"; // Address URL for the remote object
            Naming.rebind(addressUrl, serverImpl); // Bind the remote object to the address URL

            System.out.println("Server is running...");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception in Server class " + e);
        }
    }
} 
