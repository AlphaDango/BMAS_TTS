package de.neumann.audioPlayer;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    public static synchronized void playSound(final String sentence) {
        new Thread(new Runnable() {
            public void run() {
                String[] filenames = sentence.split(" ");
                for(String filename:filenames){
                    try {
                        File soundFile = new File("L:\\Users\\dango\\IdeaProjects\\BMAS_TTS\\src\\main\\resources\\soundfiles\\"+filename+".wav");
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(soundFile));
                        clip.start();

                        Thread.sleep(clip.getMicrosecondLength()/1000);
                    } catch (LineUnavailableException | UnsupportedAudioFileException | InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e){
                        System.err.println(filename + ".wav not found.");
                    }
                }

            }
        }).start();
    }
}