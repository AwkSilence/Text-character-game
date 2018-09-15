/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Textcharactergame;

/**
 *
 * @author migui
 */
import java.util.Scanner;
public class Instructions {
    public static void Instruction(){
     Scanner input = new Scanner(System.in);
    System.out.println("Would you like to read instructions (yes/no)?");
    String YE = input.nextLine();
  
        
    while ((!YE.equals("yes")) && (!YE.equals("no"))){
                 System.out.println("Would you like to read instructions (yes/no)?");
                 YE = input.nextLine();
            }
    
        switch (YE){
            case "yes":
    System.out.println("***********************************************\n"
            +          "*****************INSTRUCTIONS******************\n"
            +          "***********************************************\n\n");
    System.out.println("Hello and welcome to our game: Ba... Good To The Bone");
    System.out.println("The goal of the game is to obtain 0 hunger and 100 morale.\n"
            +          "The character you create starts with 0-10 morale depending\n"
            +          "on your choice at character create, and with 50 hunger.\n"
            +          "There are several ways to obtain morale and lower hunger but mostly\n"
            +          "helping npcs or completing actions that are required of your character.\n"
            +          "When visiting the shop you can purchase food or steal it. \n"
            +          "The good meter in this game will track your actions. Your\n"
            +          "good meter goes up when you do something good and down when you do something\n"
            +          "bad. Tip: (Never say no to grandma and avoid seeing principle\n"
            +          "if below 50 morale.)If your good meter hits 0, you lose aswell as\n"
            +          "if your hunger meter hits 100. So, watch your actions\n"
            +          "This is all for now. Have fun in our game!!\n");
            case "no":
                System.out.println("Good luck and have fun!");
           
}
        
    }
    public static void main (String[] args){
        Instruction();
    }
}
