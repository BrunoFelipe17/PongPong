package utils;

import com.jogamp.opengl.GL2;
import static game.Cena.gl;
import static game.Cena.glut;

public class Drawing {

    
    public static void obstacle() {
        gl.glPushMatrix();
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1, 1, 1);
        gl.glVertex2f(-0.2f, 0.2f);
        gl.glVertex2f(0.2f, 0.2f);
        gl.glVertex2f(0.2f, -0.1f);
        gl.glVertex2f(-0.2f, -0.1f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    public static void bar(Float r, Float g, Float b) {
        gl.glPushMatrix();
        gl.glColor3f(r, g, b);
        gl.glTranslatef(Constants.move, 0, 0);
        gl.glBegin(GL2.GL_QUADS);
        
        gl.glVertex2f(-0.2f, -0.8f);
        gl.glVertex2f(0.2f, -0.8f);
        gl.glVertex2f(0.2f, -0.9f);
        gl.glVertex2f(-0.2f, -0.9f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    public static void ball() {
        gl.glPushMatrix();
        gl.glTranslatef(Constants.ballX, Constants.ballY, 0);
        gl.glColor3f(1, 1, 1);

        double limit = 2 * Math.PI;
        double i;
        double cX = 0;
        double cY = 0;
        double rX = 0.07f / Constants.aspect;
        double rY = 0.07f;

        gl.glBegin(GL2.GL_POLYGON);
        for (i = 0; i < limit; i += 0.01) {
            gl.glVertex2d(cX + rX * Math.cos(i), cY + rY * Math.sin(i));
        }
        gl.glEnd();

        gl.glPopMatrix();
    }
}
