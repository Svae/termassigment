package termassigment.userclient;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {
	
	public static java.lang.String alias_customer;

	public Order makeOrder(String alias){
		Order newOrder = new Order(alias, "new");
		return newOrder;
		
	}

	public String welcome(){
		return "You're connected!";
	}
	

	public static String getAlias(String alias){
		return alias_customer;
	}

}
