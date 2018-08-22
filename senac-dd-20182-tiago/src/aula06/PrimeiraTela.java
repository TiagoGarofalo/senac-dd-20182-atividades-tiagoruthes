package aula06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PrimeiraTela {

	private JFrame frmPrimeira;

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
		confirmButton.setPreferredSize(new Dimension(20, 25));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmPrimeira.getContentPane().add(confirmButton, BorderLayout.SOUTH);

		JLabel lbNomeUsuario = new JLabel("Nome Usuário");
		frmPrimeira.getContentPane().add(lbNomeUsuario, BorderLayout.NORTH);
	}

}
