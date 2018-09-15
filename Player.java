public class Player {
	String name;
	int age;
	String gender;
	int baseRep;
	Player(){	
	}
	Player(String name, int age, String gender, int baseRep){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.baseRep = baseRep;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGedner(String gender) {
		this.gender = gender;
	}
	public int getBaseRep() {
		return baseRep;
	}
	public void setBaseRep(int baseRep) {
		this.baseRep = baseRep;
	}
}
