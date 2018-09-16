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
	    System.out.println("The goal of the game is to be as nice as possible.\n"
	            +          "The character you create starts with 0-10 morale depending\n"
	            +          "on your choice at character creation, and with 50 hunger.\n"
	            +          "There are several ways to obtain morale and lower hunger but mostly\n"
	            +          "helping npcs or completing actions that are required of your character.\n"
	            +          "When visiting the shop you can purchase food or steal it. \n"
	            +          "The good meter in this game will track your actions. \n"
	            +		   "Tip: (Never say no to grandma, avoid seeing principal if\n"
	            +          "below 6 morale and never steal.) Other than those exceptions, good deeds\n"
	            +          "give you +2 morale while bad deeds will subtract 1.\n"
	            +          "At the end of the game, your morale and hunger will be shown.\n"
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
	        mom.setMessage(1, new Message("No dessert for you", 5, -1));
	        dad.setMessage(0, new Message("Good job sport", 0, 1));
	        dad.setMessage(1, new Message("You're grounded", 0, -1));
	        dog.setMessage(0, new Message("BORK BORK (Thank you!)", 0, 1));
	        dog.setMessage(1, new Message("BORK BORK (I really had to pee)", 0, -1));
	        gran.setMessage(0, new Message("I hope you like it dear", -10, 1));
	        gran.setMessage(1, new Message("Oh, that's too bad", 50, -100));
	        
	        System.out.println("You can talk to (1)mom, (2)dad, (3)Fluffy the Dog, or (4)grandma");
	        String talkOption = input.next();
	        switch(talkOption) {
		        case "1":
		        	System.out.println("Hello " + name + ", can you do your chores (1) yes, (2) no");
		        	String opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(mom.getMessage(0));
		        		hungerTracker += (-10);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(mom.getMessage(1));
		        		hungerTracker += (-10);
		        		moraleTracker += (5);
		        	}
		        	else {
		        		throw new IllegalArgumentException("(1) yes or (2) no"); 
		        	}
		        	break;
		        case "2":
		        	System.out.println("Hey sport, get your homework done. (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(dad.getMessage(0));
		        		hungerTracker += (0);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(dad.getMessage(1));
		        		hungerTracker += (0);
		        		moraleTracker += (-1);
		        	}
		        	break;
		        case "3":
		        	System.out.println("Fluffy wants to go for a walk. Will you walk the dog? (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(dog.getMessage(0));
		        		hungerTracker += (0);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(dog.getMessage(1));
		        		hungerTracker += (0);
		        		moraleTracker += (-1);
		        	}
		        	break;
		        case "4":
		        	System.out.println("Hello " + name + ", come here and eat! (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(gran.getMessage(0));
		        		hungerTracker += (-10);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(gran.getMessage(1));
		        		hungerTracker += (50);
		        		moraleTracker += (-100);
		        	}
		        	break;
		        }
	        System.out.println("It is time to go to school!");
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
	        
	        classmate.setMessage(0, new Message("Thank you so much!", 0, 1));
	        classmate.setMessage(1, new Message("Alright...", 0, -1));
	        teacher.setMessage(0, new Message("Alright class, lets read page 49.", 0, 1));
	        teacher.setMessage(1, new Message("You're going to the principles office!", 0, -1));
	        principal.setMessage(0, new Message("Since it's your first time here, I'll let you off easily.", 0, 1));
	        principal.setMessage(1, new Message("I'm calling your parents!", 0, -100));
	        
	        System.out.println("You can talk to (1)classmate, (2)teacher, (3)principal");
	        String talkOption = input.next();
	        switch(talkOption) {
		        case "1":
		        	System.out.println("Hello, can I borrow your pencil? (1) yes, (2) no");
		        	String opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(classmate.getMessage(0));
		        		hungerTracker += (0);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(classmate.getMessage(1));
		        		hungerTracker += (0);
		        		moraleTracker += (-1);
		        	}
		        	else {
		        		throw new IllegalArgumentException("(1) yes or (2) no"); 
		        	}
		        	break;
		        case "2":
		        	System.out.println("Sit down and pay attention!! (1) yes, (2) no");
		        	opt = input.next();
		        	if(opt.equals("1")) {
		        		System.out.println(teacher.getMessage(0));
		        		hungerTracker += (0);
		        		moraleTracker += (2);
		        	}
		        	else if(opt.equals("2")) {
		        		System.out.println(teacher.getMessage(1));
		        		hungerTracker += (0);
		        		moraleTracker += (-1);
		        	}
		        	break;
		        case "3":
		        	System.out.println("Let's check your record.");
		        	if(moraleTracker >= 6) {
		        		System.out.println(principal.getMessage(0));
		        		hungerTracker += (0);
		        		moraleTracker += (2);
		        	}
		        	else {
		        		System.out.println(principal.getMessage(1));
		        		hungerTracker += (0);
		        		moraleTracker += (-100);
		        	}
		        	break;
		        }
	        
	        System.out.println("Aren't you excited?! We're going to the beach!");
	        
	        //Beach
	        System.out.println("Location: Beach" + "\n***********************************************");
	        Location beach = new Location(4, "Beach");
	        
	        Person lifeguard = new Person(2);
	        Person crab = new Person(2);
	        Person tourist = new Person(2);
	        
	        beach.setPerson(0, lifeguard);
	        beach.setPerson(1, crab);
	        beach.setPerson(2, tourist);
	        
	        lifeguard.setMessage(0, new Message("Thank you so much! I'll get you a hot dog.", -10, 1));
	        lifeguard.setMessage(1, new Message("Oh it's okay, I guess I'll just get sun-burnt.", 0, -1));
	        crab.setMessage(0, new Message("You picked up the crab and ate him!", -10, -1));
	        crab.setMessage(1, new Message("You and the crab waved at each other.", 0, 1));
	        tourist.setMessage(0, new Message("Wow! The picture looks really nice! Thank you!", 0, 1));
	        tourist.setMessage(1, new Message("Wow the natives here are so mean...", 0, -1));
	        
	        System.out.println("You can talk to (1)lifeguard, (2)crab, or (3)tourist");
	        talkOption = input.next();
	        switch(talkOption) {
	        case "1":
	        	System.out.println("Can you help me, " + name + "? I need to put sunscreen on, or else I will get sunburnt" + ", put sunscreen on the lifeguard? (1) yes, (2) no");
	        	String opt = input.next();
	        	if(opt.equals("1")) {
	        		System.out.println(lifeguard.getMessage(0));
	        		hungerTracker += (-10);
	        		moraleTracker += (2);
	        	}
	        	else if(opt.equals("2")) {
	        		System.out.println(lifeguard.getMessage(1));
	        		hungerTracker += (0);
	        		moraleTracker += (-1);
	        	}
	        	else {
	        		throw new IllegalArgumentException("(1) yes or (2) no"); 
	        	}
	        	break;
	        case "2":
	        	System.out.println("You see a small crab in the sand. Do you pick him up? (1) yes, (2) no");
	        	opt = input.next();
	        	if(opt.equals("1")) {
	        		System.out.println(crab.getMessage(0));
	        		hungerTracker += (-10);
	        		moraleTracker += (-1);
	        	}
	        	else if(opt.equals("2")) {
	        		System.out.println(crab.getMessage(1));
	        		hungerTracker += (0);
	        		moraleTracker += (2);
	        	}
	        	break;
	        case "3":
	        	System.out.println("Excuse me " + name + ", can you take a picture of me? (1) yes, (2) no");
	        	opt = input.next();
	        	if(opt.equals("1")) {
	        		System.out.println(tourist.getMessage(0));
	        		hungerTracker += (0);
	        		moraleTracker += (2);
	        	}
	        	else if(opt.equals("2")) {
	        		System.out.println(tourist.getMessage(1));
	        		hungerTracker += (0);
	        		moraleTracker += (-1);
	        	}
	        	break; 
	        }
	        System.out.println("Time to go shopping!");
	        
	      //Shop
	        System.out.println("Location: Shop" + "\n***********************************************");
	        Location shop = new Location(4, "Shop");
	        System.out.println("You are currently at " + shop.getLocationName() + ". Press (1) to 'Talk'");
	        option = input.next();
	        
	        if(option.equals("1")) { 
	        Person grocer = new Person(2);
	        Person police = new Person(2);
	        
	        shop.setPerson(0, grocer);
	        shop.setPerson(1, police);
	        
	        grocer.setMessage(0, new Message("Thanks for shopping with us. Enjoy your candy!", -10, 1));
	        grocer.setMessage(1, new Message("Police: Thief!!", -10, -1));
	        police.setMessage(0, new Message("Kid, you're coming with me and I'm calling your parents.", 0, -50));
	        police.setMessage(1, new Message("I'll let you off this time. Don't do this again.", 0, -3));
	        
	        System.out.println("You can talk to (1)grocer");
	        talkOption = input.next();
	        switch(talkOption) {
		        case "1":
		        	System.out.println("*You really want candy* (1)buy, (2)steal");
		        	String choice = input.next();
		        	if(choice.equals("1")) {
		        		System.out.println(grocer.getMessage(0));
		        		hungerTracker += (-10);
		        		moraleTracker += (2);
		        	}
		        	else if(choice.equals("2")) {
		        		System.out.println(grocer.getMessage(1));
		        		hungerTracker += (-10);
		        		moraleTracker += (-1);
		        		if(moraleTracker < 10) {
		        			System.out.println(police.getMessage(1));
		        			hungerTracker += (0);
			        		moraleTracker += (-3);
		        		}
		        		else if(moraleTracker >= 10) {
		        			System.out.println(police.getMessage(0));
		        			hungerTracker += (0);
			        		moraleTracker += (-50);
		        		}
		        	}
		        	else {
		        		throw new IllegalArgumentException(""); 
		        	}
		        	break;
		        	}
	        }
	        else {
        		throw new IllegalArgumentException("(1) talk");
	        }
	        System.out.println("********************************");
	        System.out.println("Morality :" + moraleTracker);
	        System.out.println("Hunger :" + hungerTracker);
	        System.out.println("********************************");
	        if (hungerTracker > 50) {
	        	System.out.println("You need to eat for more nutrition!");
	        } else {
	        	System.out.println("Good job on keeping yourself well fed! :) ");
	        }
	
	        
	        if (moraleTracker < 2) {
	        	System.out.println("You have some bad bones. :( BUT you can change that!");
	        } else if (moraleTracker < 8) {
	        	System.out.println("Some good bones! You're almost there! :) ");
	        }else {
	        	System.out.println("You're good to the bone!! :>");
	        }}}
	       
	
