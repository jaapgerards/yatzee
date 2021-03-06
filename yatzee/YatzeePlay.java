package yatzee;

import java.util.Scanner;

public class YatzeePlay {

    private int numberOfThrows = 0;
    private Dice[] dices = new Dice[5];
    private byte[] keepArray = {0, 0, 0, 0, 0};
    private int pointsAfterPlay;

    {
        for (int i = 0; i < 5; i++) {
            dices[i] = new Dice();
        }
        this.play();
    }

    public void play() {
        while (numberOfThrows < 3) {
            numberOfThrows++;
            throwDices();
        }
    }

    public void throwDices() {
        for (int i = 0; i < 5; i++) {
            if (keepArray[i] == 0) {
                dices[i].throwDice();
            }
        }
        String output = "\nTHROW NUMBER " + numberOfThrows + "\n\nThrown dices (number): \t1\t2\t3\t4\t5\nThrown dices (value): \t";
        for (Dice dice : dices) {
            output += dice.getNumber() + "\t";
        }
        System.out.println(output);

        if (numberOfThrows < 3) {
            keepDices();
        }
    }

    public void keepDices() {
        System.out.println("\nType the number(s) of the dice(s) that you want to keep:\n");
        Scanner input = new Scanner(System.in);
        while (true) {
            if (input.hasNextInt() == false) {
                input.nextLine();
                System.out.println("Please give a valid number: ");
                continue;
            }
            int dicesToKeep = input.nextInt();
            input.nextLine();
            while (dicesToKeep >= 1) {
                int numberToKeep = (dicesToKeep % 10) - 1;
                dicesToKeep /= 10;
                if (numberToKeep + 1 <= 5 && numberToKeep + 1 > 0) {
                    this.keepArray[numberToKeep] = 1;
                }else if(numberToKeep + 1 > 5 || numberToKeep + 1 <= 0) {
                    System.out.println("Number " + (numberToKeep + 1) + " was not saved, since it was an invalid input.");
                }
            }
            break;
        }
    }

    public int getNumberOfThrows() {
        return numberOfThrows;
    }

    public Dice[] getDices() {
        return dices;
    }

    public byte[] getKeepArray() {
        return keepArray;
    }

    public void setPointsAfterPlay(int pointsAfterPlay) {
        this.pointsAfterPlay = pointsAfterPlay;
    }

    public int getPointsAfterPlay() {
        return pointsAfterPlay;
    }
}
