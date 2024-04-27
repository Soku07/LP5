import java.rmi.*;
public class Client {
public static void main(String[] args) {
    try {
        String addressUrl = "rmi://127.0.0.1/Server";
    ServerIntf serverIntf = (ServerIntf) Naming.lookup(addressUrl);
    System.out.println("First Number is " + args[0]);
    double d1 = Double.parseDouble(args[0]);
    System.out.println("First Number is " + args[1]);
    double d2 = Double.parseDouble(args[1]);
    System.out.println("Multiplication is " + serverIntf.mul(d1, d2));
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("Exception in Client " + e);
    }}


}
