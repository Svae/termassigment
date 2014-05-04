package termassigment.taxicentral;

import java.util.ArrayList;

import termassigment.taxi.Taxi;
import termassigment.taxidispatcher.component.Order;
import termassigment.taxidispatcher.component.Status;
import termassigment.user.User;
import no.ntnu.item.arctis.runtime.Block;
import termassigment.taxicentral.Taxis;

public class TaxiCentral extends Block {

	public java.lang.String topic = "order,taxiUpdate,orderResponse";
	public java.lang.String message;
	public java.lang.String messageTopic;
	public termassigment.taxidispatcher.component.Order order;
	public ArrayList<Taxis> taxis;

	
	
	public void print(java.lang.String str) {
		System.err.println(str);
	}
	
	public String pront(String str){
		System.out.println(str);
		return str;
	}
	public String getTopic(Order order){ return order.getUser();}
	
	public ArrayList<Taxis> dummyTaxis(){
		taxis = new ArrayList<Taxis>();
		for (int i = 1; i <4; i++) {
			taxis.add(new Taxis("taxis"+1,"AVAILABLE","Tiller, Trondheim, Norway"));
		}
		return taxis;
	}
	


	
}
