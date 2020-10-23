package utils;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {

    public static synchronized void soundHitBall() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    String workingDir = System.getProperty("user.dir");
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(workingDir + "\\audio\\batida.wav"));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    
    public static synchronized void soundIntro() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    String workingDir = System.getProperty("user.dir");
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(workingDir + "\\audio\\intro.wav"));
                    clip.open(inputStream);
                    FloatControl gainControl
                            = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-15.0f); // Reduce volume by 10 decibels.
                    
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    
    public static synchronized void soundLossLive() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    String workingDir = System.getProperty("user.dir");
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(workingDir + "\\audio\\lossLive.wav"));
                    clip.open(inputStream);
                    
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    
    public static synchronized void soundHitWall() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    String workingDir = System.getProperty("user.dir");
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(workingDir + "\\audio\\hitWall.wav"));
                    clip.open(inputStream);
                    
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
}
