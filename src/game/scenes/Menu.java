package game.scenes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureCoords;
import com.jogamp.opengl.util.texture.TextureIO;
import static game.Cena.gl;
import static game.Cena.textures;
import game.Renderer;
import java.io.File;
import java.io.IOException;
import utils.Constants;
import utils.Text;

public class Menu {

    Texture texture;
    String workingDir = System.getProperty("user.dir");

    public void init() {
        drawBackgroundImage();

        texts();
    }

    private void texts() {

        Text.draw(
                "Realize o maior número de pontos com a rebatida da bola e vença"
                        + " as duas fases",
                25,
                (250),
                (Renderer.getScreenHeight() / 2) + 60);

        Text.draw(
                "Comandos:",
                30,
                (250),
                (Renderer.getScreenHeight() / 2));

        Text.draw(
                "Mover: A e D",
                20,
                (250),
                (Renderer.getScreenHeight() / 2) - 25);

        Text.draw(
                "Regras:",
                30,
                (250),
                (Renderer.getScreenHeight() / 2) - 80);

        Text.draw(
                "Cada rebatida da bola da 20 pontos",
                20,
                (250),
                (Renderer.getScreenHeight() / 2) - 105);

        Text.draw(
                "Ao atingir 200 pontos, se inicia a segunda fase que possui"
                        + " pontos infinitos",
                20,
                (250),
                (Renderer.getScreenHeight() / 2) - 130);

        Text.draw(
                "Pressione 'Enter' para iniciar",
                40,
                (Renderer.getScreenWidth() / 2) - 250,
                (Renderer.getScreenHeight() / 2) - 230);
    }

    private void drawBackgroundImage() {
        gl.glColor3f(1,0,0);
        gl.glPushMatrix();

        textures.gerarTextura(gl, Constants.backgroundImage, 0);
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
