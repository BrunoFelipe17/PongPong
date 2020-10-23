package game.scenes;

import com.jogamp.opengl.GL2;
import static game.Cena.gl;
import static game.Cena.glut;
import static game.Cena.textures;
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
        drawBackground();
        Drawing.bar(1f, 1f, 1f);
        Drawing.ball();
        drawScore();
    }
    
    private void drawBackground() {
//        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
//        gl.glColor3f(0,1,0.8f); //cor do objeto
//        gl.glPushMatrix();
//        gl.glTranslatef(0, 0, -300);
//        glut.glutSolidTorus(29, 58, 16, 4);
//        gl.glPopMatrix();
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
