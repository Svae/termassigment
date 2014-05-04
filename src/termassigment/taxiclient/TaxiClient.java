package termassigment.taxiclient;

import com.sun.media.sound.AlawCodec;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;

public class TaxiClient extends Block {

	public java.lang.String alias_taxi;
	public java.lang.String order;
	public java.lang.String topic;
	public java.lang.String response = "orderResponse";
	public java.lang.String update = "taxiUpdate";
	public java.lang.String status = "AVAILABLE";
	public java.lang.String position = "Trondheim S, Trondheim";
	public java.lang.String message, destination, orderID, user;

	public static String getAlias(String alias){
		return alias;
	}
	
	public String onDuty(){
		System.out.println("ALASA---------------:" + alias_taxi);
		return alias_taxi+";ON DUTY ;" + position;
	}
	
	public String offDuty(){
		return alias_taxi+";OFF DUTY;" + position;
	}
	
	public String available(){
		return alias_taxi+";AVAILABLE;" + position;
	}
	
	public String unavailable(){
		return alias_taxi+";UNAVAILABLE;" + position;
	}
	
	public String confirm(){
		if(orderID != null)
		return orderID + ";" +  alias_taxi + ";CONFIRM";
		return null;
	}
	
	public String decline(){
		if(orderID != null)
		return orderID + ";" +  alias_taxi + ";DECLINE";
		return null;
	}
	
	public String connected(){
		return "You are connected";
	}
	
	
	//order.getDestination()+";"+order.getOrderID()+";"+order.getUser();
	public  String makeMessage(String msg){
		String[] str = msg.split(";");
		destination = str[0];
		orderID = str[1];
		user =str[2];
		return "New order - Address: " + destination + "	OrderID: " + orderID + "	Custommer: " + user;
				
				
	}
	
	public String getTopic(String topic){
		return topic.split(";")[1];
	}
	
	public String makeSubscription(){
		return alias_taxi+";order,"+alias_taxi+";message";
	}
	
	public Journey makeJourney(String str){
		return new Journey(alias_taxi,position, destination);
	}

	public String journeyEnd(String position) {
		this.position = position;
		return alias_taxi+";"+status+";" + position;
	}
}
