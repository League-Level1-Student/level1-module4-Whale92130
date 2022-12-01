package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class slotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JButton spin = new JButton("Spin");

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		slotMachine u = new slotMachine();
		u.run();
	}

	void run() throws MalformedURLException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spin.addActionListener(this);
		label1 = createLabelImage("limeicon.jpeg");
		label2 = createLabelImage("limeicon.jpeg");
		label3 = createLabelImage("limeicon.jpeg");
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		frame.add(panel);
		panel.add(spin);
		frame.setSize(700, 300);
		frame.setVisible(true);
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == spin) {
			Random r = new Random();
			int r1 = r.nextInt(3);
			int r2 = r.nextInt(3);
			int r3 = r.nextInt(3);
			frame.remove(panel);
			panel = new JPanel();
			label1=roll(r1);
			label2=roll(r2);
			label3=roll(r3);
			panel.add(label1);
			panel.add(label2);
			panel.add(label3);
			panel.add(spin);
			frame.add(panel);
			frame.pack();
			if (r1 == r2 && r2 == r3) {
				JOptionPane.showMessageDialog(null, "You Win~!");
			}
		}

	}

	JLabel roll(int ra) {
		JLabel label = new JLabel();
		try {

			
			if (ra == 0) {
				label = createLabelImage("github.png");
			} else if (ra == 1) {
				label = createLabelImage("findericon.jpeg");
			} else if (ra == 2) {
				label = createLabelImage("limeicon.jpeg");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return label;
	}
}
