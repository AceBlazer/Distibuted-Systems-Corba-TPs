package banque;


import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.HashMap;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class BankObj extends BankPOA{ 
    
    
private POA _poa;
private int _compcompte; //pr donner un nouveau ID au nouveau compte cree

    private NamingContextExt _ncRef;

    private HashMap<String,Compte> _comptes;//ensemble des comptes
    
    public String nom;
    private ORB orb;
	public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
    public BankObj(POA rootPoa, NamingContextExt ncRef, String nomm) {
	super();
	nom = nomm;//un nouveau nom pr la banque
	_comptes = new HashMap<String, Compte >();//nouvelle liste
	_compcompte = 0;//compteur a zero
	_poa = rootPoa;//path 
	_ncRef = ncRef;//ref de l objet cree
    }
    
    public Compte chercher(int val) {
	System.out.println("Recherche du compte val=" + val + " dans la banque " + nom);
	return _comptes.get("" + val);
    }

    public void supprimer (Compte k){
		
	System.out.println("Suppression " + k. getNumcompte()+ " aupres de la banque " +nom);
	_comptes.remove(k);
    }

	@Override
    public Compte creer (int id) {
	Compte res = null;
	CompteObj k = new CompteObj(++_compcompte);
    	id = k.getNumcompte();
	
	try
	    {
		org.omg.CORBA.Object objRef = _poa.servant_to_reference(k); 
		_ncRef.rebind(_ncRef.to_name ("bank." + nom + k.getNumcompte() ), objRef);
		System.out.println(" binded "); 
		res = CompteHelper.narrow(objRef);
		System.out.println(" extracted "); 
		_comptes.put(("" + res.getNumcompte()),res);		
		System.out.println("creation accomplie " + res.getNumcompte());
	    }
	catch(Exception in) {
	    System.out.println("nom invalide "); 
	}
	
	return res;
    }		
    
    
    public Compte deplacer (Bank vers, Compte k){
	System.out.println("compte cree " + k.getNumcompte()  + " dans la banque " + nom );
	float montant = k.Labalance();
	int nouvid=2;
	Compte nouvCompte = vers.creer(nouvid);
	nouvCompte.deposer(montant);
	this.supprimer(k);
	return nouvCompte;
    }


	
}
