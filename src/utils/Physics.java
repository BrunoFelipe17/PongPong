package utils;

import java.util.Locale;

public class Physics {

    private static boolean touchedTheBar(float ballX) {
        Constants.leftBarLimit = Float.parseFloat(String.format(Locale.US, "%.1f", Constants.move - 0.2f));
        Constants.rightBarLimit = Float.parseFloat(String.format(Locale.US, "%.1f", Constants.move + 0.2f));
        return Constants.leftBarLimit <= ballX && Constants.rightBarLimit >= ballX;

    }

    private static boolean limitY(float x, float y, float xPoint) {

        return 0.5f >= y && -0.1f <= y && x == xPoint;
    }

    private static boolean limitX(float obj, float heightObj, float tLimit) {
        return -0.2f <= obj && 0.2f >= obj && heightObj == tLimit;
    }

    public static void runEngine() {
        float xTransBallFixed = Float.parseFloat(String.format(Locale.US, "%.1f", Constants.ballX));
        float yTransBallFixed = Float.parseFloat(String.format(Locale.US, "%.1f", Constants.ballY));

        if (Constants.phase == 2 && Constants.xDirection == 'l'
                && limitY(xTransBallFixed, yTransBallFixed, 0.2f)) {
            Constants.xDirection = 'r';
//            System.out.println("bati 1");
            Music.soundHitWall();
        }

        // LADO ESQUERDO OBSTACULO
        if (Constants.phase == 2 && Constants.xDirection == 'r'
                && limitY(xTransBallFixed, yTransBallFixed, -0.2f)) {
            Constants.xDirection = 'l';
//            System.out.println("bati 2");
            Music.soundHitWall();

        } else if (xTransBallFixed > -1f && Constants.xDirection == 'l') {
            Constants.ballX -= Constants.speed / 2;

        } else if (xTransBallFixed == -1f && Constants.xDirection == 'l') {
            // COLISÃO LADO ESQUERDO DA TELA
            Music.soundHitWall();
            Constants.xDirection = 'r';
        } else if (xTransBallFixed < 1f && Constants.xDirection == 'r') {
            Constants.ballX += Constants.speed / 2;

        } else if (xTransBallFixed == 1f && Constants.xDirection == 'r') {
            // COLISÃO LADO DIREITO DA TELA
            Music.soundHitWall();
            Constants.xDirection = 'l';
        }

        if (Constants.phase == 2 && Constants.yDirection == 'u'
                && limitX(xTransBallFixed, yTransBallFixed, -0.2f)) {
            Constants.yDirection = 'd';
            // BAIXO OBSTACULO
//            System.out.println("bati 3");
            Music.soundHitWall();
        } else if (Constants.phase == 2 && Constants.yDirection == 'd'
                && limitX(xTransBallFixed, yTransBallFixed, 0.2f)) {
            // TOPO OBSTACULO
            System.out.println("bati 4");
            Music.soundHitWall();
            Constants.yDirection = 'u';
        } else if (yTransBallFixed == -0.7f && Constants.yDirection == 'd'
                && touchedTheBar(xTransBallFixed)) {
            Constants.yDirection = 'u';
            Constants.score += 20;
            Music.soundHitBall();
        } else if (yTransBallFixed < 0.9f && Constants.yDirection == 'u') {
            Constants.ballY += Constants.speed;
        } else if (yTransBallFixed == 0.9f && Constants.yDirection == 'u') {
            Constants.yDirection = 'd';
            Music.soundHitWall();
        } else if (yTransBallFixed < -1f) {
            Constants.ballY = 1f;
            Constants.ballX = 0;
            Constants.lives--;
            Music.soundLossLive();
            randomRunBall();
        } else {
            Constants.ballY -= Constants.speed;
        }
    }

    public static void randomRunBall() {
        double xRandom = -0.8f + Math.random() * 1.6f;
        if (xRandom > 0) {
            Constants.xDirection = 'r';
        } else {
            Constants.xDirection = 'l';
        }
        Constants.ballX = Float.parseFloat(String.format(Locale.US, "%.2f", xRandom));
    }
}
