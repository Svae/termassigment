package termassigment.taxicentral;

import java.util.ArrayList;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;
import termassigment.taxicentral.Taxis;

public class TaxiCentral extends Block {

	public java.lang.String topic = "order,taxiUpdate,orderResponse";
	public java.lang.String message;
	public java.lang.String messageTopic;
	public termassigment.taxidispatcher.component.Order order;
	public ArrayList<Taxis> taxis;

	
	public String getTopic(Order order){return order.getUser();}

	
}
