package game.scenes;

import game.Renderer;
import utils.Music;
import utils.Text;

public class Menu {
    
    public void init() {
        
        Text.draw(
                "PONG GAME",
                100,
                (Renderer.getScreenWidth() / 2) - 200,
                (Renderer.getScreenHeight() / 2) + 100);
        
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
                (Renderer.getScreenHeight() / 2) );
        
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
}
