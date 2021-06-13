import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Frame extends JFrame {
	JTextField txtNumbers;
	ArrayList<JButton> numberButtons = new ArrayList<>();
	ArrayList<JButton> functionButtons = new ArrayList<>();
	ArrayList<JButton> otherButtons = new ArrayList<>();
	ArrayList<JButton> clearButtons = new ArrayList<>();
	double num1;
	double num2;
	double sum;
	String operator;


	public Frame() {
		setLayout(null);

		// panel result properties
		JPanel panelResult = new JPanel();
		panelResult.setLayout(null);
		panelResult.setBounds(0, 0, 348, 150);
		panelResult.setBackground(new Color(43, 43, 43));
		panelResult.setOpaque(true);

		// panel button properties
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(5, 4, 2, 2));
		panelButtons.setBounds(0, 150, 335, 312);
		panelButtons.setBackground(new Color(43, 43, 43));
		panelButtons.setOpaque(true);

		// adding components to panel result
		JLabel lblResult = new JLabel("", SwingConstants.RIGHT);
		lblResult.setBounds(0, 20, 332, 30);
		lblResult.setForeground(Color.GRAY);
		lblResult.setFont(new Font("Arial", Font.PLAIN, 18));
		panelResult.add(lblResult);

		JLabel lblNumbers = new JLabel("", SwingConstants.RIGHT);
		lblNumbers.setBounds(0, 30, 332, 100);
		lblNumbers.setForeground(Color.WHITE);
		lblNumbers.setFont(new Font("Arial", Font.PLAIN, 50));

		panelResult.add(lblNumbers);

		// adding components to panel button
		JButton btnPercent = new JButton("%");
		panelButtons.add(btnPercent);
		functionButtons.add(btnPercent);
		btnPercent.setSize(new Dimension(50, 50));

		// adding clear all button and it's Action
		JButton btnClearAll = new JButton("CE");
		panelButtons.add(btnClearAll);
		clearButtons.add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNumbers.setText("");
				lblResult.setText("");
			}
		});

		// adding button to clear only one character and it's action
		JButton btnClearOneNumber = new JButton("X");
		panelButtons.add(btnClearOneNumber);
		clearButtons.add(btnClearOneNumber);
		btnClearOneNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lblNumbers.getText().length() > 0) {
					String text = "";
					int length = lblNumbers.getText().length();
					text = lblNumbers.getText().substring(0, length - 1);
					lblNumbers.setText(text);
				}
			}
		});

		// adding other buttons
		JButton btnDivision = new JButton("÷");
		panelButtons.add(btnDivision);
		functionButtons.add(btnDivision);

		JButton btnSeven = new JButton("7");
		panelButtons.add(btnSeven);
		numberButtons.add(btnSeven);

		JButton btnEight = new JButton("8");
		panelButtons.add(btnEight);
		numberButtons.add(btnEight);

		JButton btnNine = new JButton("9");
		panelButtons.add(btnNine);
		numberButtons.add(btnNine);

		JButton btnMultiplication = new JButton("×");
		panelButtons.add(btnMultiplication);
		functionButtons.add(btnMultiplication);

		JButton btnFour = new JButton("4");
		panelButtons.add(btnFour);
		numberButtons.add(btnFour);

		JButton btnFive = new JButton("5");
		panelButtons.add(btnFive);
		numberButtons.add(btnFive);

		JButton btnSix = new JButton("6");
		panelButtons.add(btnSix);
		numberButtons.add(btnSix);

		JButton btnSubtraction = new JButton("-");
		panelButtons.add(btnSubtraction);
		functionButtons.add(btnSubtraction);

		JButton btnOne = new JButton("1");
		panelButtons.add(btnOne);
		numberButtons.add(btnOne);

		JButton btnTwo = new JButton("2");
		panelButtons.add(btnTwo);
		numberButtons.add(btnTwo);

		JButton btnThree = new JButton("3");
		panelButtons.add(btnThree);
		numberButtons.add(btnThree);

		JButton btnAddition = new JButton("+");
		panelButtons.add(btnAddition);
		functionButtons.add(btnAddition);

		JButton btnPlusMinus = new JButton("+/-");
		panelButtons.add(btnPlusMinus);
		otherButtons.add(btnPlusMinus);

		JButton btnZero = new JButton("0");
		panelButtons.add(btnZero);
		numberButtons.add(btnZero);

		JButton btnComma = new JButton(",");
		panelButtons.add(btnComma);
		otherButtons.add(btnComma);

		JButton btnEqual = new JButton("=");
		panelButtons.add(btnEqual);
		functionButtons.add(btnEqual);

		// adding some properties for number buttons and action listener
		for (JButton button : numberButtons) {
			button.setFocusable(false);
			button.setBackground(Color.BLACK);
			button.setForeground(Color.white);
			button.setBorder(null);
			button.setFont(new Font("Arial", Font.BOLD, 18));

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(new Color(43, 43, 43));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(Color.BLACK);
				}
			});

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lblNumbers.setText(lblNumbers.getText().concat(button.getText()));
				}
			});
		}

		// adding some properties and action listener to function buttons
		for (JButton button : functionButtons) {
			button.setFocusable(false);
			button.setBackground(new Color(20, 20, 20));
			button.setForeground(Color.white);
			button.setBorder(null);
			button.setFont(new Font("Arial", Font.PLAIN, 25));

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(new Color(70, 70, 70));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(new Color(20, 20, 20));
				}
			});

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// checking that number must be not empty
					if (!lblNumbers.getText().equals("")) {
						// specifying operators
						if (e.getSource() == btnAddition) {
							num1 = Double.parseDouble(lblNumbers.getText());
							lblResult.setText(num1 + "+");
							operator = "+";
							lblNumbers.setText("");
						}
						if (e.getSource() == btnSubtraction) {
							num1 = Double.parseDouble(lblNumbers.getText());
							lblResult.setText(String.valueOf(num1 + "-"));
							operator = "-";
							lblNumbers.setText("");
						}
						if (e.getSource() == btnMultiplication) {
							num1 = Double.parseDouble(lblNumbers.getText());
							lblResult.setText(String.valueOf(num1 + "×"));
							operator = "×";
							lblNumbers.setText("");
						}
						if (e.getSource() == btnDivision) {
							num1 = Double.parseDouble(lblNumbers.getText());
							lblResult.setText(String.valueOf(num1 + "÷"));
							operator = "÷";
							lblNumbers.setText("");
						}
						// percent operation
						if (e.getSource() == btnPercent) {
							if (!lblNumbers.getText().equals("")) {
								lblNumbers.setText((Double.parseDouble(lblNumbers.getText()) / 100) + "");
							}
						}
					}

					// other four arithmetic operations
					if (e.getSource() == btnEqual) {
						if (!lblNumbers.getText().equals("") && !lblResult.getText().equals("")) {
							num2 = Double.parseDouble(lblNumbers.getText());
							switch (operator) {
								case "+":
									sum = num1 + num2;
									break;
								case "-":
									sum = num1 - num2;
									break;
								case "×":
									sum = num1 * num2;
									break;
								case "÷":
									sum = num1 / num2;
									break;
								case "%":
									sum = num1 / 100;
									break;
							}
							lblResult.setText(String.valueOf(sum));
							lblNumbers.setText(String.valueOf(sum));
							num1 = sum;
						}
					}


				}

			});
		}

		// adding some properties (style) for clear buttons
		for (JButton button : clearButtons) {
			button.setFocusable(false);
			button.setBackground(new Color(20, 20, 20));
			button.setForeground(Color.white);
			button.setBorder(null);
			button.setFont(new Font("Arial", Font.PLAIN, 18));

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(new Color(70, 70, 70));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(new Color(20, 20, 20));
				}
			});
		}

		// adding some properties and action listener to other buttons like ,
		for (JButton button : otherButtons) {
			button.setFocusable(false);
			button.setBackground(Color.black);
			button.setForeground(Color.white);
			button.setBorder(null);
			button.setFont(new Font("Arial", Font.PLAIN, 18));

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(new Color(43, 43, 43));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(Color.BLACK);
				}
			});

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (button.getText().equals(",") && !lblNumbers.getText().contains(".")) {
						lblNumbers.setText(lblNumbers.getText() + ".");
					} else if (button.getText().equals("+/-")) {
						if (Double.parseDouble(lblNumbers.getText()) > 0) {
							lblNumbers.setText("-" + lblNumbers.getText());
						} else {
							lblNumbers.setText(lblNumbers.getText().substring(1));
						}
					}
				}
			});
		}

		// adding properties and action listener to equal button
		btnEqual.setFocusable(false);
		btnEqual.setBackground(new Color(28, 76, 116));
		btnEqual.setForeground(Color.white);
		btnEqual.setBorder(null);
		btnEqual.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEqual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEqual.setBackground(new Color(46, 125, 190));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEqual.setBackground(new Color(28, 76, 116));
			}
		});
		btnPercent.setFont(new Font("Arial", Font.PLAIN, 18));

		// finally adding panels to Frame
		add(panelResult);
		add(panelButtons);

		// setting properties for frame
		setTitle("Calculator");
		setSize(350, 498);
		getContentPane().setBackground(new Color(43, 43, 43));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
