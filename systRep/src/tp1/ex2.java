/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author namaste
 */
public class ex2 {
    
    
    public static void main(String args[]) throws IOException {
 
  int nbSecret = (int)(Math.random()*100);//choix du nbre random
        
        
  int portNumber = 81; //port de l ecoute
		
  ServerSocket serversocket1 = new ServerSocket(portNumber);//socket du serveur
                
System.out.println("Creation du socket serveur au port" + portNumber+"c est le socket d ecoute ou le serveur peut determiner s il y a un client qui a esoin du service fourni par le serveur"); 
Socket socket;
int nb=0;
while (nb<10) {// tjrs est il, il faut ecouter s il y a un processus en ligne
			
nb++;
System.out.println("processus nb"+nb);                     
 socket = serversocket1.accept();//le serveur a detecte une activite client c a d un client veut se connecter et le serveur accepte d allouer un socket pr ce client
System.out.println("Allouer un socket client pr l echange de client. faites attention le socket d ecoute est tjrs actif et ce nouveau socket aui a ete cree est lie a la communication du serveur avec le client en cours.. Dc s il y a un autre client qui veut se connecter on n a qu a cree theoriquement un nouveau socket pr le nouveau client");
 OutputStream os = socket.getOutputStream();//
System.out.println("on ouvre un flow d ecriture"); 
PrintWriter pw = new PrintWriter(os, true);
pw.println("commencer a deviner");
                          
InputStream is=socket.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);            
    
int nbfois=0;
boolean correct=false;
while ((nbfois<5 ) &&(!correct))
  {
      nbfois++; 
      String devinette=br.readLine();
 
  //String rep="Votre reponse etait"+devinette;
 
  int a = 0;
 
  a=Integer.parseInt(devinette);
  
  
      if (a<nbSecret)
     System.out.println("Inferior");
     else if (a>nbSecret)
     System.out.println("Superior");
      else 
      { 
       System.out.println("Niiice");
        correct=true;
        System.out.println("Process"+socket.getRemoteSocketAddress()+"you succeded");
        is.close();
  isr.close();
  br.close();
  os.close();
  pw.close();
  socket.close();
                           }
      
    }

  is.close();
  isr.close();
  br.close();
  os.close();
  pw.close();
  socket.close();
                        
  }

                
                serversocket1.close();

                
 }



}   
    

