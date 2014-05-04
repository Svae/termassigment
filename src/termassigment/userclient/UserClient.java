package termassigment.userclient;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {
	
	public java.lang.String alias_customer;
	public java.lang.String topic = "order";
	public termassigment.taxidispatcher.component.Order order;
	
	public Order makeOrder(String adress){
		if (order != null){
			return null;
		}else{
			Order newOrder = new Order(alias_customer, adress, "NEW");
			this.order = newOrder;
		}
		return order;
	}

	public String printString(String str){
		System.out.println(str);
		return str;
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
		return alias;
	}

	public String getMessage(Order order) {
		return order.getMessage();
	}

	public Order orderPrint(Order r){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(r.toString());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return r;
	}
	
	public void setOrder(Order order){
		if(order.getStatus().equalsIgnoreCase("CANCELLED")){
			this.order = null;
		} else{
			this.order = order;
		}
	}

}
