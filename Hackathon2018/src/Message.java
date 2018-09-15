//implement into others
public class Message {
	private String message;
	private int hungerVal;
	private int moraleVal;
	Message(String message, int hungerVal, int moraleVal){
	}
	public void setMessage(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;	
	}
	public void setHungerVal(int hungerVal) {
		this.hungerVal= hungerVal;
	}
	public int getHungerVal() {
		return hungerVal;
	}
	public void setMoraleVal(int moraleVal) {
		this.moraleVal= moraleVal;
	}
	public int getMoraleVal() {
		return moraleVal;
	}
	

}