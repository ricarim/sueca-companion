package sueca;

import java.util.Scanner;

import sueca.Game;

public class App{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Choose how you want to insert the cards:");
        System.out.println("1- Camera Detection");
        System.out.println("2- Manually inserted");
        System.out.print("Type 1 or 2: ");

        int type = in.nextInt();

        Game game = new Game();
        game.startGame();
    }
}
