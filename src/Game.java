import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nickzhang
 * Date: 6/17/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public static final int TOTAL_FRAMES = 10;
    private int score;
    private List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int pins) {
        rolls.add(pins);

        ignoreSecondThrowGivenStrikeFirst(pins);
    }

    private void ignoreSecondThrowGivenStrikeFirst(int pins) {
        if (pins == 10)
        {
            rolls.add(0);
        }
    }

    public int score() {
        for (int frame = 0; frame < TOTAL_FRAMES; frame+=2) {
            if(isStrike(frame)){
                score += 10 + rolls.get(frame+2) + rolls.get(frame + 3);
            } else if (isSpare(frame))
            {
                score += 10 + rolls.get(frame + 2);
            } else {
                score += rolls.get(frame) + rolls.get(frame + 1);
            }
        }

        return score;
    }

    private boolean isStrike(int frame) {
        return rolls.get(frame) == 10;
    }

    private boolean isSpare(int frame) {
        return rolls.get(frame) + rolls.get(frame + 1) == 10;
    }
}
