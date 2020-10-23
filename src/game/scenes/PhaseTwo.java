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
    }

    private void isPaused() {
        if (!Constants.pause) {
            Physics.runEngine();
        } else {
            Text.draw("JOGO PAUSADO", 30, 1, 1);
        }
    }

    private void draw() {
        Drawing.bar(1f, 1f, 1f);
        Drawing.ball();
        Drawing.obstacle();
    }

    private void changePhase() {
        if (Constants.lives == 0) {
            Constants.phase = 3;
        }
    }


}
