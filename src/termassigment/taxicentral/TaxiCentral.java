package termassigment.taxicentral;

import java.util.ArrayList;

import termassigment.taxi.Taxi;
import termassigment.taxidispatcher.component.Order;
import termassigment.taxidispatcher.component.Status;
import termassigment.user.User;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiCentral extends Block {

	public java.lang.String topic;
	public java.lang.String message;
	public java.lang.String messageTopic;
	public termassigment.taxidispatcher.component.Order order;
	public void print(java.lang.String str) {
		System.err.println(str);
	}
	

	
}
