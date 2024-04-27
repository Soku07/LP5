import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.rmi.*;
public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
    private LocalTime localTime;

    ServerImpl(LocalTime localTime) throws RemoteException{
        this.localTime = localTime;
    }

    public LocalTime getTime() throws RemoteException{
        return this.localTime;
    }
    
    public void adjustTime(LocalTime serverTime, long diff) throws RemoteException{
        long serverseconds = serverTime.toSecondOfDay();
        long adjustseconds = serverseconds + diff;
        LocalTime adjustedTime =LocalTime.ofSecondOfDay(adjustseconds);
        System.out.println("Adjusted Time is " + adjustedTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
