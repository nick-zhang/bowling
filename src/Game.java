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
    private int score;
    private List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        for (int frame = 0; frame < 10; frame+=2) {
            if (rolls.get(frame) + rolls.get(frame + 1) == 10) // Spare
            {
                score += 10 + rolls.get(frame + 2);
            } else {
                score += rolls.get(frame) + rolls.get(frame + 1);
            }
        }

        return score;
    }
}
