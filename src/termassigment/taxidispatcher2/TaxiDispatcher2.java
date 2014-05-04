package termassigment.taxidispatcher2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import termassigment.taxidispatcher.component.Order;
import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;
import no.ntnu.item.ttm4115.simulation.routeplanner.Route;

public class TaxiDispatcher2 extends Block {
	public ArrayList<String> order;
	public String[] str;
	public java.util.ArrayList<java.lang.String> taxies;
	public int shortestPath = -1;
	public java.lang.String alias;
	
	
	public Journey createJourey(){
			str = taxies.get(0).toString().split(";");
			taxies.remove(0);
			Journey j = new Journey(str[0],str[1],str[2]);
			return j;
	}
	
	
	
	public Route shortestRoute(Route route){
		if(shortestPath == -1 ){
			shortestPath = route.legs.get(0).steps.size();
			alias = str[0];
		}
		else if(shortestPath > route.legs.get(0).steps.size()){
			shortestPath = route.legs.get(0).steps.size();
			alias = str[0];
			System.out.println("HALLO");
		}
		return route;
	}
	
	public boolean listEmpty(Route route){
		return (taxies.size()==0);
	}
	public String dispatchTaxi(){
		return alias;
	}
	
	public void printErr(){
		System.err.println("ERROR");
	}
}

