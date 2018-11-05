package banque;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class CompteObj extends ComptePOA{

    public int Id;
    private float _solde;
    
	private ORB orb;
	public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
  
    public CompteObj (int id){
	this.Id = id;
	_solde = 0;
    }
    
    public int getNumcompte() {
	return this.Id ;
    }
    
    public void deposer(float montant){
  	_solde += montant;
    }
   
    public void retirer (float montant){
  	_solde -= montant;
    }
    
    public float Labalance (){
  	return _solde;
    }


}
