package _06_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JButton button1 = new JButton("+");
	
	JButton button2 = new JButton("-");
	
	JButton button3 = new JButton("*");
	
	JButton button4 = new JButton("/");
	JTextField text1 = new JTextField("     ");
	JTextField text2 = new JTextField("     ");
	
	int a = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		cal.setup();
	}
	void setup() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button1.setPreferredSize(new Dimension(140,30));
		button2.setPreferredSize(new Dimension(140,30));
		button3.setPreferredSize(new Dimension(140,30));
		button4.setPreferredSize(new Dimension(140,30));
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			double textint1 = Double.parseDouble(text1.getText());
			double textint2 = Double.parseDouble(text2.getText());
			double a = textint1 + textint2;
			String at = a + "";
			label.setText(at);
		}
		else if(e.getSource() == button2) {
			double textint1 = Double.parseDouble(text1.getText());
			double textint2 = Double.parseDouble(text2.getText());
			double a = textint1 - textint2;
			String at = a + "";
			label.setText(at);
		}
		else if(e.getSource() == button3) {
			double textint1 = Double.parseDouble(text1.getText());
			double textint2 = Double.parseDouble(text2.getText());
			double a = textint1 * textint2;
			String at = a + "";
			label.setText(at);
		}
		else if(e.getSource() == button4) {
			double textint1 = Double.parseDouble(text1.getText());
			double textint2 = Double.parseDouble(text2.getText());
			double a = textint1 / textint2;
			String at = a + "";
			label.setText(at);
		}
		
	}

}
