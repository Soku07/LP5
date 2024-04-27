import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import java.util.*;

public class MainCLock {
    public static void main(String[] args) {
        try {
            var times = new ArrayList<LocalTime>();
            LocalTime localTime = LocalTime.parse("07:00:00", AppConstants.formatter);
            times.add(localTime);
            System.out.println("Local Time " + AppConstants.formatter.format(localTime));

            Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1, AppConstants.SERVER_PORT_1);
            ServerIntf s1 = (ServerIntf) registry1.lookup(ServerImpl.class.getSimpleName());
            System.out.println("Connection to server 1 established!");
            LocalTime Server_Time_1 = s1.getTime();
            times.add(Server_Time_1);
            System.out.println("Server 1 Time : "+ AppConstants.formatter.format(Server_Time_1));

            Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2, AppConstants.SERVER_PORT_2);
            ServerIntf s2 = (ServerIntf) registry2.lookup(ServerImpl.class.getSimpleName());
            System.out.println("Connection to server 2 established!");
            LocalTime Server_Time_2 = s2.getTime();
            times.add(Server_Time_2);
            System.out.println("Server 2 Time : "+ AppConstants.formatter.format(Server_Time_2));

            Registry registry3 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_3, AppConstants.SERVER_PORT_3);
            ServerIntf s3 = (ServerIntf) registry3.lookup(ServerImpl.class.getSimpleName());
            System.out.println("Connection to server 1 established!");
            LocalTime Server_Time_3 = s3.getTime();
            times.add(Server_Time_3);
            System.out.println("Server 3 Time : "+ AppConstants.formatter.format(Server_Time_3));


            var nanoLocal = localTime.toNanoOfDay();
            var diffserver1 = Server_Time_1.toNanoOfDay() - nanoLocal;
            var diffserver2 = Server_Time_2.toNanoOfDay() - nanoLocal;
            var diffserver3 = Server_Time_3.toNanoOfDay() - nanoLocal;
            var avgTimeDiff = (nanoLocal + diffserver1 + diffserver2 + diffserver3)/4;
            s1.adjustTime(localTime, avgTimeDiff);
            s2.adjustTime(localTime, avgTimeDiff);
            s3.adjustTime(localTime,avgTimeDiff );
            System.out.println("Updated Clocks");
            System.out.println("Local Time: " + AppConstants.formatter.format(localTime));
			System.out.println("Server 1 Time: " + AppConstants.formatter.format(s1.getTime()));
			System.out.println("Server 2 Time: " + AppConstants.formatter.format(s2.getTime()));
			System.out.println("Server 3 Time: " + AppConstants.formatter.format(s3.getTime()));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception !!");
        }
    }
}
