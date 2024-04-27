import java.rmi.*;

public interface ServerIntf extends Remote{

    double mul(double d1, double d2) throws RemoteException;
}