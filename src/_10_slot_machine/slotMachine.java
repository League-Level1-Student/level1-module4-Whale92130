package _10_slot_machine;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class slotMachine {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		slotMachine u = new slotMachine();
		u.run();
	}
	void run() throws MalformedURLException {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		label1 = createLabelImage("finder.png");
		label2 = createLabelImage("finder.png");
		label3 = createLabelImage("finder.png");
		panel.add(label1);
		frame.add(panel);
		frame.setSize(600, 300);
		frame.setVisible(true);
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}

}
