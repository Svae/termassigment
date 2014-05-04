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
				for(Order ords:orders){
					if(ords.getOrderID() == order.getOrderID()){
						ord.setStaus("CANCELLED");
					}
				}
			}
		};			
		order.setMessage("The order has been cancelled");
		order.setStaus("CANCELLED");
		return order;
		
		
	}
	

	
	public ArrayList<String> proccessOrder(Order order){
		if (order != null){
			available = new ArrayList<String>();
			for(Taxis taxi:taxis){
				available.add(taxi.getAlias()+";"+taxi.getPosistion()+";"+ order.getDestination());
			}
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
		for(Order ord:orders){
			if(ord.getOrderID() == order.getOrderID()){
				ord.setStaus("SENT");
			}
		}
		for(Order ords:orders){
			if(ords.getOrderID() == order.getOrderID()){
				ords.setStaus("SENT");
			}
		}
		return order.getDestination()+";"+order.getOrderID()+";"+order.getUser();
	}
	


	
	public Order confirmOrder(String orderStr){
		String[] str = orderStr.split(";");
		int orderID = Integer.parseInt(str[0]);	
		if(str[2].equalsIgnoreCase("confirm")){
			for(Order order:orders){
				if(order.getOrderID() == orderID){
					order.setStaus("CONFIRMED");
					order.setTaxi(str[1]);
					for(Order ord:orders){
						if(ord.getOrderID() == order.getOrderID()){
							ord.setStaus("CONFIRMED");
						}
					}
					order.setMessage("A taxi is on its way");
					orderQue.remove(0);
					return order;
				}
			}
		}else if(str[2].equalsIgnoreCase("done")){
			for(Order order:orders){
				if(order.getOrderID() == orderID){
					order.setStaus("DONE");
						for(Order ord:orders){
							if(ord.getOrderID() == order.getOrderID()){
								ord.setStaus("DONE");
							}
						}
					}
				} return order;
			}
			
		return null;
	}
	
	
	
	
	public String makeTopic(String alias){
		return alias+";order";
	}
	


}
