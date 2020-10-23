package game.scenes;

import com.jogamp.opengl.GL2;
import static game.Cena.gl;
import static game.Cena.textures;
import game.Renderer;
import utils.Constants;
import utils.Text;

public class GameOver {
    
    public void init() {
        drawBackgroundImage();
    }
    
        private void drawBackgroundImage() {
        gl.glColor3f(1,0,0);
        gl.glPushMatrix();

        textures.gerarTextura(gl, Constants.backgroundGameOver, 0);
        gl.glBegin(GL2.GL_QUADS);

        gl.glTexCoord2f(0.0f, 1);
        gl.glVertex2f(-1.0f, -1.0f);

        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(1.0f, -1.0f);

        gl.glTexCoord2f(1, 0.0f);
        gl.glVertex2f(1.0f, 1.0f);

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex2f(-1.0f, 1.0f);

        gl.glEnd();
        textures.desabilitarTextura(gl, 0);
    }
}
