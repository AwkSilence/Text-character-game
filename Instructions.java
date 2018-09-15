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
        switch (YE){
            case "yes":
    System.out.println("***********************************************\n"
            +          "*****************INSTRUCTIONS******************\n"
            +          "***********************************************\n\n");
    System.out.println("Hello and welcome to our game: Ba... Good To The Bone");
    System.out.println("The goal of the game is to obtain $200. There are several ways to\n"
            +          "obtain money in the game, mostly helping npcs which includes doing\n"
            +          "chores or helping at the park. These activities can also contribute to\n"
            +          "your good meter. This game contains a hunger meter. You will\n"
            +          "need to visit the shop to buy food whenever your hunger meter gets low.\n"
            +          "This game also includes a good meter that will track your actions. Your\n"
            +          "good meter goes up when you do something good and down when you do something\n"
            +          "bad. Having a very high good meter will earn you more cash from actions while\n"
            +          "having a low good meter will earn you less cash from actions. If your good meter\n"
            +          "hits 0, you lose aswell as if your hunger meter hits 0. So, watch your actions\n"
            +          "You can also lose money in the game in the game by spending it at the \n"
            +          "shop or through encounters. This is all for now. Have fun in our game!!\n");
            case "no":
                System.out.println("Good luck and have fun!");
}
        
    }
    public static void main (String[] args){
        Instruction();
    }
}
