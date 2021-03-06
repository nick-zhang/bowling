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
    public void shouldCalculateScoreForAllZeros(){
        rollMany(21, 0);

        int score = game.score();
        assertThat("Total score calculation error!", score, is(0));
    }

    @Test
    public void shouldCalculateScoreForAllOnes(){
        rollMany(20, 1);

        int score = game.score();
        assertThat("Total score calculation error!", score, is(20));
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
    public void shouldCalculateScoreWithOneSpare(){
        rollSpare();

        game.roll(4);

        rollMany(18, 0);
        int score = game.score();
        assertThat("Total score calculation with one spare error!", score, is(18));
    }

    @Test
    public void shouldCalculateSoreWithOneStrike(){
        rollStrike();

        game.roll(3);
        game.roll(4);

        rollMany(17, 0);
        int score = game.score();
        assertThat("Total score calculation with one strike error!", score, is(24));
    }

    @Test
    public void shouldCalculateScoreForPerfectGame(){
        rollMany(12, 10);
        int score = game.score();
        assertThat("Total score calculation for perfect game error!", score, is(300));
    }

    private void rollStrike() {
        game.roll(10);
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
