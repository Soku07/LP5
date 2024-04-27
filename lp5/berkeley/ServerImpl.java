import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.time.LocalTime;
public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
    private LocalTime currTime;

    public ServerImpl(LocalTime currTime) throws RemoteException{
        this.currTime = currTime;
    }

    @Override
    public LocalTime getTime() throws RemoteException{
        return currTime;
    }
    @Override
    public void adjustTime(LocalTime clienTime, long timeDifference) throws RemoteException{
        long localTime = clienTime.toNanoOfDay();
        long serverTime = this.getTime().toNanoOfDay();
        var newNanos = serverTime - currTime.toNanoOfDay();
        newNanos = newNanos*-1 + timeDifference + serverTime;
        LocalTime newLocalTime = LocalTime.ofNanoOfDay(newNanos);
        System.out.println("Updated Time " + AppConstants.formatter.format(newLocalTime));
        this.currTime = newLocalTime;

    }
}
