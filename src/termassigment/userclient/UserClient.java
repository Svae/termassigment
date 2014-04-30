package termassigment.userclient;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {
	
	public static java.lang.String alias_customer;
	public java.lang.String topic = "central";
	public int orderID;

	public Order makeOrder(String alias, String message){
		Order newOrder = new Order(alias, message, "NEW");
		return newOrder;
	}

	
	public String welcome(){
		return "You're connected!";
	}
	

	public static String getAlias(String alias){
		return alias_customer;
	}

	public String getMessage(Order order) {
		return order.getMessage();
	}


}
