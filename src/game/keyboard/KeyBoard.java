package game.keyboard;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import game.Cena;
import utils.Constants;

public class KeyBoard implements KeyListener{
    private final Cena cena;
    
    public KeyBoard(Cena cena){
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
    public void keyReleased(KeyEvent e) { }
    
    
}
