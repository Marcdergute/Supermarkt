package StorePanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static warenkorb.Functions.dailyIncome;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
public class PopUpDialog{
	
	static Clip clip;
    public PopUpDialog(int pane){
    
    	if(pane == 0) {
        	JDialog incomePane = new JDialog();
        	incomePane.setTitle("Daily Income");
        	incomePane.setSize(300,200);
        	incomePane.setModal(true);
        	incomePane.setLocationRelativeTo(null);
        	incomePane.add(new JLabel("The Daily Income is: "+ Double.toString(dailyIncome)+"€"));
        	incomePane.setVisible(true);
    	}else {
    		JDialog RickRollPane = new JDialog();
    		ImageIcon Rick = null;
    		URL imgURL = StorePanel.class.getResource("/icon/rick-roll.gif");
    		if (imgURL != null) {
    	         Rick = new ImageIcon(imgURL);   	         
    	      } else {
    	         JOptionPane.showMessageDialog(RickRollPane, "Icon image not found.");
    	      }
    		try {
    	         // Open an audio input stream.
    	        URL url = StorePanel.class.getResource("/icon/Never Gonna Give You Up.wav");
    	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
    	         // Get a sound clip resource.
    	        clip = AudioSystem.getClip();
    	         // Open audio clip and load samples from the audio input stream.
    	        clip.open(audioIn);
    	        clip.loop(pane);
    	    } catch (UnsupportedAudioFileException e) {
    	        System.out.println("Unsupported");
    	    } catch (IOException e) {
    	    	System.out.println("IO");
    	    } catch (LineUnavailableException e) {
    	    	System.out.println("Line unavailable");
    	    }
    		RickRollPane.addWindowListener(new WindowAdapter() {
    		  public void windowClosed(WindowEvent e){
    		    System.out.println("jdialog window closed event received");
    		  }

    		  public void windowClosing(WindowEvent e){
    		    clip.stop();
    		  }
    		});
        	RickRollPane.setTitle("Version 1.1.0");
        	RickRollPane.setSize(640,480);
        	RickRollPane.setModal(true);
        	RickRollPane.setLocationRelativeTo(null);
        	RickRollPane.add(new JLabel(Rick, JLabel.CENTER));
        	RickRollPane.setVisible(true);
        	
    	}
    }
}
