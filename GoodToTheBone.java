import java.util.Scanner;
public class GoodToTheBone {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello!" + "\nWelcome to our game: "+ "\nBa... Good To The Bone");
		System.out.print("Would you like to read instructions(yes/no)? ");	   
	    String insOp = input.nextLine();
	        switch (insOp){
	            case "yes":
	    System.out.println("***********************************************\n"
	            +          "*****************INSTRUCTIONS******************\n"
	            +          "***********************************************\n");
	    System.out.println("The goal of the game is to obtain 0 hunger and 100 morale.\n"
	            +          "The character you create starts with 0-10 morale depending\n"
	            +          "on your choice at character create, and with 50 hunger.\n"
	            +          "There are several ways to obtain morale and lower hunger but mostly\n"
	            +          "helping npcs or completing actions that are required of your character.\n"
	            +          "When visiting the shop you can purchase food or steal it. \n"
	            +          "The good meter in this game will track your actions. Your\n"
	            +		   "bad. Tip: (Never say no to grandma and avoid seeing principle\n"
	            +          "if below 50 morale.)If your good meter hits 0, you lose aswell as\n"
	            +          "if your hunger meter hits 100. So, watch your actions\n"
	            +          "This is all for now. Have fun in our game!!\n");
	            case "no":
	                System.out.println("Good luck and have fun!");
	        }
	        Player user = new Player();
	        System.out.println("What is the name of your character?");
	        String name = input.nextLine();
	        System.out.println("What is your gender?");
	        String gender = input.nextLine();
	        System.out.println("What is your age?");
	        int age = input.nextInt();
	        System.out.println("On a scale of 1 - 10, How good are you?");
	        int good = input.nextInt();
	        user = new Player(name,age,gender,good);
	        //Home -> School -> Beach -> Shop -> Home
	    }
	}

