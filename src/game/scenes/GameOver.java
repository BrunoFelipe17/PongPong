package game.scenes;

import game.Renderer;
import utils.Text;

public class GameOver {
    
    public void init() {
        Text.draw(
                "Game over!!",
                100,
                (Renderer.getScreenWidth() / 2 - 300),
                (Renderer.getScreenHeight() / 2)
        );
    }
}
