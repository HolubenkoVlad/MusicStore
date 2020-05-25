package sk.musicstore.models;

/**The wrapper class that is needed to convey the result of the query and the message*/

public class ResponseWrapper {
	private boolean status;
	private String message;
	
	public ResponseWrapper(boolean status, String message){
		this.status=status;
		this.message=message;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
