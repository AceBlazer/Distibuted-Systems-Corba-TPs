package tp2;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Nombre extends java.rmi.Remote {
String guess(int input) throws
java.rmi.RemoteException;
}