
public class Person {
	private Message[] event;
	
	public Person(int numOfMessages) {
		event = new Message[numOfMessages];
	}
	
	public void setMessage(int index, Message input) {
		event[index] = input;
	}	
	public String getMessage(int x) {
		return event[x].getMessage();
	}
	public int getMorale(int x) {
		return event[x].getMoraleVal();
	}
	public int getHunger(int x) {
		return event[x].getHungerVal();
	}
}