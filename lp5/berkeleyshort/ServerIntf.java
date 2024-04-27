import java.rmi.*;
import java.time.*;
public interface ServerIntf extends Remote {

    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime ServerTime, long diff) throws RemoteException;
}