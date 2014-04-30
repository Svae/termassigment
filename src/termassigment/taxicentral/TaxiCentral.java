package termassigment.taxicentral;

import java.util.ArrayList;

import termassigment.taxi.Taxi;
import termassigment.taxidispatcher.component.Order;
import termassigment.taxidispatcher.component.Status;
import termassigment.user.User;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiCentral extends Block {
	

	public ArrayList<Order> orders = new ArrayList<Order>();
	public ArrayList<Taxi> taxies;
	public int orderID;
	public java.lang.String topic = "taxi, order";
	
	
	public void printOrder(Order order){
		System.out.println(" OrderID: "+ order.getOrderID() + "\n User: "+order.getUser()+"\n Status: "+ order.getStatus() + "\n Message: "+ order.getMessage());
	}
	
	public void print(String str){
		System.out.println(str);
	}
	

	
	public Order checkOrder(Order order){
		if(order.getOrderID() == 0){
			order.setOrderID(orderID);
			orders.add(order);
			order.setMessage("Ordre rec");
		}else{
			cancelOrder(order.getOrderID());
		}
		return order;
	}
	
	private void cancelOrder(int id){
		for (Order order:orders){
			if(order.getOrderID() == id){
				order.setStaus("CANCELD");
				order.setMessage("Order can");
			}
		}
	}
	
	public void increaseID(){
		orderID ++;
	}
	
	public String getTopic(Order order){
		return order.getUser();
	}
}
