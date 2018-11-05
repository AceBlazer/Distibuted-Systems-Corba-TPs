package calc;

import org.omg.CORBA.ORB;

import calc.CalculatricePOA;;

public class CalculatriceObj extends CalculatricePOA {
	private ORB orb;
	public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
	@Override
	public float ajout(float x, float y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public float soustrait(float x, float y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public float mult(float x, float y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public float divis(float x, float y) throws DivisionParZero {
		// TODO Auto-generated method stub
		return x/y;
	}

}
