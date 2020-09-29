package yatzee;

import java.util.ArrayList;
import java.util.List;

public class YatzeeGame {

    private List<YatzeePlay> historyOfPlays = new ArrayList<>();
    private PointsCounter pointsCounter = new PointsCounter();



    public void playYatzeePlay(){
        YatzeePlay yatzeePlay = new YatzeePlay();
        pointsCounter.fillInScoreBoard(yatzeePlay.getDices());
        historyOfPlays.add(yatzeePlay);
    }

    public List<YatzeePlay> getHistoryOfPlays() {
        return historyOfPlays;
    }

    public PointsCounter getPointsCounter() {
        return pointsCounter;
    }
}
