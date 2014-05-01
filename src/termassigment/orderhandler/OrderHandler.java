package termassigment.orderhandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class OrderHandler extends Block {
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	public ArrayList<Order> orderQue = new ArrayList<Order>();
	public ArrayList<String> available;
	public ArrayList<Taxis> taxis;
	public int orderID = 1;
	public java.lang.String topic = "order";
	public java.lang.String message;
	public java.lang.String messageTopic;
	public termassigment.taxidispatcher.component.Order order;
	
	
	public void printOrder(Order order){
		System.out.println(" OrderID: "+ order.getOrderID() + "\n User: "+order.getUser()+"\n Status: "+ order.getStatus() + "\n Message: "+ order.getMessage());
	}
	
	public void print(String str){
		System.out.println(str);
	}

	public Order checkOrder(Order userOrder){
		if(userOrder.getStatus() == "NEW") newOrder(userOrder);
		else if(userOrder.getStatus() == "CHANGE")changeOrder(userOrder);
		else if(userOrder.getStatus() == "CANCEL")cancelOrder(userOrder);
		return userOrder;
	}
	
	public Order newOrder(Order order){
		order.setOrderID(orderID);
		orderID = orderID + 1;
		orders.add(order);
		order.setStaus("WAITING");
		orderQue.add(order);
		order.setMessage("Your order has been recieved");
		return order;	
	}
	
	public Arraylist<String> allocateTaxi(Order order){
		taxis = new ArrayList<Taxis>();
		for(Taxis taxi:taxis){
			if(taxi.getStatus() == "AVAILABLE"){
				taxis.add(taxi.getAlias()+";"+taxi.getPosistion()+";"+ order.getDestination);
			}
		}
		return taxis;
		
	}
	
	
	public void changeOrder(Order order){
		System.out.println("changeorder");
		
	}
	
	public void cancelOrder(Order order){
		findOrder(order.getOrderID());
	}
	
	
	
	if(userOrder.getStatus().equals("NEW")){
		orderID++;
		orders.add(order);
		order.setStaus("WAITING");
		order.setMessage("Order is  recieved");
	}
	if (order.getStatus().equalsIgnoreCase("CANCEL")){
		System.out.println("CANCEL ORDER");
		order.setStaus("CANCELLED");
		order.setMessage("Order is cancelled");
	}
	if(order.getStatus().equalsIgnoreCase("CHANGE")){
		changeOrder();
	}
	messageTopic = order.getUser();
	printOrder(order);
	System.out.println("-----------------------------------------------------\n" + orders.toString());
	return order;
	


}
