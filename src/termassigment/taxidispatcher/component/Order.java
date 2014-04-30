package termassigment.taxidispatcher.component;

public class Order {

	private String user, taxiID, toAddress, fromAddress, message, status;
	private int orderID, userPos;
	private Status statuss;
	
	
	
	public String getUser() {
		return user;
	}


	public String getTaxiID() {
		return taxiID;
	}


	public String getMessage() {
		return message;
	}


	public int getOrderID() {
		return orderID;
	}
	
	public String getStatus(){
		return status;
	}


	public Order(String user, String message, String status){
		this.user = user;
		this.message = message;
		this.status = status;
		this.orderID = 0;
	}
	
	
	
	public String toString(){
		return "userID: " + user + "\n" + "Message: " + message;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;	
	}


	public void setStaus(String status) {
		this.status = status;
		
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
}
