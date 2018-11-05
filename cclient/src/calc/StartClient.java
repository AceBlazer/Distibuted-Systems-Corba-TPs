package calc;

import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import calc.Calculatrice;

public class StartClient {
	public static void main(String[] args) {
		float x;
		float y;
		try {
			int s;
		    ORB orb = ORB.init(args, null);
		    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
		    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		    Calculatrice hobj = (Calculatrice)  CalculatriceHelper.narrow(ncRef.resolve_str("ABC"));
	 
		    while (true){
	            Scanner c=new Scanner(System.in);
	            System.out.println("*** Welcome to the Calculator ***");   
	           
	            System.out.println("a :");
	            String aa = c.nextLine();
	            System.out.println("b :");
	            String bb = c.nextLine();
	            
	            x=Float.parseFloat(aa);
	            y=Float.parseFloat(bb);
	            
	            System.out.println("  1:add   2:subs   3: mult   4:divis ");
	            String cc = c.nextLine();
	            s=Integer.parseInt(cc);
	            
	            switch (s) {
	            case 1: System.out.println("Result is :"+hobj.ajout(x, y));
	            break;
	            case 2: System.out.println("Result is :"+hobj.soustrait(x, y));
	            break;
	            case 3: System.out.println("Result is :"+hobj.mult(x, y));
	            break;
	            case 4: System.out.println("Result is :"+hobj.divis(x, y));
	            break;
	            }
			    
		    }   
	            
	       }
	       catch (Exception e) {
	          System.out.println("Hello Client exception: " + e);
		  e.printStackTrace();
	       }
	 
	    }
		
}
