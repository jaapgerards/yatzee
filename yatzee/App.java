package yatzee;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        YatzeeGame yg = new YatzeeGame();

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        while (quit == false) {
            System.out.println("\nType 'Q' to quit. Type 'P' to play!\nSum of points at this moment: " + yg.getTotalPoints() + "\n");
            if (scanner.nextLine().equals("Q")) {
                quit = true;
                continue;
            }
            yg.playYatzeePlay();
        }
    }
}
