package game.keyboard;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import game.Cena;
import game.Renderer;
import utils.Constants;

public class KeyBoard implements KeyListener, MouseListener {

    private final Cena cena;
    private int previousX = 0;

    public KeyBoard(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_A:
                if (Constants.move > -0.8 && !Constants.pause) {
                    Constants.move = Constants.move - 0.1f;
                }
                break;
            case KeyEvent.VK_D:
                if (Constants.move < 0.8 && !Constants.pause) {
                    Constants.move = Constants.move + 0.1f;
                }
                break;
            case KeyEvent.VK_P:
                Constants.pause = !Constants.pause;
                break;
            case KeyEvent.VK_ENTER:
                if (Constants.phase == 0) {
                    Constants.phase = 1;
                }
                break;
            case KeyEvent.VK_X:
                if (Constants.phase > 0) {
                    Constants.phase = 0;
                    cena.reset();
                }
                break;
            case KeyEvent.VK_Y:
                if (Constants.phase == 3) {
                    Constants.phase = 0;
                    cena.reset();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX() != 0) {
            if (e.getX() < previousX && Constants.move > -0.9) {
                Constants.move = Constants.move - 0.02f;
            } else if (e.getX() > previousX && Constants.move < 0.9) {
                Constants.move = Constants.move + 0.02f;
            }
        }
        previousX = e.getX();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {

    }

}
