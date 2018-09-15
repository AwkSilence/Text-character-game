
public class Location {
	private Person[] listPeople;
	private String name;
	public Location(int numPeople, String localeName) {
		name = localeName;
		listPeople = new Person[numPeople];
	}
	public void setPerson(int x, Person newPerson) {
		listPeople[x]=newPerson;
	}
	public String getLocationName() {
		return name;
	}
}