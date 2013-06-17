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
    }

    public int score() {
        int frameIndex = 0;
        for (int frame = 0; frame < TOTAL_FRAMES; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex, frame);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += rolls.get(frameIndex) + rolls.get(frameIndex + 1);
                frameIndex += 2;
            }
        }

        return score;
    }

    private Integer spareBonus(int frameIndex) {
        return rolls.get(frameIndex + 2);
    }

    private int strikeBonus(int frameIndex, int frame) {
        return rolls.get(frameIndex + 1) + rolls.get(frame + 2);
    }

    private boolean isStrike(int frame) {
        return rolls.get(frame) == 10;
    }

    private boolean isSpare(int frame) {
        return rolls.get(frame) + rolls.get(frame + 1) == 10;
    }
}
