package game;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import game.keyboard.KeyBoard;

public class Renderer {

    private static GLWindow window = null;
    private static int screenWidth = 0;
    private static int screenHeight = 0;

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static void init() {
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        GLWindow window = GLWindow.create(caps);
        window.setResizable(false);

        Cena cena = new Cena();
        window.addGLEventListener(cena);
        window.addKeyListener(new KeyBoard(cena));
        window.addMouseListener(new KeyBoard(cena));
        //window.requestFocus();
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }
        });
        window.setFullscreen(true);
        window.setVisible(true);
        screenWidth = window.getWidth();
        screenHeight = window.getHeight();
    }

    public static void main(String[] args) {
        init();
    }
}
