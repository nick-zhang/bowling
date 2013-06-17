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
    @Test
    public void shouldScoreZeroWhenKnockedDownZeroPins(){
        Game game = new Game();

        for (int i=0; i<21; i++){
            game.roll(0);
        }

        int score = game.score();
        assertThat("The total score calculated error!", score, is(0));
    }

}
