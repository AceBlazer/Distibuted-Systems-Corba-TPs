package horloge;

import horloge.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Timer;

public class HorlogeObj extends HorlogePOA {
	private ORB orb;
	 public void setORB(ORB orb_val) {
		    orb = orb_val; 
		  }
	 public String get_time(){
		 DateFormat dateformat=new SimpleDateFormat("yyy/mm/dd hh:mm:ss");
		 Date date=new Date();
	     return(dateformat.format(date)) ;
	 }
	 public String get_time_string(){
		 return "";
	 }
	@Override
	public void get_time_int(ShortHolder heure, ShortHolder min) {
		// TODO Auto-generated method stub
		
	}

}
