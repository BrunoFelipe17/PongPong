package game.scenes;

import utils.Constants;
import utils.Drawing;
import utils.Physics;
import utils.Text;

public class PhaseTwo {

    public void init() {
        Constants.speed = 0.03f;
        isPaused();
        draw();
        changePhase();
        drawScore();
    }
    
    private void drawScore() {
        Text.draw(
                "Score: " + Constants.score,
                30,
                100,
                (700)
        );
    }

    private void isPaused() {
        if (!Constants.pause) {
            Physics.runEngine();
        } else {
            Text.draw("JOGO PAUSADO", 30, 1, 1);
        }
    }

    private void draw() {
        changeDificult();
        Drawing.ball();
        Drawing.obstacle();
    }

    private void changePhase() {
        if (Constants.lives == 0) {
            Constants.phase = 3;
        }
    }
    
    private void changeDificult() {
        if (Constants.score >= 400) {
            Drawing.bar(
                    (float) Math.random() * 1,
                    (float) Math.random() * 1,
                    (float) Math.random() * 1);
            Constants.angle++;
        } else {
            Drawing.bar(1f, 1f, 1f);
        }
    }
}
