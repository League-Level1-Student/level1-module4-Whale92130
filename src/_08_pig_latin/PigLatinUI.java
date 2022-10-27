package _08_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game_tools.Sound;

public class PigLatinUI implements ActionListener {
	JFrame frame = new JFrame();
	JTextField text = new JTextField("English", 20);
	JTextField text2 = new JTextField("ig-Pay atin-Lay", 20);
	JButton button = new JButton(">>");
	JButton button2 = new JButton("<<");
	JButton speak = new JButton("speak");
	JPanel panel = new JPanel();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PigLatinUI sffs = new PigLatinUI();
		sffs.run();
	}
	void run() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
		button2.addActionListener(this);
		speak.addActionListener(this);
		panel.add(text);
		panel.add(button);
		panel.add(button2);
		panel.add(text2);
		panel.add(speak);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PigLatinTranslator tran = new PigLatinTranslator();
		if(e.getSource() == button) {
			text2.setText(tran.translateEnglishToPigLatin(text.getText()));
		}
		if(e.getSource() == button2) {
			text.setText(tran.translatePigLatinToEnglish(text2.getText()));
			
		}
		if(e.getSource() == speak) {
			Sound.speak(text2.getText());
		}
	}

}
