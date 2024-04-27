import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
public class ClockOne{
    public static void main(String[] args) {
        try{
            ServerIntf s1 = new ServerImpl(LocalTime.parse("07:05:00", AppConstants.formatter));
            Registry r1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
            r1.rebind(ServerImpl.class.getSimpleName(), s1);
            System.out.println("Server started on port " + AppConstants.SERVER_PORT_1);
        }catch(Exception e){
            System.out.println("Exception in ClassOne");
        }
    }
}
