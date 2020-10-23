package game.scenes;

import game.Renderer;
import utils.Constants;
import utils.Drawing;
import utils.Physics;
import utils.Text;

public class PhaseOne {

    public void init() {
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
        if (Constants.pause) {
            Text.draw(
                    "JOGO PAUSADO", 
                    60, 
                    Renderer.getScreenWidth() / 2 - 220,
                    Renderer.getScreenHeight() / 2); 
        } else {
            Physics.runEngine();
        }
    }
    
    private void draw() {
        Drawing.bar(1f, 1f, 1f);
        Drawing.ball();
    }
    
    private void changePhase() {
        if (Constants.score == 200) {
            Constants.phase = 2;
        }
        
        if (Constants.lives == 0) {
            Constants.phase = 3;
        }
    }
}
