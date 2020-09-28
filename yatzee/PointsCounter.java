package yatzee;

enum Sets {
    YATZEE, FOUR_OF_A_KIND, THREE_OF_A_KIND, FULL_HOUSE, GROTE_STRAAT, KLEINE_STRAAT;
}

public class PointsCounter {

    public static int yatzeePoints(Dice[] dices) {
        int[] values = new int[7];
        for (Dice dice : dices){
            values[dice.getNumber()] ++;
        }
        SETS:
        for (Sets set : Sets.values()) {
            int points = 0;
            switch (set) {

                case YATZEE:
                    for (Dice dice : dices) {
                        if (dice.getNumber() != dices[0].getNumber()) {
                            continue SETS;
                        }
                    }
                    return 50;

                case FOUR_OF_A_KIND:
                    for (int i = 1; i <= 6; i++) {
                        if (values[i] == 4) {
                            points += 4 * i;
                            for (int j = 1; j <= 6; j++) {
                                if (values[j] == 1) {
                                    points += j;
                                }
                            }
                            return points;
                        }
                    }
                    continue SETS;

                case THREE_OF_A_KIND:
                    for (int i = 1; i<= 6; i++) {
                        if (values[i] == 3) {
                            points += 3 * i;
                            for (int j = 1; j <= 6; j++) {
                                if (values[j] != 3) {
                                    points += j * values[j];
                                }
                            }
                            return points;
                        }
                    }
                    continue SETS;

                case FULL_HOUSE:
                    for (int i = 1; i<=6; i++) {
                        if (values[i] == 3) {
                            for (int j = 1; j<=6; j++) {
                                if (values[j] == 2) {
                                    points = 25;
                                    return points;
                                }
                            }

                        }
                    }
                    continue SETS;

                case GROTE_STRAAT:
                    for (int i = 1; i<=6; i++) {
                        if (values[i] > 1) {
                            continue SETS;
                        }
                    }
                    if (values[2] + values[3] + values[4] + values[5] != 4) {
                        continue SETS;
                    }
                    points = 40;
                    return points;

                case KLEINE_STRAAT:
                    for (int i = 1; i<=4; i++) {
                        if (values[i] >= 1) {
                            return 30;
                        }
                    }
                    for (int i = 2; i<=5; i++) {
                        if (values[i] >= 1) {
                            return 30;
                        }
                    }
                    for (int i = 3; i<=6; i++) {
                        if (values[i] >= 1) {
                            return 30;
                        }
                    }
                    continue SETS;
            }
        }
        return 0;
    }
}
