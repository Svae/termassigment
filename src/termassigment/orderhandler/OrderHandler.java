package termassigment.orderhandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class OrderHandler extends Block {
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	public ArrayList<Order> orderQue = new ArrayList<Order>();
	public ArrayList<String> available;
	public int orderID = 1;
	public java.lang.String topic = "order";
	public java.lang.String message;
	public java.lang.String messageTopic;
	public java.util.ArrayList<termassigment.taxicentral.Taxis> taxis;
	public termassigment.taxidispatcher.component.Order processedOrder;
	public termassigment.taxidispatcher.component.Order order;
	public void printOrder(Order order){
		System.out.println(" OrderID: "+ order.getOrderID() + "\n User: "+order.getUser()+"\n Status: "+ order.getStatus() + "\n Message: "+ order.getMessage());
	}
	

	//--------- ORDER ---------
	public String checkOrder(Order userOrder){
		return userOrder.getStatus();
	}
	
	
	
	public Order newOrder(Order order){
		order.setOrderID(orderID);
		orderID = orderID + 1;
		orders.add(order);
		orderQue.add(order);
		order.setStaus("WAITING");
		order.setMessage("Your order has been recieved");
		return order;	
	}
	
	
	
	// --------- ORDER --------- NEWORDER ---------
	public ArrayList<String> availbleTaxi(Order order){
		available = new ArrayList<String>();
		for(Taxis taxi:taxis){
			if(taxi.getStatus() == "AVAILABLE"){
				available.add(taxi.getAlias()+";"+taxi.getPosistion()+";"+ order.getDestination());
			}
		}
		return available;
	}
	
	
	public Order cancelOrder(Order order){
		if(orderQue.contains(order)){
			orderQue.remove(order);
		}
		
		order.setMessage("The order has been cancelled");
		order.setStaus("CANCELLED");
		System.out.println("Order: "+ order.toString());
		System.out.println(orders);
		return order;
		
		
	}
	
	public void changeOrder(Order order){
		
		
	}

	
	public ArrayList<String> proccessOrder(Order order){
		available = new ArrayList<String>();
		for(Taxis taxi:taxis){
			if(taxi.getStatus() == "AVAIABLE"){
				available.add(taxi.getAlias()+";"+ taxi.getPosistion()+";"+order.getDestination());
			}
		}
		return available;
	}
	
	public Order nextOrder(){
		if (orderQue.size()>0){
			return orderQue.get(0);
		}
		return null;
		
	}
		
	public String sendOrder(Order order, String alias){
		order.setStaus("SENT");
		order.setTaxi(alias);
		return order.getDestination()+";"+order.getOrderID()+";"+order.getUser();
	}
	

	
	public void confirmOrder(String orderStr){
		String[] str = orderStr.split(";");
		int orderID = Integer.parseInt(str[1]);
		if(str[2].equalsIgnoreCase("OK")){
			for(Order order:orders){
				if(order.getOrderID() == orderID){
					order.setStaus("CONFIRMED");
					order.setMessage("A taxi is on it's way");
					orderQue.remove(order);
				}
			}
		}
	}
	
	public String dummy(ArrayList<String> list){
		return "taxi1";
	}


}
