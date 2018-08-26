package aula06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

	protected static final String OPERACAO_SOMA = "+";
	protected static final String OPERACAO_SUB = "-";
	protected static final String OPERACAO_MULT = "*";
	protected static final String OPERACAO_DIV = "/";
	private JPanel contentPane;
	private JTextField txtCampoDigitacao;
	private double valor1;
	private double valor2;
	private String  operacao;
	public double getValor1() {
		return valor1;
	}

	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public double getValor2() {
		return valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	private double resultado;

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

		txtCampoDigitacao = new JTextField();
		txtCampoDigitacao.setBounds(5, 5, 424, 20);
		contentPane.add(txtCampoDigitacao);
		txtCampoDigitacao.setColumns(10);

		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guarda o primeiro valor digitado
				setValor1( Double.parseDouble(txtCampoDigitacao.getText()));

				//Limpar o campo de valor digitado
				txtCampoDigitacao.setText("");

				setOperacao(OPERACAO_SOMA);
				}
		});
		btnSoma.setBounds(340, 51, 89, 23);
		contentPane.add(btnSoma);

		JButton btnSubtra = new JButton("-");
		btnSubtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guarda o primeiro valor digitado
				setValor1( Double.parseDouble(txtCampoDigitacao.getText()));

				//Limpar o campo de valor digitado
				txtCampoDigitacao.setText("");

				setOperacao(OPERACAO_SUB);
				}
		});
		btnSubtra.setBounds(340, 85, 89, 23);
		contentPane.add(btnSubtra);

		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guarda o primeiro valor digitado
				setValor1( Double.parseDouble(txtCampoDigitacao.getText()));

				//Limpar o campo de valor digitado
				txtCampoDigitacao.setText("");

				setOperacao(OPERACAO_DIV);
				}
		});
		btnDiv.setBounds(340, 150, 89, 23);
		contentPane.add(btnDiv);

		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guarda o primeiro valor digitado
				setValor1( Double.parseDouble(txtCampoDigitacao.getText()));

				//Limpar o campo de valor digitado
				txtCampoDigitacao.setText("");

				setOperacao(OPERACAO_MULT);
				}
		});
		btnMult.setBounds(340, 116, 89, 23);
		contentPane.add(btnMult);

		JButton btnResult = new JButton("=");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValor2(Double.parseDouble((txtCampoDigitacao.getText())));

                String operacaoAtual = getOperacao();
				switch (operacaoAtual) {
				case OPERACAO_SOMA:
					resultado = getValor1()+getValor2();
					break;
				case OPERACAO_SUB:
					resultado = getValor1()-getValor2();
					break;
				case OPERACAO_MULT:
					resultado = getValor1()*getValor2();
					break;
				case OPERACAO_DIV:
					resultado = getValor1()/getValor2();
					break;
				default:
					break;
				}

				txtCampoDigitacao.setText(resultado + "");
			}
		});
		btnResult.setBounds(340, 227, 89, 23);
		contentPane.add(btnResult);

		JButton btnClear = new JButton("CE");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = "";
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btnClear.setBounds(340, 181, 89, 23);
		contentPane.add(btnClear);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 1;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn1.setBounds(10, 116, 89, 23);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() +2;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn2.setBounds(109, 116, 89, 23);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 3;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn3.setBounds(208, 116, 89, 23);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 4;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn4.setBounds(10, 85, 89, 23);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 5;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn5.setBounds(109, 85, 89, 23);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 6;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn6.setBounds(208, 85, 89, 23);
		contentPane.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 7;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn7.setBounds(10, 51, 89, 23);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 8;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn8.setBounds(109, 51, 89, 23);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 9;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn9.setBounds(208, 51, 89, 23);
		contentPane.add(btn9);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorTela = txtCampoDigitacao.getText() + 0;
				txtCampoDigitacao.setText(valorTela);
			}
		});
		btn0.setBounds(109, 150, 89, 23);
		contentPane.add(btn0);
	}
}
