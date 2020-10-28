package utils;

public class Constants {
    public static boolean pause =  false;
    public static int score = 0;
    public static int phase = 0;
    public static int lives = 5;
    public static float speed = 0.02f;
    public static float move = 0;
    public static float livesAnimation = 0;
    public static float aspect;
    public static float ballX = 0;
    public static float ballY = 1f;
    public static char xDirection;
    public static char yDirection = 'd';
    public static float leftBarLimit;
    public static float rightBarLimit;
    public static float angle;
    public static int totalTextures = 2;
    private static String workingDir = System.getProperty("user.dir");
    public static String soundHitBall = workingDir + "\\res\\audio\\batida.wav";
    public static String soundIntro = workingDir + "\\res\\audio\\intro.wav";
    public static String soundLossLive = workingDir + "\\res\\audio\\lossLive.wav";
    public static String soundHitWall = workingDir + "\\res\\audio\\hitWall.wav";
    public static String backgroundImage = workingDir + "\\res\\images\\BACKGROUND.jpg";
    public static String backgroundGameOver = workingDir + "\\res\\images\\BACKGROUND_GAMEOVER.jpg";
}
