package yatzee;

public class Dice {

    private int number;

    public Dice() {
        this.number = 0;
    }

    public void throwDice(){
        this.number = (int) Math.ceil(6 * Math.random());
        //System.out.println(this.number);
    }

    public int getNumber() {
        return number;
    }

}
