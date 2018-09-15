
public class Person {
	private Message[] event;
	
	public Person(int numOfMessages) {
		event = new Message[numOfMessages];
	}
	
	public void setMessage(int index, Message input) {
		event[index] = input;
	}	
}
