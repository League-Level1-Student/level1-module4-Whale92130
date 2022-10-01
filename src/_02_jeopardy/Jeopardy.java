package _02_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton, fifthButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private Sound jeopardyThemeClip;



	public void run() {
		JFrame frame = new JFrame("Jeopardy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel panel = new JPanel();
		// 4. Add the header component to the quizPanel
		quizPanel.add(createHeader("Random Facts"));
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.
		
		// 9. Use the secondButton variable to hold a button using the createButton
		// method
			secondButton = createButton("400");
			thirdButton = createButton("600");
			fourthButton = createButton("800");
			fifthButton = createButton("1000");
		// 10. Add the secondButton to the quizPanel
			quizPanel.add(secondButton);
			quizPanel.add(thirdButton);
			quizPanel.add(fourthButton);
			quizPanel.add(fifthButton);
		// 11. Add action listeners to the buttons (2 lines of code)
			firstButton.addActionListener(this);
			secondButton.addActionListener(this);
			thirdButton.addActionListener(this);
			fourthButton.addActionListener(this);
			fifthButton.addActionListener(this);
		// 12. Write the code to complete the actionPerformed() method below
			
		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
		
		 /*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(String dollarAmount) {
		
		// Create a new JButton
		JButton button = new JButton(dollarAmount);
		// Set the text of the button to the dollarAmount

		// Increment the buttonCount (this should make the layout vertical)
		buttonCount++;
		// Return your new button instead of the temporary button

		return new JButton(dollarAmount);
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		
		// Remove this temporary message after testing:
		JOptionPane.showMessageDialog(null, "pressed " + ((JButton) e.getSource()).getText() + " button");

		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if(e.getSource() == firstButton) {
			askQuestion("How long is a pencil", "21", 200);
			firstButton.setText(null);
		}
		else if(e.getSource() == secondButton) {
			askQuestion("How do u code a button", "just code it", 400);
			secondButton.setText(null);
		}
		else if(e.getSource() == thirdButton) {
			askQuestion("How tall is the Orlando Post Office", "21", 600);
			thirdButton.setText(null);
		}
		else if(e.getSource() == fourthButton) {
			askQuestion("What is the name of the person credited with creating the world’s first car?", "Not Henry Ford", 800);
			fourthButton.setText(null);
		}
		else if(e.getSource() == fifthButton) {
			askQuestion("What is the largest country in EU", "Denmark", 1000);
			fifthButton.setText(null);
		}
			// Call the askQuestion() method
			
		// Complete the code in the askQuestion() method. When you play the game, the score should change.

		// If the buttonPressed was the secondButton

			// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		
		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
			playJeopardyTheme();
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String userAnswer = JOptionPane.showInputDialog(null, question);
		
		// Stop the theme music when they have entered their response.
			stopJeopardyTheme();
		// If the answer is correct
				if(userAnswer.equalsIgnoreCase(correctAnswer)) {
					score = prizeMoney + score;
					JOptionPane.showMessageDialog(null, "You got it right");
				}
				else {
					score = score - prizeMoney;
					JOptionPane.showMessageDialog(null, "Wrong");
					JOptionPane.showMessageDialog(null, correctAnswer);
				}
				updateScore();
			// Increase the score by the prizeMoney
					
			// Pop up a message to tell the user they were correct

		// Otherwise

			// Decrement the score by the prizeMoney

			// Pop up a message to tell the user they were wrong and give them the correct answer

		// Call the updateScore() method

	}

	public void playJeopardyTheme() {
		String fileName = "_02_jeopardy/jeopardy.wav";
		jeopardyThemeClip = new Sound(fileName);
		jeopardyThemeClip.play();
	}

	public void stopJeopardyTheme() {
		jeopardyThemeClip.stop();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
