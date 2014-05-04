package termassigment.orderhandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class OrderHandler extends Block {
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	public ArrayList<Order> orderQue = new ArrayList<Order>();
	public int orderID = 1;
	public java.lang.String topic = "order";
	public java.lang.String message;
	public java.lang.String messageTopic;
	public java.util.ArrayList<termassigment.taxicentral.Taxis> taxis = new ArrayList<Taxis>();
	public termassigment.taxidispatcher.component.Order processedOrder;
	public termassigment.taxidispatcher.component.Order order;
	public ArrayList<String> available;


	//--------- ORDER ---------
	public String checkOrder(Order userOrder){
		return userOrder.getStatus();
	}
	
	
	
	public Order newOrder(Order order){
		order.setOrderID(orderID);
		order.setStaus("WAITING");
		order.setMessage("Your order has been recieved");
		orderID ++;
		orders.add(order);
		orderQue.add(order);
		return order;	
	}
	
	
	
	// --------- ORDER --------- NEWORDER ---------

	public Order cancelOrder(Order order){
		for(Order ord:orderQue){
			if(ord.getOrderID() == order.getOrderID()){
				orderQue.remove(ord);
				updateOrderlist(order.getOrderID(), "CANCELLED");
			}
		};			
		order.setMessage("The order has been cancelled");
		order.setStaus("CANCELLED");
		return order;
		
		
	}
	

	
	public ArrayList<String> proccessOrder(Order order){
		System.out.println("-----------------------------------");
		System.out.println("ORDERLIST: "+orders.toString());
		System.out.println("-----------------------------------");

		if (order != null){
			available = new ArrayList<String>();
			for(Taxis taxi:taxis){
				available.add(taxi.getAlias()+";"+taxi.getPosistion()+";"+ order.getDestination());
			}
			System.out.println("Available: " + available);
			return available;
		}
		return null;
	}
	
	public Order nextOrder(){
		if (orderQue.size()>0){
			return orderQue.get(0);
		}
		return null;
		
	}
		
	public String sendOrder(Order order, String alias){
		order.setTaxi(alias);
		order.setStaus("SENT");
		updateOrderlist(order.getOrderID(), "SENT");
		updateOrderQuelist(order.getOrderID(), "SENT");
		return order.getDestination()+";"+order.getOrderID()+";"+order.getUser();
	}
	

	public void updateOrderlist(int orderID, String status){
		for(Order ord:orders){
			if(ord.getOrderID() == orderID){
				ord.setStaus(status);
			}
		}
	}
	
	public void updateOrderQuelist(int orderID, String status){
		for(Order ord:orderQue){
			if(ord.getOrderID() == orderID){
				ord.setStaus(status);
			}
		}
	}
	
	public Order confirmOrder(String orderStr){
		String[] str = orderStr.split(";");
		int orderID = Integer.parseInt(str[0]);	
		if(str[2].equalsIgnoreCase("confirm")){
			for(Order order:orders){
				if(order.getOrderID() == orderID){
					order.setStaus("CONFIRMED");
					order.setTaxi(str[1]);
					updateOrderlist(order.getOrderID(), "CONFIRMED");
					order.setMessage("A taxi is on its way");
					orderQue.remove(0);
					return order;
				}
			}
		}
		return null;
	}
	
	public void faireDone(String orderStr){
		String[] str = orderStr.split(";");
		int orderID = Integer.parseInt(str[0]);
		if(str[2].equalsIgnoreCase("done")){
			for(Order order:orders){
				if(order.getOrderID() == orderID){
					order.setStaus("DONE");
					updateOrderlist(order.getOrderID(), "DONE");
				}
			}
		}
	}
	
	
	public String makeTopic(String alias){
		return alias+";order";
	}
	
	public String printString(String str){
		System.out.println("ORDER SENDT TO TAXI: " + str);
		return str;
	}

	public void pr(){
		System.out.println("Pr: " + taxis.toString());
	}

}
