package banque;

import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import banque.*;

public class StartClient {
	public static void main(String[] args) {
	
		try {
		
		    ORB orb = ORB.init(args, null);
		    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
		    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		    Compte hobj = (Compte)  CompteHelper.narrow(ncRef.resolve_str("ABC"));
	 
		
	            Scanner c=new Scanner(System.in);
	            System.out.println("Bienvenue dans notre banque");
	            System.out.println("Pour consulter votre solde, veuillez taper 1 ");
	            System.out.println("Pour deposer, veuillez taper 2 ");
	            System.out.println("Pour retirer, veuillez taper 3 ");
	            System.out.println("Pour Quitter, veuillez taper 4 "); 
	           
	            while(true) {
	            	
	            
	            String aa = c.nextLine();
	            int choix=Integer.parseInt(aa);
	        
	            
	           
	            
	            switch (choix) {
	            case 1: System.out.println(hobj.afficher());
	            break;
	            case 2: {
	            	System.out.println("Veuillez entrer le montant à déposer ");
	            	String bb = c.nextLine();
		            double mont=Integer.parseInt(bb);
		            if(hobj.deposer(mont)) {
                        System.out.println("montant ajouté avec succès ");
                    }
                    else {
                        System.out.println("Plafond reached! ");
                    }
	            }
	            break;
	            case 3: {
	            	 System.out.println("Veuillez entrer le montant à retirer ");
	            	 String cc = c.nextLine();
			            double mont2=Integer.parseInt(cc);
			            if (hobj.retirer(mont2)) {
                            System.out.println("soustraction réussite ");
                        } else {
                            System.out.println("Nous sommes désolés, vote solde est insuffisant ");
                        }
	            }
	            break;
	            case 4: System.out.println(" A la prochaine :p ");
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
