import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class ClockThree {
    public static void main(String[] args) {
        try{
            ServerIntf s3 = new ServerImpl(LocalTime.parse("07:05:00", AppConstants.formatter));
            Registry r3 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_3);
            r3.rebind(ServerImpl.class.getSimpleName(), s3);
            System.out.println("Server started on port " + AppConstants.SERVER_PORT_3);
        }catch(Exception e){
            System.out.println("Exception in ClassThree");
        }
}
}
