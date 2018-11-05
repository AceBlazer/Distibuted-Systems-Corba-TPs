package banque;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


public class StartServer {

	public static void main(String args[]) {
	    try{
	      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
	      ORB orb = ORB.init(args, null);      
	      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	      rootpoa.the_POAManager().activate();
	 
	      // create servant and register it with the ORB
	      CompteObj addobj = new CompteObj(1);
	      org.omg.CORBA.Object objRef = 
	      orb.resolve_initial_references("NameService");
	      NamingContextExt ncRefx = NamingContextExtHelper.narrow(objRef);


	      BankObj bankobj = new BankObj(rootpoa, ncRefx, "ATB");
	      addobj.setORB(orb); 
	      bankobj.setORB(orb); 
	 
	      // get object reference from the servant
	      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
	      org.omg.CORBA.Object ref1 = rootpoa.servant_to_reference(bankobj);
	      Compte href = CompteHelper.narrow(ref);
	      Bank href1 = BankHelper.narrow(ref1);
	 
	      org.omg.CORBA.Object objRefc =  orb.resolve_initial_references("NameService");
	      org.omg.CORBA.Object objRefb =  orb.resolve_initial_references("NameService");
	      NamingContextExt ncRefc = NamingContextExtHelper.narrow(objRefc);
	      NamingContextExt ncRefb = NamingContextExtHelper.narrow(objRefb);
	 
	      NameComponent pathc[] = ncRefc.to_name( "ABC" );
	      NameComponent pathb[] = ncRefc.to_name( "DEF" );
	      ncRefc.rebind(pathc, href);
	      ncRefb.rebind(pathb, href1);
	 
	      System.out.println("Banque Server ready and waiting ...");
	 
	      // wait for invocations from clients
	     // for (;;){
		  orb.run();
	     // }
	    } 
	 
	      catch (Exception e) {
	        System.err.println("ERROR: " + e);
	        e.printStackTrace(System.out);
	      }
	 
	      System.out.println("CalcServer Exiting ...");
	 
	  }

	
}
