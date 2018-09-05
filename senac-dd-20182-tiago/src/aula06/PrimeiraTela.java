package aula06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PrimeiraTela {

	private JFrame frmPrimeira;
	private JTextField txtInformeOsNmeros;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela window = new PrimeiraTela();
					window.frmPrimeira.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrimeira = new JFrame();
		frmPrimeira.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmPrimeira.setTitle(" Primeira Tela");
		frmPrimeira.setBounds(100, 100, 450, 300);
		frmPrimeira.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(295, 236, 139, 25);
		confirmButton.setPreferredSize(new Dimension(20, 25));
		
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Why dont you die?");
			}
		});
		frmPrimeira.getContentPane().setLayout(null);
		frmPrimeira.getContentPane().add(confirmButton);

		JLabel lbNomeUsuario = new JLabel("Entrada de dados");
		lbNomeUsuario.setBounds(143, 0, 123, 14);
		lbNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		frmPrimeira.getContentPane().add(lbNomeUsuario);
		
		txtInformeOsNmeros = new JTextField();
		txtInformeOsNmeros.setText("informe os n\u00FAmeros");
		txtInformeOsNmeros.setBounds(10, 47, 106, 20);
		frmPrimeira.getContentPane().add(txtInformeOsNmeros);
		txtInformeOsNmeros.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(126, 47, 281, 20);
		frmPrimeira.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnMostrarCdigoAscii = new JButton("Mostrar c\u00F3digo ascii");
		btnMostrarCdigoAscii.setBounds(127, 71, 139, 23);
		frmPrimeira.getContentPane().add(btnMostrarCdigoAscii);
		
		JLabel lblCdigoAscii = new JLabel("C\u00F3digo ascii");
		lblCdigoAscii.setBounds(10, 150, 71, 14);
		frmPrimeira.getContentPane().add(lblCdigoAscii);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 147, 86, 20);
		frmPrimeira.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
