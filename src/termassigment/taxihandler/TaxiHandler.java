package termassigment.taxihandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiHandler extends Block {
	
	
	public ArrayList<Taxis> taxiList = new ArrayList<Taxis>();
	public ArrayList<Taxis> available = new ArrayList<Taxis>();
	
	
	public void addTaxis(String taxi, String status, String pos){
		Taxis newTaxi = new Taxis(taxi,status, pos);	
		taxiList.add(newTaxi);
	}
	
	public void inti(){
		taxiList.add(new Taxis("taxi1","OFF DUTY", "Tiller"));
	}
	public void updateTaxi(String update){
		System.out.println("UPDATE: " + update);
		boolean newTaxi = true;
		String[] prop = update.split(";");
		for(Taxis taxi:taxiList){
			if(taxi.getAlias().equalsIgnoreCase(prop[0])){
				taxi.setStatus(prop[1]);
				taxi.setPosistion(prop[2]);
				newTaxi = false;
			}
		}
		if(newTaxi){addTaxis(prop[0],prop[1],prop[2]);}
		for(Taxis t:taxiList)
			System.out.println("TAXILIST: " + t.toString());
	}
	
	public ArrayList<Taxis> availableTaxis(){
		available = new ArrayList<Taxis>();
		
		for(Taxis taxi:taxiList){
			if(taxi.getStatus().equalsIgnoreCase("AVAILABLE")){
				available.add(taxi);
			}
		}
		return available;
	}
	
	public String orderUpdate(String orderStr){
		System.out.println("CONFIRMENT");
		String[] prop = orderStr.split(";");
		if(prop[2].equalsIgnoreCase("CONFIRM")){
			updateOrderTaxi(prop[1],"UNAVAILABLE");
		}
		return orderStr;
	}

	public void updateOrderTaxi(String alias, String status){
		for(Taxis taxi:taxiList){
			if(taxi.getAlias().equalsIgnoreCase(alias)){
				taxi.setStatus(status);
			}
		}
	}


}
