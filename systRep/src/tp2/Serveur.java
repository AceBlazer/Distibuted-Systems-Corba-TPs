package tp2;
import java.rmi.Naming;
public class Serveur {
public static void main(String[] args) {
try {
// Cr�er l�objet distant
NombreImp hello=new NombreImp();
// Publier sa r�f�rence dans l�annuaire
Naming.rebind("rmi://localhost:81/bonjour",hello);
} catch (Exception e) {
e.printStackTrace();
}
}
}