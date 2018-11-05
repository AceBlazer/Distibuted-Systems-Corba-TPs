package tp1;

import java.net.*;
import java.io.*; 

public class service extends Thread { 

		private Socket s;
		private int numClient; 
		public service(Socket socket, int numClient){
			super();
			this.s = socket;
			this.numClient = numClient; 
		}
		
		@Override
		public void run(){
		
		try{ 
			InputStream is=s.getInputStream(); //creation du socket duplex d echange entre le serveur et le client
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			OutputStream os=s.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true); 
			pw.println("Voues etes client numero"+numClient);
			System.out.println("Connexion du client Num "+ numClient);
			System.out.println("IP = "+s.getRemoteSocketAddress());
	
			while(true){
				String req=br.readLine(); //vs entrez le choix
					System.out.println(req); 
					int nb = Integer.parseInt(req);
					if(serveur.fin == false){ // tant que le processus n a pas trouve la reponse
						if(nb < serveur.nbSecret){
							pw.println("Votre nombre est inferieur au nombre secret"); 
						}
						else{ 
							if(nb > serveur.nbSecret){
							pw.println("Votre nombre est superieur au nombre secret"); 
							} 
							else {
								pw.println("Vous avez gagne");
                                                                serveur.gagnant = s.getRemoteSocketAddress().toString(); 

                                                               System.out.println("Le gagnant est " + serveur.gagnant);
								serveur.fin = true;
                                      pw.println("Le jeux est termine");                          
					s.close();
							
											
							}	
					
						}
					}
					else{
						pw.println("Le jeux est termine");
						s.close();
					}
						
					 
				
							}
			} catch (Exception e){ 	e.printStackTrace(); }
		
		}
		
}


