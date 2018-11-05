package tp2;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class NombreImp extends UnicastRemoteObject implements Nombre {
private String name;
public NombreImp() throws RemoteException {
super(); }
// Implémentation de la méthode distante
public String guess(int input) throws RemoteException {
	int nb=(int)(Math.random()*100);
	if(nb==input) {
return " correct! " ; }
	else {
		if(nb<input) {
			return " guess < nombre " ;
		}
		else {
			return " guess > nombre " ;
		}
	}
}
}