package aula06.exercicio04.tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class PrincipalNaoAbre2Janelas extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	Inserir telaCadastro = new Inserir();
	Excluir telaExcluir = new Excluir();
	Ajuda telaAjuda = new Ajuda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalNaoAbre2Janelas frame = new PrincipalNaoAbre2Janelas();
					
					//Inicializa a tela principal MAXIMIZADA
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
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
	public PrincipalNaoAbre2Janelas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-gerente-de-informa\u00E7\u00F5es-do-cliente.png")));
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar mbPrincipal = new JMenuBar();
		setJMenuBar(mbPrincipal);
		
		JMenu mnProdutos = new JMenu("Funcion\u00E1rios");
		mnProdutos.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-livro-de-f\u00EDsica.png")));
		mbPrincipal.add(mnProdutos);
		
		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(telaCadastro == null){
					telaCadastro = new Inserir();
					telaCadastro.setVisible(true);
	                desktopPane.add(telaCadastro);
	            }
	            else if(!telaCadastro.isVisible()){
	            	telaCadastro.setVisible(true);
	                desktopPane.add(telaCadastro);
	            }
				
				/*Inserir telaCadastro = new Inserir();
				desktopPane.add(telaCadastro);
				telaCadastro.show();*/
				//mntmCadastrarProduto.setEnabled(false);
			}
		});
		mntmCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmCadastrarProduto.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-adicionar-usu\u00E1rio-masculino.png")));
		mnProdutos.add(mntmCadastrarProduto);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(telaExcluir == null){
					telaExcluir = new Excluir();
					telaExcluir.setVisible(true);
	                desktopPane.add(telaExcluir);
	            }
	            else if(!telaExcluir.isVisible()){
	            	telaExcluir.setVisible(true);
	                desktopPane.add(telaExcluir);
	            }
				
				/*Excluir telaExcluir = new Excluir();
				desktopPane.add(telaExcluir);
				telaExcluir.show();*/
			}
		});
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmExcluir.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-lista-com-marcadores.png")));
		mnProdutos.add(mntmExcluir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-usu\u00E1rio.png")));
		mbPrincipal.add(mnClientes);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ainda não cadastramos clientes :( ");
			}
		});
		mntmCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmCadastrarCliente.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-treinamento.png")));
		mnClientes.add(mntmCadastrarCliente);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-confian\u00E7a.png")));
		mbPrincipal.add(mnAjuda);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(telaAjuda == null){
					telaAjuda = new Ajuda();
					telaAjuda.setVisible(true);
	                desktopPane.add(telaAjuda);
	            }
	            else if(!telaAjuda.isVisible()){
	            	telaAjuda.setVisible(true);
	                desktopPane.add(telaAjuda);
	            }
				
				/*Ajuda telaAjuda = new Ajuda();
				desktopPane.add(telaAjuda);
				telaAjuda.show();*/
			}
		});
		mntmAjuda.setIcon(new ImageIcon(PrincipalNaoAbre2Janelas.class.getResource("/aula06/exercicio04/icones/icons8-card\u00E1pio.png")));
		mntmAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnAjuda.add(mntmAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 10, 800, 600);
		contentPane.add(desktopPane);
	}
}
