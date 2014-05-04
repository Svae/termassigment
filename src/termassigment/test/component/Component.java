package termassigment.test.component;

import java.util.ArrayList;

import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public ArrayList<String> init(){
		ArrayList<String> taxilist = new ArrayList<String>();
		taxilist.add("taxi1;Lade, Trondheim;Tiller, Trondheim");
		taxilist.add("taxi2;Valentinlyst, Trondheim;Tiller, Trondheim");
		taxilist.add("taxi1;Brundalen, Trondheim;Tiller, Trondheim");
		return taxilist;
	}
	
	public void print(String alias){
		System.out.println(alias);
	}
}
