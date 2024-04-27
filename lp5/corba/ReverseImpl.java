import ReverseModule.ReversePOA;
import java.lang.String;

public class ReverseImpl extends ReversePOA{
    public ReverseImpl(){
        super();
        System.out.println("Reverse Impl class object created");
    }

    public String reverse_string(String str){
        StringBuffer buff = new StringBuffer(str);
        buff.reverse();
        return ("Server replies -> " + buff);
    }
}