import java.util.Scanner;
public class CharacterCreation {
    // Getting the user input to create his/her character
    public static void CharacterCreation () {
        //Asking user for character name and saving it
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of your character?");
        String name = sc.nextLine();
        System.out.println("What is your gender?");
        String gender = sc.nextLine();
        System.out.println("On a scale of 1 - 10, How good are you?");
        int good = sc.nextInt();
    }
    public static void main (String[] args){
        CharacterCreation();
    }
}


