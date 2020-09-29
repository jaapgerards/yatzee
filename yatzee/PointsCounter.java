package yatzee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

enum Sets {
    ONES, TWOS, THREES, FOURS, FIVES, SIXES, YATZEE, FOUR_OF_A_KIND, THREE_OF_A_KIND, FULL_HOUSE, GROTE_STRAAT, KLEINE_STRAAT, FREE_CHOICE;
}

public class PointsCounter {

    private Map<Sets, Integer> scoreBoard = new LinkedHashMap<>();
    {
        for (Sets set : Sets.values()){
            scoreBoard.put(set, 0);
        }
    }

    public void fillInScoreBoard(Dice[] dices){

        Sets set = getInput();
        int points = yatzeePoints(dices, set);
        System.out.println("You picked " + set + " for " + points + " points");
        this.scoreBoard.put(set, points);

    }

    public int yatzeePoints(Dice[] dices, Sets set) {

        int[] valueOfDices = new int[7];
        for (Dice dice : dices) {
            valueOfDices[dice.getNumber()]++;
        }

        int points = 0;

        switch (set) {

            case ONES:
                return valueOfDices[1];

            case TWOS:
                return valueOfDices[2] * 2;

            case THREES:
                return valueOfDices[3] * 3;

            case FOURS:
                return valueOfDices[4] * 4;

            case FIVES:
                return valueOfDices[5] * 5;

            case SIXES:
                return valueOfDices[6] * 6;

            case YATZEE:
                for (Dice dice : dices) {
                    if (dice.getNumber() != dices[0].getNumber()) {
                        return 0;
                    }
                }
                return 50;

            case FOUR_OF_A_KIND:
                for (int i = 1; i <= 6; i++) {
                    if (valueOfDices[i] == 4) {
                        points += 4 * i;
                        for (int j = 1; j <= 6; j++) {
                            if (valueOfDices[j] == 1) {
                                points += j;
                            }
                        }
                        return points;
                    }
                }
                return 0;

            case THREE_OF_A_KIND:
                for (int i = 1; i <= 6; i++) {
                    if (valueOfDices[i] == 3) {
                        points += 3 * i;
                        for (int j = 1; j <= 6; j++) {
                            if (valueOfDices[j] != 3) {
                                points += j * valueOfDices[j];
                            }
                        }
                        return points;
                    }
                }
                return 0;

            case FULL_HOUSE:
                for (int i = 1; i <= 6; i++) {
                    if (valueOfDices[i] == 3) {
                        for (int j = 1; j <= 6; j++) {
                            if (valueOfDices[j] == 2) {
                                return 25;
                            }
                        }

                    }
                }
                return 0;

            case GROTE_STRAAT:
                for (int i = 1; i <= 6; i++) {
                    if (valueOfDices[i] > 1) {
                        return 0;
                    }
                }
                if (valueOfDices[2] + valueOfDices[3] + valueOfDices[4] + valueOfDices[5] != 4) {
                    return 0;
                }
                return 40;

            case KLEINE_STRAAT:
                int succesIntegers = 0;
                for (int i = 1; i <= 4; i++) {
                    if (valueOfDices[i] == 0) {
                        break;
                    }
                    succesIntegers ++;
                    if (succesIntegers == 4){
                        return 30;
                    }
                }
                succesIntegers = 0;
                for (int i = 2; i <= 5; i++) {
                    if (valueOfDices[i] == 0) {
                        break;
                    }
                    succesIntegers ++;
                    if (succesIntegers == 4){
                        return 30;
                    }
                }
                succesIntegers = 0;
                for (int i = 3; i <= 6; i++) {
                    if (valueOfDices[i] == 0) {
                        break;
                    }
                    succesIntegers ++;
                    if (succesIntegers == 4){
                        return 30;
                    }
                }
                return 0;

            case FREE_CHOICE:
                for (int i = 1; i <= 6; i++) {
                    points += i * valueOfDices[i];
                }
                return points;

            default:
                return 0;
        }
    }


    private Sets getInput() {

        String s = "\n";
        int i = 0;
        for (Sets set : Sets.values()) {
            s += i;
            s += "\t" + set + "\n";
            i++;
        }
        System.out.println(s + "\nGive the number of the place where you want to count the points...");

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            int input = scanner.nextInt();
            scanner.nextLine();
            if ((input >= 0) && (input < Sets.values().length) && (scoreBoard.get(Sets.values()[input])) == 0) {
                quit = true;
                return Sets.values()[input];
            }
            System.out.println("INVALID INPUT");
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "Scoreboard at this moment:\n\n";
        for (Map.Entry<Sets, Integer> entry : scoreBoard.entrySet()) {
            s += entry.getValue();
            s += "\t" + entry.getKey() + "\n";
        }
        return s;
    }
}
