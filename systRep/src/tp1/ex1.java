/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import static tp1.serveur.nbSecret;


public class ex1 {
    
    
    public static void main(String args[]) throws IOException {
 
        int nbSecret = (int)(Math.random()*100);//choix du nbre random
        
        
		int portNumber = 81; //port de l ecoute
		
                ServerSocket serversocket1 = new ServerSocket(portNumber);//socket du serveur
                
System.out.println("Creation du socket d ecoute au port" + portNumber+"c est le socket d ecoute ou le serveur peut determiner s il y a un client qui a esoin du service fourni par le serveur"); 

		while (true) {// tjrs est il, il faut ecouter s il y a un processus en ligne
			Socket socket = serversocket1.accept();//le serveur a detecte une activite client c a d un client veut se connecter et le serveur accepte d allouer un socket pr ce client
System.out.println("Allouer un socket client pr l echange de client. faites attention le socket d ecoute est tjrs actif et ce nouveau socket qui a ete cree est lie a la communication du serveur avec le client en cours.. Dc s il y a un autre client qui veut se connecter on n a qu a cree theoriquement un nouveau socket pr le nouveau client");
                        OutputStream os = socket.getOutputStream();//
System.out.println("on ouvre un flow d ecriture"); 
                        PrintWriter pw = new PrintWriter(os, true);
			pw.println("Donner votre guess?");

                        
               
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();

			pw.println("Hello"+socket.getInetAddress()+"your guess is " + str);
                        int trans=Integer.parseInt(str);
                        if (trans<nbSecret)
                            System.out.println("Inferior");
                        else if (trans>nbSecret)
                            System.out.println("Superior");
                        else System.out.println("Niiice");
			pw.close();
			socket.close();

			System.out.println("Bye") ;
                        br.close();
		}
	}
}
    
    

