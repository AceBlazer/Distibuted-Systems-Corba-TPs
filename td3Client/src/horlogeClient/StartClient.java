package horlogeClient;


import horlogeClient.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;

public class StartClient {

	public static void main(String[] args) {
	try {
	    ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    Horloge hobj = (Horloge) HorlogeHelper.narrow(ncRef.resolve_str("ABC"));
 
            Scanner c=new Scanner(System.in);
            System.out.println("*** Welcome to the Timing system ***");          		    
		    
		      System.out.println("Time is :");
		    
		      String r=hobj.get_time();
		      System.out.println(r);
		      System.out.println(" see you next TIME ");
            
       }
       catch (Exception e) {
          System.out.println("Hello Client exception: " + e);
	  e.printStackTrace();
       }
 
    }
	
}
