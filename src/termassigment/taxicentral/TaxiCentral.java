package termassigment.taxicentral;

import java.util.ArrayList;

import termassigment.taxi.Taxi;
import termassigment.taxidispatcher.component.Order;
import termassigment.taxidispatcher.component.Status;
import termassigment.user.User;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiCentral extends Block {
	

	public ArrayList<Order> orders;
	public ArrayList<Taxi> taxies;
	
	public void init(){
		orders = new ArrayList<Order>();
	}
	
	
	public void checkOrder(Order newOrder){
		if(!orders.contains(newOrder)){
			orders.add(newOrder);
		}
	}
	
	public void changeStatus(Status newStatus, Order order){
		if(order.getStatus() != newStatus){
			order.setStatus(newStatus);
		}
	}
}
