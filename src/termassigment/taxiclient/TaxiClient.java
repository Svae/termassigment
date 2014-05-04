package termassigment.taxiclient;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiClient extends Block {

	public static java.lang.String alias_taxi;
	public Order order;
	public String topic = "taxi";

	public static String getAlias(String alias){
		return alias_taxi;
	}
	
	public String onDuty(){
		return alias_taxi+": onduty";
	}
	
	public String offDuty(){
		return alias_taxi+": offduty";
	}
	
	public String available(){
		return alias_taxi+": availble";
	}
	
	public String unavailable(){
		return alias_taxi+": unavailble";
	}
	
	public String confirm(){
		return order.getOrderID() + alias_taxi + ": confirmed";
	}
}
