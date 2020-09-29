package yatzee;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        YatzeeGame yg = new YatzeeGame();

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        while (quit == false) {
            System.out.println("\nType 'Q' to quit. Type 'P' to play. Type 'S' to see the scoreboard!\n");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("Q")) {
                quit = true;
                continue;
            } else if (input.equals("S")) {
                System.out.println(yg.getPointsCounter().toString());
                continue;
            } else if (input.equals("P")) {
                yg.playYatzeePlay();
            }
        }
    }
}
