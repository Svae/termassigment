package termassigment.taxi;

import no.ntnu.item.arctis.runtime.Block;

public class Taxi extends Block {
	
	public String position;
	public String status;
	public java.lang.String currentOrder;
	public no.ntnu.item.ttm4115.simulation.routeplanner.Journey currentJourney;
	public java.lang.String alias;

	
	public static String getAlias(String alias){
		return alias;
	}
	
	public void pr(){
		System.out.println("Ferdig :D");
	}
}
