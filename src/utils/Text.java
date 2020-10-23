package utils;

import game.Renderer;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Color;
import java.awt.Font;
public class Text {
    private static TextRenderer textRenderer;
    
    public static void draw(String text, int size, int x, int y) {
        Font f = new Font("Arial", Font.PLAIN, size);
        TextRenderer textRenderer = new TextRenderer(f);
        textRenderer.beginRendering(Renderer.getScreenWidth(), Renderer.getScreenHeight());
        textRenderer.setColor(Color.WHITE);
        textRenderer.draw(text, x, y);
        textRenderer.endRendering();
    }
}
