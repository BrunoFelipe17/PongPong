package game;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.gl2.GLUT;
import game.scenes.GameOver;
import game.scenes.Menu;
import game.scenes.PhaseOne;
import game.scenes.PhaseTwo;
import utils.Constants;
import utils.Music;
import utils.Physics;

public class Cena implements GLEventListener {

    public static GL2 gl;
    public static GLUT glut;

    public int tonalizacao = GL2.GL_SMOOTH;

    private Menu menu;
    private PhaseOne phaseOne;
    private PhaseTwo phaseTwo;
    private GameOver gameOver;

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        Physics.randomRunBall();
        menu = new Menu();
        phaseOne = new PhaseOne();
        phaseTwo = new PhaseTwo();
        gameOver = new GameOver();
        gl.glEnable(GL2.GL_DEPTH_TEST);
        Music.soundIntro();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glut = new GLUT();

        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        ligaLuz(gl);

        switch (Constants.phase) {
            case 0:
                menu.init();
                break;
            case 1:
                phaseOne.init();
                break;
            case 2:
                phaseTwo.init();
                break;
            case 3:
                gameOver.init();
                break;
        }

        gl.glFlush();
    }

    public void reset() {
        Constants.ballX = 0;
        Constants.ballY = 1f;
        Constants.yDirection = 'd';

        Constants.pause = false;
        Constants.phase = 0;

        Constants.move = 0;
        Constants.score = 0;
        Constants.lives = 5;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        Constants.aspect = (float) width / height;
        gl.glOrtho(-1, 1, -1, 1, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    public void iluminacaoAmbiente(GL2 gl) {
        float luzAmbiente[] = {0.2f, 0.2f, 0.2f, 1.0f}; //cor
        float posicaoLuz[] = {-50.0f, 0.0f, 100.0f, 1.0f}; //pontual

        // define parametros de luz de n�mero 0 (zero)
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, posicaoLuz, 0);
    }

    private void ligaLuz(GL2 gl) {
        gl.glEnable(GL2.GL_COLOR_MATERIAL);

        // habilita o uso da ilumina��o na cena
        gl.glEnable(GL2.GL_LIGHTING);
        // habilita a luz de n�mero 0
        gl.glEnable(GL2.GL_LIGHT0);
        //Especifica o Modelo de tonalizacao a ser utilizado 
        //GL_FLAT -> modelo de tonalizacao flat 
        //GL_SMOOTH -> modelo de tonaliza��o GOURAUD (default)        
        gl.glShadeModel(tonalizacao);
    }
}
