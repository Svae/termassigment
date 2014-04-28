package termassigment.taxidispatcher.component;

public class Order {

	private String alias, taxiID,toAddress, fromAddress, message;
	private int orderID;
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	private Status status;
	
	public Order(String alias, String message){
		this.alias = alias;
		this.message = message;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void Order(String customerID){
		this.alias = customerID;
	}
	
	public void Order(String customerID, String taxiID){
		this.alias = customerID;
		this.taxiID = taxiID;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String customerID) {
		this.alias = customerID;
	}

	public String getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(String taxiID) {
		this.taxiID = taxiID;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String toString(){
		return "Customer ID: " + alias + "\n" + "Message: " + message;
	}
	
}
