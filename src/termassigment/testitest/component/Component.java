package termassigment.testitest.component;

import java.util.ArrayList;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {
	
	public ArrayList<String> init(){
		ArrayList<String> taxilist = new ArrayList<String>();
		taxilist.add("taxi1;Lade, Trondheim;Tiller, Trondheim");
		taxilist.add("taxi2;Valentinlyst, Trondheim;Tiller, Trondheim");
		taxilist.add("taxi1;Brundalen, Trondheim;Tiller, Trondheim");
		return taxilist;
	}
	
	public String alias(){
		return "taxi1";
	}
	
	public void conf(){
		System.out.println("Confirm");
	}
	
	public void dec(){
		System.out.println("Dec");
	}
	
	public void print(String alias){
		System.out.println(alias);
	}

}
