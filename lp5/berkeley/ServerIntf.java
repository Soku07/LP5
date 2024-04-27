import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime ;

/**
 * ServerImpl
 */
public interface ServerIntf extends Remote {

    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime clientTime, long timeDifference) throws RemoteException;
}
