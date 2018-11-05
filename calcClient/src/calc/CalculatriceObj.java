package calc;

import calc.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class CalculatriceObj extends CalculatricePOA {
	private float res;
	private ORB orb;
	private float mem;
	
	 public void setORB(ORB orb_val) {
		    orb = orb_val; 
		  }
	@Override
	public float ajouter(float a1, float a2) {
		// TODO Auto-generated method stub
		res=a1+a2;
		return res;
	}
	@Override
	public float soustraire(float a1, float a2) {
		// TODO Auto-generated method stub
		res=a1-a2;
		return res;
	}
	@Override
	public float multiplier(float a1, float a2) {
		// TODO Auto-generated method stub
		res=a1*a2;
		return res;
	}
	@Override
	public void memoriser_dernier_resultat() {
		// TODO Auto-generated method stub
		mem=
		
	}
	@Override
	public float extraire_memoire(FloatHolder registre) {
		// TODO Auto-generated method stub
		registre.
		return ;
	}
	

}
