package termassigment.getorderinfo;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class GetOrderInfo extends Block {
	
	public String getAlias(Order order){
		return order.getUser();
	}
	
	public String getMessage(Order order){
		return order.getMessage();
	}

	
	
}
