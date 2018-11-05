package banque;

import java.util.Scanner;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;


public class StartClient {
	public static void main(String[] args) {
		
	
		try {
		    ORB orb = ORB.init(args, null);
		    org.omg.CORBA.Object objRefc =   orb.resolve_initial_references("NameService");
		    org.omg.CORBA.Object objRefb =   orb.resolve_initial_references("NameService");
		    NamingContextExt ncRefc = NamingContextExtHelper.narrow(objRefc);
		    NamingContextExt ncRefb = NamingContextExtHelper.narrow(objRefb);
		    Compte hobj = (Compte)  CompteHelper.narrow(ncRefc.resolve_str("ABC"));
		    Bank hobj1 = (Bank)  BankHelper.narrow(ncRefb.resolve_str("DEF"));
	 
		
	            Scanner c=new Scanner(System.in);
	            System.out.println("Bienvenue dans notre banque");
	            System.out.println("Pour consulter votre solde, veuillez taper 1 ");
	            System.out.println("Pour deposer, veuillez taper 2 ");
	            System.out.println("Pour retirer, veuillez taper 3 ");
	            System.out.println("Pour connaitre l'ID, veuillez taper 4 ");
	            System.out.println("Pour creer, veuillez taper 5 ");
	            System.out.println("Pour deplacer, veuillez taper 6 ");
	            System.out.println("Pour chercher, veuillez taper 7 ");
	            System.out.println("Pour supprimer, veuillez taper 8 ");
	            System.out.println("Pour Quitter, veuillez taper 9 "); 
	           
	            while(true) {
	            	
	            
	            String aa = c.nextLine();
	            int choix=Integer.parseInt(aa);
	        
	            
	           
	            
	            switch (choix) {
	            case 1: System.out.println(hobj.Labalance());
	            break;
	            
	            case 2: {
	            	System.out.println("Veuillez entrer le montant à déposer ");
	            	String bb = c.nextLine();
		            float mont=Float.parseFloat(bb);
		            hobj.deposer(mont);
                    System.out.println("montant ajouté avec succès ");   
	            }
	            break;
	            
	            case 3: {
	            	 System.out.println("Veuillez entrer le montant à retirer ");
	            	 String cc = c.nextLine();
			            float mont2=Float.parseFloat(cc);
			            hobj.retirer(mont2);
                        System.out.println("soustraction réussite ");         
	            }
	            break; 
	            
	            case 4:{
	            	 System.out.println(hobj.getNumcompte());  	
	            }
	            break;
	            
	            case 5:{//creer
	            	 System.out.println("Veuillez entrer l'ID du compte à créer  ");
	            	 String ee = c.nextLine();
	            	 int idd=Integer.parseInt(ee);
	            	 Compte cpt1=hobj1.creer(idd);
	            }
	            break;
	            
	            case 6:{//deplacer
	            	 System.out.println("Veuillez entrer l'ID du compte à déplacer ");
	            	 String ff = c.nextLine();
	            	 int idd=Integer.parseInt(ff);
	            	 Compte cpt=hobj1.chercher(idd);
	            	 Bank b=null; //il faudra etre bankObj pas Bank dans les params de deplacer (on ne peut pas instantier Bank)
	            	 hobj1.deplacer(b, cpt);
	            }
	            break;
	            
	            case 7:{//charcher
	            	 System.out.println("Veuillez entrer l'ID du compte à chercher  ");
	            	 String dd = c.nextLine();
			         int id=Integer.parseInt(dd);
	            	 Compte cpt=hobj1.chercher(id);
	            	 if(cpt!=null)
	            		 System.out.println("trouvé ");
	            	 else 
	            		 System.out.println("non trouvé ");
	            }
	            break;
	            
	            case 8:{//supp
	            /*	System.out.println("Veuillez entrer l'ID du compte à supprimer  ");
	            	 String gg = c.nextLine();
			         int id=Integer.parseInt(gg);
			         Compte cpt=hobj1.chercher(id);
	            	 hobj1.supprimer(cpt);*/
	            	hobj1.supprimer(hobj);
	            }
	            break;         
            
	            case 9: {
	            	System.out.println(" A la prochaine :p ");
	            }
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
