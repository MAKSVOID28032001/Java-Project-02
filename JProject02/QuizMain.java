import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

class Quiz implements ActionListener {
	String[] questions = { "   1. Which river is considered the holiest in India?",
			"   2. What is the national flower of India?",
			"   3. In which year did India gain independence from British rule?",
			"   4. What is the capital city of India?",
			"   5. Which festival is known as the Festival of Lights in India?",
			"   6. Who wrote the Indian national anthem Jana Gana Mana?",
			"   7. Which Indian state is known as the Land of five rivers",
			"   8. The Indian Premier League is associated with which sport?",
			"   9. Which Indian scientist is known as the Missile Man Of India?",
			"   10. What is the currency of India?" };
	String[][] options = { { "Yamuna", "Ganga", "Indus", "Yamuna" }, { "Rose", "Lotus", "Jasmine", "Marigold" },
			{ "1921", "1821", "2000", "1947" }, { "Mumbai", "Bangalore", "Kolkata", "New Delhi" },
			{ "Diwali", "Holi", "Ram Navami", "Ratha Yatra" }, { "Gandhi", "Neheru", "Tagore", "Singh" },
			{ "Delhi", "Gujurat", "Punjab", "Mumbai" }, { "Football", "Cricket", "Hockey", "Tennis" },
			{ "A.P.J Abdul Kalam", "C.V. Raman", "Homi Bhabha", "Vikram Sarabhai" },
			{ "Rupee", "Dollar", "Pound", "Yuan" } };
	char[] answers = { 'B', 'B', 'D', 'D', 'A', 'C', 'C', 'B', 'A', 'A' };
	char guess, answer;
	int index, correctgusses = 0, totalquestions = questions.length, result, seconds = 10;

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttona = new JButton();
	JButton buttonb = new JButton();
	JButton buttonc = new JButton();
	JButton buttond = new JButton();

	JLabel answera = new JLabel();
	JLabel answerb = new JLabel();
	JLabel answerc = new JLabel();
	JLabel answerd = new JLabel();

	JLabel time = new JLabel();
	JLabel second = new JLabel();

	JTextField right = new JTextField();
	JTextField percentage = new JTextField();

