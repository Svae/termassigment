package termassigment.testblock2.component;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public Order order;
	
	public Order makeOrder(){
		order = new Order("test1","vi tester");
		return order;	
	}

	public void printOutDuo(String id, String message) {
		System.out.println("ID: "+ id + " Message: "+message);
	}
}
