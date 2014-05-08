package termassigment.nearesttaxi;

import java.util.ArrayList;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;
import no.ntnu.item.ttm4115.simulation.routeplanner.Route;

public class NearestTaxi extends Block {
	public String[] str;
	public int shortestPath;
	public java.lang.String alias;
	public java.util.ArrayList<java.lang.String> taxis;
	
	public Journey createJourey(){
		System.out.println("SHORTESTPATH: " + shortestPath );
			if(taxis != null && taxis.size()>0){
				System.out.println("CREATE Journey: " + taxis.get(0).toString());
				str = taxis.get(0).toString().split(";");
				taxis.remove(0);
				Journey j = new Journey(str[0],str[1],str[2]);
			return j;
			}
			return null;
	}
	
	public void init(ArrayList<String> taxis){
		this.taxis = taxis;
		shortestPath = -1;
		
	}
	
	public Route shortestRoute(Route route){
		if(shortestPath == -1 ){
			shortestPath = route.legs.get(0).steps.size();
			alias = str[0];
		}
		else if(shortestPath > route.legs.get(0).steps.size()){
			shortestPath = route.legs.get(0).steps.size();
			alias = str[0];
		}
		return route;
	}
	
	public boolean listEmpty(Route route){
		return (taxis.size()==0);
	}
	public String dispatchTaxi(){
		System.out.println("ALDASD: " + alias + ",,," + shortestPath);
		return alias;
	}
	
	public void printErr(){
		if (alias != null){
			System.out.println("NearestTaxi.printErr()" + alias);
		}
	}
}

