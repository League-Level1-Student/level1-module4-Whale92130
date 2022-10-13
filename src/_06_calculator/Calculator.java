package _06_calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JButton button1 = new JButton("+");
		//button1.addActionListener(this);
		JButton button2 = new JButton("-");
		JButton button3 = new JButton("*");
		JButton button4 = new JButton("/");
		JTextField text1 = new JTextField("1st num");
		JTextField text2 = new JTextField("2nd num");
		
		panel.add(text1);
		panel.add(text2);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(label);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.resize(150, 300);
		
	}

}
