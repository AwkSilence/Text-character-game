import java.util.Scanner;
import java.util.*;
public class GoodToTheBone extends Exception {
	public static void main(String [] args) {
		int hungerTracker = 50;
		int moraleTracker = 10;
		Scanner input = new Scanner(System.in);
		boolean beep = true;
		System.out.println("Hello!" + "\nWelcome to our game! "+ "\nBa... Good To The Bone");
		System.out.print("Would you like to read instructions(yes/no)? ");	   
	    String insOp = input.next().toLowerCase();
	        switch (insOp){
	            case "yes":
	    System.out.println("***********************************************\n"
	            +          "*****************INSTRUCTIONS******************\n"
	            +          "***********************************************\n");
	    System.out.println("The goal of the game is to obtain 0 hunger and 100 morale.\n"
	            +          "The character you create starts with 0-10 morale depending\n"
	            +          "on your choice at character creation, and with 50 hunger.\n"
	            +          "There are several ways to obtain morale and lower hunger but mostly\n"
	            +          "helping npcs or completing actions that are required of your character.\n"
	            +          "When visiting the shop you can purchase food or steal it. \n"
	            +          "The good meter in this game will track your actions. Your\n"
	            +		   "bad. Tip: (Never say no to grandma and avoid seeing principal\n"
	            +          "if below 50 morale.)If your good meter hits 0, you lose aswell as\n"
	            +          "if your hunger meter hits 100. So, watch your actions\n"
	            +          "This is all for now. Have fun in our game!!\n");
	    			break;
	            case "no":
	                System.out.println("Good luck and have fun!");
	                break;
	        }
	        System.out.println("Enter your name:");
	        String name = input.next();
	        System.out.println("What is your gender?");
	        String gender = input.next();
	        do {
	        try {
	        System.out.println("What is your age?");
	        int age = input.nextInt();
	        beep = false;
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid answer. Please enter a number!");
	        	input.next();
	        }
	        }
	        while(beep);
	        beep = true;
		        try {
		        	System.out.println("On a scale of 1 - 10, How good are you?");
		        	int good = input.nextInt();
		        	if (good > 10)
		        		good = 10;
		        	else if (good < 1)
		        		good = 1;
		        	moraleTracker -= good;
		        	beep = false;
		        }
		        catch (InputMismatchException e) {
		 	        	System.out.println("Invalid answer. Please enter a number!");
		 	        	input.next();
		 	    }

	        System.out.println("Hello, " + name + "!");
	        
	        //Home
	        System.out.println("Location: Home" + "\n***********************************************");
	        Location home = new Location(4, "Home");
	        System.out.println("You are currently at " + home.getLocationName() + ". Press (1) to 'Talk' or press any other button to 'Leave'");
	        String option = input.next();
	        
	        if(option.equals("1")) { 
	        	Person mom = new Person(2);
		        Person dad = new Person(2);
		        Person dog = new Person(2);
		        Person gran = new Person(2);
		        
		        home.setPerson(0, mom);
		        home.setPerson(1, dad);
		        home.setPerson(2, dog);
		        home.setPerson(3, gran);
		        
		        mom.setMessage(0, new Message("Good job, I'll reward you with food", -10, 1));
		        mom.setMessage(1, new Message("No dessert for you", -10, -1));
		        dad.setMessage(0, new Message("Good job sport", 0, 1));
		        dad.setMessage(1, new Message("You're grounded", 0, -1));
		        dog.setMessage(0, new Message("BORK BORK (Thank you!)", 0, 1));
		        dog.setMessage(1, new Message("BORK BORK (I really had to pee)", 0, -1));
		        gran.setMessage(0, new Message("I hope you like it dear", -10, 1));
		        gran.setMessage(1, new Message("Oh, that's too bad", 50, -100));
		        
		        System.out.println("You can talk to (1)mom, (2)dad, (3)grandma, (4)Fluffy the Dog, or (5)leave");
		        String talkOption = input.next();
		        switch(talkOption) {
		        case "1":
		        	System.out.println("Hello " + name + ", can you do your chores (1) yes, (2) no");
		        	String opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(mom.getMessage(0));
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(mom.getMessage(1));
		        	}
		        	else {
		        		throw new IllegalArgumentException("(1) yes or (2) no"); 
		        	}
		        	break;
		        case "2":
		        	System.out.println("Hello " + name + ", can you do your chores (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(dad.getMessage(0));
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(dad.getMessage(1));
		        	}
		        	break;
		        case "3":
		        	System.out.println("Hello " + name + ", can you do your chores (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(dog.getMessage(0));
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(dog.getMessage(1));
		        	}
		        	break;
		        case "4":
		        	System.out.println("Hello " + name + ", can you do your chores (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(gran.getMessage(0));
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(gran.getMessage(1));
		        	}
		        	break;
		        case "5":	
		        	//leave
		        default: 
		        	
		        }
		        //if(msgCount > x)
		        //set hunger and morality gain to 0
	        }
	        else {
	        	System.out.println("You can go to (1)school, (2)beach, (3)shop, or (4)go back home");
	        	//show location options
	        }
	        
	        //School
	        System.out.println("Location: School" + "\n***********************************************");
	        Location school = new Location(3, "School");
	        
	        Person classmate = new Person(2);
	        Person teacher = new Person(2);
	        Person principal = new Person(2);
	        
	        school.setPerson(0, classmate);
	        school.setPerson(1, teacher);
	        school.setPerson(2, principal);

	        //Beach
	        System.out.println("Location: Beach" + "\n***********************************************");
	        Location beach = new Location(4, "Beach");
	        
	        Person lifeguard = new Person(2);
	        Person crab = new Person(2);
	        Person tourist = new Person(2);
	        
	        beach.setPerson(0, lifeguard);
	        beach.setPerson(1, crab);
	        beach.setPerson(2, tourist);
	        
	        //Shop
	        System.out.println("Location: Shop" + "\n***********************************************");
	        Location shop = new Location(4, "Shop");
	        
	        Person grocer = new Person(2);
	        Person customer = new Person(2);
	        Person police = new Person(2);
	        
	        shop.setPerson(0, grocer);
	        shop.setPerson(1, customer);
	        shop.setPerson(2, police);
	        
	        //Home -> School -> Beach -> Shop -> Home
	        
	       }
	
	}

