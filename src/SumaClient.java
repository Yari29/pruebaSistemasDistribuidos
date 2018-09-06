import java.util.Scanner;
import SumaApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class SumaClient{
    static suma SumaImpl;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
    
        try {
            ORB orb =ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Suma";
            SumaImpl = sumaHelper.narrow(ncRef.resolve_str(name));
            
            System.out.println("Ingrese el número 1: ");
            int a = sc.nextInt();
            System.out.println("Ingrese el número 2: ");
            int b = sc.nextInt();
            System.out.println("suma es:" + Integer.toString(SumaImpl.sumar(a, b)));
            SumaImpl.shutdown();
        } catch (Exception e) {
            System.out.println("Error. " + e);
            e.printStackTrace(System.out);
        }
    }
}
