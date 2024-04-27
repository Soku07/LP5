import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class ClockTwo {
       public static void main(String[] args) {
        try{
            ServerIntf s2 = new ServerImpl(LocalTime.parse("07:05:00", AppConstants.formatter));
            Registry r2 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_2);
            r2.rebind(ServerImpl.class.getSimpleName(), s2);
            System.out.println("Server started on port " + AppConstants.SERVER_PORT_2);
        }catch(Exception e){
            System.out.println("Exception in ClassTwo");
        } 
}
}