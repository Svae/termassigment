package termassigment.testblock.component;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public String getID(){
		return "123";
	}
	
	public String getMessage(){
		return "112";
	}
	
	public void print(String out){
		System.out.println(out);
	}
	
	public Order makeOrder(String message){
		Order order = new Order("123", message);
		return order;
	}
	
	public void print(Order order){
		System.out.println(order.toString());
	}
	
	public static String getAlias(Order order){
		return order.getAlias();
	}
}