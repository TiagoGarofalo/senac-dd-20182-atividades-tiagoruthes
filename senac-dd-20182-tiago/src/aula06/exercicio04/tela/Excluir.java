package aula06.exercicio04.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aula06.exercicio04.controller.FuncionarioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Excluir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir frame = new Excluir();
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
	public Excluir() {
		setTitle("Excluir Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbexcluir = new JLabel("Excluir Funcion\u00E1rio");
		lbexcluir.setBounds(10, 11, 110, 14);
		contentPane.add(lbexcluir);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(44, 33, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pegar o id digitado
				String cpfDigitado = textField.getText();
				//Instanciar um controlador
				FuncionarioController controller = new FuncionarioController();
				//Mandar o controlador excluir o Funcionario com o id digitado
				String msg = controller.excluir(cpfDigitado);
				//Pegar uma mensagem de retorno do controlador e mostrar na tela
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnNewButton.setBounds(113, 64, 89, 23);
		contentPane.add(btnNewButton);
	}

}
