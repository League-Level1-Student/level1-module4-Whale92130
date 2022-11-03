package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Whack_a_mole implements ActionListener {
	int moleswhacked=0;
	Date start;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Whack_a_mole mole = new Whack_a_mole();
		mole.run();
	}
	
	void run() {
		start = new Date();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Random r = new Random();
		 int ra = r.nextInt(24)+1;
		 
		JPanel panel = new JPanel();
		for (int i =0; i < 24; i++) {
			String a = "";
			if(i==ra) {
				a = "mole";
				
			}
			JButton a1 = new JButton(a);
			a1.addActionListener(this);
			panel.add(a1);

			
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.resize(250, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		if(b.getText() == "mole") {
			moleswhacked++;
			run();
		}
		else {
			speak("that is not a mole");
		}
		if(moleswhacked == 10) {
			endGame(start,moleswhacked);
		}
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	    System.exit(0);
	}
	   static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }


}
