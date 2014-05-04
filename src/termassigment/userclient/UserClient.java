package termassigment.userclient;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {
	
	public static java.lang.String alias_customer;
	public java.lang.String topic = "order";
	public termassigment.taxidispatcher.component.Order order;
	
	public Order makeOrder(String alias, String adress){
		if (order != null){
			order.setStaus("CHANGE");
			order.setDestiantion(adress);
			order.setMessage(adress);
		}else{
			Order newOrder = new Order(alias, adress, "NEW");
			this.order = newOrder;
		}
		return order;
	}

	
	public String welcome(){
		return "You're connected!";
	}
	
	public Order cancelOrder(){
		order.setStaus("CANCEL");
		return order;
	}
	
	public boolean hasOrder(){
		return (order != null);
	}

	public static String getAlias(String alias){
		return alias_customer;
	}

	public String getMessage(Order order) {
		return order.getMessage();
	}

	public void setOrder(Order order){
		if(order.getStatus().equalsIgnoreCase("CANCELLED")){
			this.order = null;
		} else{
			this.order = order;
		}
	}

}
