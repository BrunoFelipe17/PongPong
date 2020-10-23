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
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(Constants.soundHitBall));
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
                            new File(Constants.soundIntro));
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
                            new File(Constants.soundLossLive));
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
                            new File(Constants.soundHitWall));
                    clip.open(inputStream);
                    
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
}
