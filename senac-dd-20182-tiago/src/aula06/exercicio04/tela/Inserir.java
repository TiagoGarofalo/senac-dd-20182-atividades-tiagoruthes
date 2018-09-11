package aula06.exercicio04.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inserir extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCPF;
	private JTextField txfPesquisar;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
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
	public Inserir() {
		setTitle("Inserir Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInserirFunc = new JLabel("Inserir Funcionário");
		lbInserirFunc.setBounds(5, 5, 150, 14);
		contentPane.add(lbInserirFunc);
		
		txfNome = new JTextField();
		txfNome.setBounds(56, 100, 259, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lbnome = new JLabel("Nome");
		lbnome.setBounds(5, 100, 46, 14);
		contentPane.add(lbnome);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setBounds(5, 134, 46, 14);
		contentPane.add(lbCPF);
		
		txfCPF = new JTextField();
		txfCPF.setBounds(56, 131, 259, 20);
		contentPane.add(txfCPF);
		txfCPF.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setBounds(247, 161, 69, 23);
		contentPane.add(btSalvar);
		
		txfPesquisar = new JTextField();
		txfPesquisar.setBounds(87, 35, 143, 20);
		contentPane.add(txfPesquisar);
		txfPesquisar.setColumns(10);
		
		JLabel lbPesquisar = new JLabel("Pesquisar CPF");
		lbPesquisar.setBounds(5, 38, 72, 14);
		contentPane.add(lbPesquisar);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btPesquisar.setBounds(236, 34, 79, 23);
		contentPane.add(btPesquisar);
		
		textField = new JTextField();
		textField.setBounds(56, 69, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbmatricula = new JLabel("Matricula");
		lbmatricula.setBounds(5, 72, 46, 14);
		contentPane.add(lbmatricula);
	}
}
