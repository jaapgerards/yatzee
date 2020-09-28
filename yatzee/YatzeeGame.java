package yatzee;

import java.util.ArrayList;
import java.util.List;

public class YatzeeGame {

    private List<YatzeePlay> historyOfPlays = new ArrayList<>();
    private int totalPoints = 0;

    public List<YatzeePlay> getHistoryOfPlays() {
        return historyOfPlays;
    }

    public void playYatzeePlay(){
        YatzeePlay yp = new YatzeePlay();
        int pointsOfThisPlay = PointsCounter.yatzeePoints(yp.getDices());
        System.out.println("\nPoints of this play: " + pointsOfThisPlay);
        yp.setPoints(pointsOfThisPlay);
        this.totalPoints += pointsOfThisPlay;
        historyOfPlays.add(yp);
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
