package termassigment.testblock.component;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;

public class Component extends Block {

	public Journey getID(){
		return new Journey("taxi1","Tiller, Trondheim", "Lade, Trondheim");
	}
	
	public Journey getIDD(){
		return new Journey("taxi2","Valentinlyst, Trondheim", "Oslo, Norway");
	}
	
	public String getMessage(){
		return "112";
	}
	
	public void print(String out){
		System.out.println(out);
	}
	
	
	
	public void print(Order order){
		System.out.println(order.toString());
	}
	
}