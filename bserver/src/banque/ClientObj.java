package banque;
import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;

import banque.*;

public class ClientObj extends ComptePOA {
	
	public double solde;

	private ORB orb;
	public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
	
	@Override
	public boolean deposer(double montant) {
		 final double plafond = 999.999;
	        if (solde + montant < plafond) {
	            solde += montant;
	            return true;
	        } else {
	            return false;
	        }
	}

	@Override
	public boolean retirer(double montant) {
		 if (solde - montant > 0) {
	            solde -= montant;
	            return true;
	        } else {
	            return false;
	        }
	}

	@Override
	public double afficher() {
		// TODO Auto-generated method stub
		return solde;
	}

}
