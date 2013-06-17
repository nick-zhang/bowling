import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nickzhang
 * Date: 6/17/13
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void shouldScoreZeroWhenKnockedDownZeroPins(){
        rollMany(21, 0);

        int score = game.score();
        assertThat("Total score calculation error!", score, is(0));
    }

    @Test
    public void shouldCalculateOpenScoreAsExpected(){
        game.roll(5);
        game.roll(4);

        rollMany(19, 0);

        int score = game.score();
        assertThat("Total score calculation error!", score, is(9));
    }

    @Test
    public void shouldCalculateScoreForOneSpare(){
        rollSpare();

        game.roll(4);

        rollMany(18, 0);
        int score = game.score();
        assertThat("Total score calculation with one spare error!", score, is(18));

    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int times, int pins) {
        for (int i=0; i< times; i++){
            game.roll(pins);
        }
    }

}
