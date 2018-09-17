package aula06.exercicio04.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aula06.exercicio04.BO.FuncionarioBO;
import aula06.exercicio04.DAO.FuncionarioDAO;
import aula06.exercicio04.VO.FuncionarioVO;
import aula06.exercicio04.controller.FuncionarioController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inserir extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCPF;
	private JTextField txfPesquisar;
	private JTextField textMat;

	private FuncionarioVO funcionario = new FuncionarioVO();
	private FuncionarioBO bo = new FuncionarioBO();

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
		lbInserirFunc.setBounds(22, 5, 150, 14);
		contentPane.add(lbInserirFunc);

		txfNome = new JTextField();
		txfNome.setBounds(91, 112, 279, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);

		JLabel lbnome = new JLabel("Nome");
		lbnome.setBounds(22, 112, 46, 14);
		contentPane.add(lbnome);

		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setBounds(22, 145, 46, 14);
		contentPane.add(lbCPF);

		txfCPF = new JTextField();
		txfCPF.setBounds(91, 143, 279, 20);
		contentPane.add(txfCPF);
		txfCPF.setColumns(10);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FuncionarioController controlador = new FuncionarioController();
				FuncionarioVO funcionario = construirFuncionario();

				String mensagem = controlador.salvar(funcionario);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}

			private void limparTela() {

				funcionario = new FuncionarioVO();
				txfNome.setText("");
				txfCPF.setText("");
				textMat.setText("");

			}
		});
		btSalvar.setBounds(270, 173, 100, 23);
		contentPane.add(btSalvar);

		txfPesquisar = new JTextField();
		txfPesquisar.setBounds(116, 35, 143, 20);
		contentPane.add(txfPesquisar);
		txfPesquisar.setColumns(10);

		JLabel lbPesquisar = new JLabel("Pesquisar CPF");
		lbPesquisar.setBounds(22, 37, 89, 14);
		contentPane.add(lbPesquisar);

		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				
				funcionario = bo.pesquisarPorCPF(txfPesquisar.getText());
				txfNome.setText(funcionario.getNome());
				textMat.setText(funcionario.getNumeroMatricula());
				txfCPF.setText(funcionario.getCpf());
			}
		});
		btPesquisar.setBounds(270, 34, 100, 23);
		contentPane.add(btPesquisar);

		textMat = new JTextField();
		textMat.setBounds(91, 81, 279, 20);
		contentPane.add(textMat);
		textMat.setColumns(10);

		JLabel lbmatricula = new JLabel("Matricula");
		lbmatricula.setBounds(22, 81, 70, 14);
		contentPane.add(lbmatricula);

		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FuncionarioController controlador = new FuncionarioController();
				FuncionarioVO funcionario = construirFuncionario();

				String mensagem = controlador.atualizar(funcionario);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				
			}

			private void limparTela() {

					funcionario = new FuncionarioVO();
					txfNome.setText("");
					txfCPF.setText("");
					textMat.setText("");

				}
				
		});
		btAtualizar.setBounds(271, 204, 100, 23);
		contentPane.add(btAtualizar);
	}

	protected FuncionarioVO construirFuncionario() {
		FuncionarioVO novoFunc = new FuncionarioVO();
		novoFunc.setCpf(txfCPF.getText());
		novoFunc.setNumeroMatricula(textMat.getText());
		novoFunc.setNome(txfNome.getText());

		return novoFunc;
	}
	
	protected String construirFuncionarioPesq() {
		String novoFunc ="";
		novoFunc = txfPesquisar.getText();
		
		return novoFunc;
	}
	
	
	
}
