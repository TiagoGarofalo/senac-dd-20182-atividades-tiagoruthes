package aula06.exercicio04.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Inserir extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCPF;
	private JTextField txfPesquisar;

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
		txfNome.setBounds(44, 100, 259, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lbnome = new JLabel("Nome");
		lbnome.setBounds(5, 100, 46, 14);
		contentPane.add(lbnome);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setBounds(5, 134, 46, 14);
		contentPane.add(lbCPF);
		
		txfCPF = new JTextField();
		txfCPF.setBounds(44, 131, 259, 20);
		contentPane.add(txfCPF);
		txfCPF.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setBounds(234, 162, 69, 23);
		contentPane.add(btSalvar);
		
		txfPesquisar = new JTextField();
		txfPesquisar.setBounds(87, 35, 130, 20);
		contentPane.add(txfPesquisar);
		txfPesquisar.setColumns(10);
		
		JLabel lbPesquisar = new JLabel("Pesquisar CPF");
		lbPesquisar.setBounds(5, 38, 72, 14);
		contentPane.add(lbPesquisar);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.setBounds(224, 34, 79, 23);
		contentPane.add(btPesquisar);
	}
}