	Timer timers = new Timer(2000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			second.setText(String.valueOf(seconds));
			if (seconds <= 0) {
				displayanswer();
			}
		}
	});

	Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Quiz App On Java Programming - Atish Kumar Sahu");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Atish kumar sahu\\eclipse-workspace\\Resume_Quiz_App_Project_In_Java\\src\\question.png"));
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
		frame.add(textfield);
		frame.add(textarea);
		frame.add(buttona);
		frame.add(buttonb);
		frame.add(buttonc);
		frame.add(buttond);
		frame.add(answera);
		frame.add(answerb);
		frame.add(answerc);
		frame.add(answerd);
		frame.add(second);
		frame.add(time);
		// frame.add(right);
		// frame.add(percentage);

		textfield.setBounds(0, 0, 1000, 100);
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.PLAIN, 40));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textfield.setText("Welcome To Quiz App");

		textarea.setBounds(50, 120, 870, 200);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(50, 50, 50));
		textarea.setForeground(new Color(25, 255, 0));
		textarea.setFont(new Font("MV Boli", Font.PLAIN, 35));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);

		buttona.setBounds(0, 400, 100, 100);
		buttona.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttona.setFocusable(false);
		buttona.addActionListener(this);
		buttona.setText("A");

		buttonb.setBounds(0, 500, 100, 100);
		buttonb.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonb.setFocusable(false);
		buttonb.addActionListener(this);
		buttonb.setText("B");

		buttonc.setBounds(0, 600, 100, 100);
		buttonc.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonc.setFocusable(false);
		buttonc.addActionListener(this);
		buttonc.setText("C");

		buttond.setBounds(0, 700, 100, 100);
		buttond.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttond.setFocusable(false);
		buttond.addActionListener(this);
		buttond.setText("D");

		answera.setBounds(125, 400, 500, 100);
		answera.setBackground(new Color(50, 50, 50));
		answera.setForeground(new Color(25, 255, 0));
		answera.setFont(new Font("MV Boli", Font.BOLD, 35));
		answera.setText("option1");

		answerb.setBounds(125, 500, 500, 100);
		answerb.setBackground(new Color(50, 50, 50));
		answerb.setForeground(new Color(25, 255, 0));
		answerb.setFont(new Font("MV Boli", Font.BOLD, 35));
		answerb.setText("option2");

		answerc.setBounds(125, 600, 500, 100);
		answerc.setBackground(new Color(50, 50, 50));
		answerc.setForeground(new Color(25, 255, 0));
		answerc.setFont(new Font("MV Boli", Font.BOLD, 35));
		answerc.setText("option3");

		answerd.setBounds(125, 700, 500, 100);
		answerd.setBackground(new Color(50, 50, 50));
		answerd.setForeground(new Color(25, 255, 0));
		answerd.setFont(new Font("MV Boli", Font.BOLD, 35));
		answerd.setText("option4");

		second.setBounds(800, 800, 100, 100);
		second.setBackground(new Color(25, 25, 25));
		second.setForeground(new Color(255, 0, 0));
		second.setFont(new Font("Ink Free", Font.BOLD, 50));
		second.setBorder(BorderFactory.createBevelBorder(1));
		second.setOpaque(true);
		second.setHorizontalAlignment(JTextField.CENTER);
		second.setText(String.valueOf(seconds));

		time.setBounds(700, 800, 100, 100);
		time.setBackground(new Color(50, 50, 50));
		time.setForeground(new Color(255, 0, 0));
		time.setFont(new Font("Ink Free", Font.BOLD, 30));
		time.setHorizontalAlignment(JTextField.CENTER);
		time.setText("Timer");

		right.setBounds(400, 400, 200, 100);
		right.setBackground(new Color(25, 25, 25));
		right.setForeground(new Color(25, 255, 0));
		right.setFont(new Font("MV Boli", Font.BOLD, 50));
		right.setBorder(BorderFactory.createBevelBorder(1));
		right.setHorizontalAlignment(JTextField.CENTER);
		right.setEditable(false);

		percentage.setBounds(400, 500, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		nextquestion();

	}

	public void nextquestion() {
		if (index >= totalquestions) {
			results();
		} else {
			textfield.setText("Questions " + (index + 1));
			textarea.setText(questions[index]);
			answera.setText(options[index][0]);
			answerb.setText(options[index][1]);
			answerc.setText(options[index][2]);
			answerd.setText(options[index][3]);
			timers.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buttona.setEnabled(false);
		buttonb.setEnabled(false);
		buttonc.setEnabled(false);
		buttond.setEnabled(false);

		if (e.getSource() == buttona) {
			answer = 'A';
			if (answer == answers[index]) {
				correctgusses++;
			}
		}
		if (e.getSource() == buttonb) {
			answer = 'B';
			if (answer == answers[index]) {
				correctgusses++;
			}
		}
		if (e.getSource() == buttonc) {
			answer = 'C';
			if (answer == answers[index]) {
				correctgusses++;
			}
		}
		if (e.getSource() == buttond) {
			answer = 'D';
			if (answer == answers[index]) {
				correctgusses++;
			}
		}
		displayanswer();

	}

	public void displayanswer() {
		timers.stop();
		buttona.setEnabled(false);
		buttonb.setEnabled(false);
		buttonc.setEnabled(false);
		buttond.setEnabled(false);
		if (answers[index] != 'A')
			answera.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'B')
			answerb.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'C')
			answerc.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'D')
			answerd.setForeground(new Color(255, 0, 0));
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answera.setForeground(new Color(25, 255, 0));
				answerb.setForeground(new Color(25, 255, 0));
				answerc.setForeground(new Color(25, 255, 0));
				answerd.setForeground(new Color(25, 255, 0));
				answer = ' ';
				seconds = 10;
				second.setText(String.valueOf(seconds));
				buttona.setEnabled(true);
				buttonb.setEnabled(true);
				buttonc.setEnabled(true);
				buttond.setEnabled(true);
				index++;
				nextquestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void results() {
		buttona.setEnabled(false);
		buttonb.setEnabled(false);
		buttonc.setEnabled(false);
		buttond.setEnabled(false);

		result = (int) ((correctgusses / (double) totalquestions) * 100);
		textfield.setText("Results");
		textarea.setText("");
		answera.setText("");
		answerb.setText("");
		answerc.setText("");
		answerd.setText("");

		right.setText(correctgusses + "/" + totalquestions);
		percentage.setText(result + "%");

		frame.add(right);
		frame.add(percentage);
	}
}

public class QuizMain {
	public static void main(String[] args) {
		Quiz q = new Quiz();
	}
}
