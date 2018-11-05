package tp2;
import java.rmi.Naming;
public class Client {
public static void main(String[] args) {
try {
Nombre stub=(Nombre)Naming.lookup("rmi://localhost:81/bonjour");
System.out.println(stub.guess(5));
} catch (Exception e) {
e.printStackTrace();
}
}}