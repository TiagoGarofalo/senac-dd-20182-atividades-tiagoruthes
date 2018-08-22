package aula06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 424, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSoma = new JButton("+");
		btnSoma.setBounds(340, 51, 89, 23);
		contentPane.add(btnSoma);
		
		JButton btnSubtra = new JButton("-");
		btnSubtra.setBounds(340, 85, 89, 23);
		contentPane.add(btnSubtra);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setBounds(340, 150, 89, 23);
		contentPane.add(btnDiv);
		
		JButton btnMult = new JButton("*");
		btnMult.setBounds(340, 116, 89, 23);
		contentPane.add(btnMult);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(10, 51, 89, 23);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(109, 51, 89, 23);
		contentPane.add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(109, 85, 89, 23);
		contentPane.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(10, 85, 89, 23);
		contentPane.add(btn4);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(208, 51, 89, 23);
		contentPane.add(btn9);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(10, 116, 89, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(109, 116, 89, 23);
		contentPane.add(btn2);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(208, 85, 89, 23);
		contentPane.add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(208, 116, 89, 23);
		contentPane.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(109, 150, 89, 23);
		contentPane.add(btn0);
		
		JButton btnResult = new JButton("=");
		btnResult.setBounds(340, 227, 89, 23);
		contentPane.add(btnResult);
	}
}
