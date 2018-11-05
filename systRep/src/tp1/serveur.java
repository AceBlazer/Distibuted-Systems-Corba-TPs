package tp1;



import java.net.*;
import java.io.*; 

public class serveur extends Thread{ //instance du processus thread pr pouvoir creer un gestionnaire personallise des processus clients
	
	private int nbClients=0; //le nbre de clients
	public static int nbSecret; //le code secret
	public static boolean fin; // statut du jeu ceci est une variable global publique
	public static String gagnant; //qui est le gagnant ceci est une variable global publique
	ServerSocket ss;
        public serveur() throws IOException
                { 
                nbSecret = (int)(Math.random()*100); //choix fait
			ss = new ServerSocket(81);//creation du socket d ecoute
                				System.out.println("Serveur en ligne");//annonce que le serveur est en phase d ecoute

                }
	@Override
	public void run(){ // la methode principal qui decrit ce que le serveur va faire after being started
		try {
			//nbSecret = (int)(Math.random()*100); //choix fait
			//ServerSocket ss = new ServerSocket(81);//creation du socket d ecoute
			while(true){ // lancer l ecoute sur les processus client
			
			
				Socket s = ss.accept();// le serveur cree un socket pr le processus client qui vient 
				++nbClients; // incrementation du nb de clients
				new service(s,nbClients).start();//tt dabord start est pr lancer le thread de l instance
                                //du processus client qui est cree la. il faut indiquer l identifiant du socker cree s 
                                
				exit();
 			} 
		}	catch (Exception e){ e.printStackTrace(); }
	
	}
	
        void exit() throws IOException
        {  ss.close();  }
	public static void main(String[] args) throws IOException{
            serveur tt=new serveur();
		tt.start(); //start le serveur va automatiquement lancer la methode start0 qui va lancer 
                //la methode run qu on a defini ds la classe serveur dc la premiere chose est l instruction
                //choix fait
               
	}
}
