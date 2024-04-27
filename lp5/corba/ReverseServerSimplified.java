import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
public class ReverseServerSimplified {
    public static void main(String[] args) {
        try {   

            ORB orb = ORB.init(args, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            ReverseImpl reverseObj = new ReverseImpl();
            org.omg.CORBA.Object corbaObj = rootPoa.servant_to_reference(reverseObj);

            Reverse h_ref = ReverseModule.ReverseHelper.narrow(corbaObj);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt nameBinding = NamingContextExtHelper.narrow(objRef);

            String name = "Reverse";
			NameComponent path[] = nameBinding.to_name(name); 
			nameBinding.rebind(path, h_ref);

            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception occured in ReverseServer.java " + e);
        }
    }
}