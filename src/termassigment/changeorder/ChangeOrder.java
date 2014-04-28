package termassigment.changeorder;

import termassigment.taxidispatcher.component.Order;
import termassigment.taxidispatcher.component.Status;
import no.ntnu.item.arctis.runtime.Block;

public class ChangeOrder extends Block {

	private Order newOrder = new Order();
	
	public ChangeOrder () {
		
		
	}
	
	public Order createOrder(String request){
		Order newOrder = new Order();
		newOrder.setMessage(request);
		newOrder.setStatus(Status.NEW);
		return newOrder;
	}
	
	public Order cancelOrder(Order order){
		order.setStatus(Status.CANCELED);
		return order;
	}
}
