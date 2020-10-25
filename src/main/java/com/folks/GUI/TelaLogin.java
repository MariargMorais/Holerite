package com.folks.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ConexaoBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {
	ConexaoBD conecta = new ConexaoBD();// inst�ncia da classe

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		initComponents();
		conecta.conexao();// conex�o com o banco

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(85, 143, 85, 40);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(85, 194, 92, 29);
		lblSenha.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(177, 144, 206, 29);
		txtLogin.setForeground(new Color(0, 0, 0));
		txtLogin.setBackground(new Color(176, 224, 230));
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(177, 194, 206, 29);
		txtSenha.setForeground(new Color(0, 0, 0));
		txtSenha.setBackground(new Color(176, 224, 230));
		contentPane.add(txtSenha);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(208, 246, 99, 29);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Mensagem do login
				if (verificarLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo(a)!", "mensagem", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					try {
						new Funcionario().setVisible(true);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Dados inv�lidos", "Erro", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(124, 0, 275, 144);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/folks/src/imagens/text1132.png")));
		contentPane.add(lblNewLabel);
	}

	private void initComponents() {

	}

	// Verificar Login
	public boolean verificarLogin(String login, String senha) {
		return login.equals("adm") && senha.equals("1234");
	}

	@SuppressWarnings("unused")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
