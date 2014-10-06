package view;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import encode.MD5Criptografia;
import encode.Sha1;

public class Main {
	private JFrame frame;
	private final JTextField input = new JTextField();
	private final TextField result = new TextField();
	String[] comboStrings = { "SHA1", "MD5" };
	private JButton btnCriptografar;
	private final Action acaoSair = new Sair();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public Main() throws NoSuchAlgorithmException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws NoSuchAlgorithmException {
		frame = new JFrame();
		this.frame.setTitle("Criptografias");
		frame.setBounds(100, 100, 529, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Campo de entrada
		input.setBounds(145, 40, 270, 20);
		frame.getContentPane().add(input);
		input.setColumns(10);

		@SuppressWarnings("rawtypes")
		final JComboBox comboTipo = new JComboBox(comboStrings);
		comboTipo.setBounds(40, 40, 95, 20);
		frame.getContentPane().add(comboTipo);
		comboTipo.setVisible(true);
		comboTipo.setEditable(false);

		System.out.println("#items=" + comboTipo.getItemCount());

		// Botão Criptografar
		btnCriptografar = new JButton("Criptografar");
		btnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboTipo.getSelectedIndex()) {
				case 0:
					try {
						result.setText("");
						result.setText(result.getText()
								+ Sha1.SHA1Hash(input.getText()));
					} catch (NoSuchAlgorithmException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					break;

				case 1:
					try {
						result.setText("");
						result.setText(result.getText()
								+ MD5Criptografia.Md5hash(input.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}

			}
		});
		btnCriptografar.setBounds(40, 236, 123, 23);
		frame.getContentPane().add(btnCriptografar);
		// Fim botao Criptografar

		result.setEditable(false);
		result.setBounds(40, 102, 447, 112);
		frame.getContentPane().add(result);

		// Botao Limpar
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				input.setText("");
			}
		});
		btnLimpar.setBounds(179, 236, 89, 23);
		frame.getContentPane().add(btnLimpar);
		// Fim botao Limpar

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 513, 21);
		frame.getContentPane().add(menuBar);

		JMenu MenuFile = new JMenu("File");
		menuBar.add(MenuFile);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		MenuFile.add(mntmAbrir);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAction(acaoSair);
		MenuFile.add(mntmSair);

		JMenu MenuEditar = new JMenu("Editar");
		menuBar.add(MenuEditar);

	}

	@SuppressWarnings("serial")
	private class Sair extends AbstractAction {
		public Sair() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Fechar a aplicação");
		}

		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?",
					null, 0) == 0) {
				System.exit(0);
			}
			;
		}
	}
}
