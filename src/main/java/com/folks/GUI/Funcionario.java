package com.folks.GUI;

import com.folks.*;

import controle.ConexaoBD;
import controle.ControleFuncionario;
import modelo.ModeloFuncionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Funcionario extends JFrame {
	
	protected static final String Interger = null;
	//inst�ncia das classes
	ControleFuncionario control = new ControleFuncionario();
	ConexaoBD conex = new ConexaoBD();
	ModeloFuncionario mod = new ModeloFuncionario();
	int flag=0; //"bandeiras" para sinalizar o bot�o salvar
	
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSalario;
	private JTextField textPesquisa;
	private JTextField textId;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			});
	}
	
	public Funcionario() throws ParseException, ClassNotFoundException {
		initComponents();
		setResizable(false);
		setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 349);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Calibri", Font.PLAIN, 14));
		menuBar.setBackground(new Color(135, 206, 235));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setFont(new Font("Calibri", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGerarFolha = new JMenuItem("Gerar Folha");
		mntmGerarFolha.setBackground(new Color(173, 216, 230));
		mntmGerarFolha.setFont(new Font("Calibri", Font.PLAIN, 14));
		mntmGerarFolha.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmGerarFolha);
		
		JMenu mnNewMenu_1 = new JMenu("Editar");
		mnNewMenu_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.setBackground(new Color(173, 216, 230));
		mntmCopiar.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmCopiar);
		
		JMenuItem mntmColar = new JMenuItem("Colar");
		mntmColar.setBackground(new Color(173, 216, 230));
		mntmColar.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmColar);
		
		JMenu mnNewMenu_2 = new JMenu("Sobre");
		mnNewMenu_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmFolks = new JMenuItem("Folks");
		mntmFolks.setBackground(new Color(173, 216, 230));
		mntmFolks.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmFolks);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 38, 427, 215);
		panel.setBackground(new Color(173, 216, 230));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(41, 37, 101, 14);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 19));
		panel.add(lblNome);
		
		JLabel lblDepto = new JLabel("Departamento");
		lblDepto.setBounds(41, 138, 112, 24);
		lblDepto.setFont(new Font("Calibri", Font.PLAIN, 19));
		panel.add(lblDepto);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(41, 103, 101, 24);
		lblSalrio.setFont(new Font("Calibri", Font.PLAIN, 19));
		panel.add(lblSalrio);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(41, 68, 51, 24);
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 19));
		panel.add(lblCpf);
		
		textNome = new JTextField();
		textNome.setBounds(161, 35, 221, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		textNome.setEnabled(false);
		
		textSalario = new JTextField();
		textSalario.setBounds(161, 107, 159, 20);
		panel.add(textSalario);
		textSalario.setColumns(10);
		textSalario.setEnabled(false);
		
		final JTextField formattedTextCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextCpf.setBounds(161, 72, 159, 20);
		panel.add(formattedTextCpf);
		formattedTextCpf.setEnabled(false);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 141, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setFont(new Font("Calibri", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Gerente de Projeto", "Programa��o", "Departamento Pessoal"}));
		comboBox.setEditable(true);
		panel.add(comboBox);
		comboBox.setEnabled(false);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(162, 185, 159, 20);
		panel.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		
		JLabel lblProgramador = new JLabel("Funcion\u00E1rio");
		lblProgramador.setBounds(202, 11, 117, 27);
		lblProgramador.setFont(new Font("Calibri", Font.BOLD, 23));
		contentPane.add(lblProgramador);
		

		//bot�o salvar
		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(71, 264, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1) {
				mod.setNome(textNome.getText());
				mod.setCpf(formattedTextCpf.getText());
				mod.setSalario(textSalario.getText());
				mod.setDepto(comboBox.getSelectedItem().toString());
				textId.setText("");
				textNome.setText("");
				formattedTextCpf.setText("");
				comboBox.setSelectedItem("");
				textSalario.setText("");
				textPesquisa.setText("");
				textNome.setEnabled(false);
				formattedTextCpf.setEnabled(false);
				textSalario.setEnabled(false);
				comboBox.setEnabled(false);
				btnSalvar.setEnabled(false);
				try {
					control.salvar(mod);//chama o m�todo salvar
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			} else if (flag ==2){
				mod.setId(Integer.parseInt((textId.getText())));
				mod.setNome(textNome.getText());
				mod.setCpf(formattedTextCpf.getText());
				mod.setSalario(textSalario.getText());
				mod.setDepto(comboBox.getSelectedItem().toString());
				control.Editar(mod);
				textId.setText("");
				textNome.setText("");
				formattedTextCpf.setText("");
				textSalario.setText("");
				comboBox.setSelectedItem("");
				textPesquisa.setText("");
				textNome.setEnabled(false);
				formattedTextCpf.setEnabled(false);
				textSalario.setEnabled(false);
				comboBox.setEnabled(false);
				btnSalvar.setEnabled(false);
			}
			}});
			
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSalvar.setBackground(new Color(50, 205, 50));
		contentPane.add(btnSalvar);
		
		//bot�o pesquisar
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(173, 216, 230));
		btnPesquisar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod.setPesquisa(textPesquisa.getText());
				ModeloFuncionario model = control.buscaFuncionario(mod); //chamando m�todo de busca
				textId.setText(String.valueOf(model.getId()));
				textNome.setText(model.getNome());
				formattedTextCpf.setText(model.getCpf());
				textSalario.setText(model.getSalario());
				comboBox.setSelectedItem(model.getDepto().toString());
				textNome.setEnabled(false);
				formattedTextCpf.setEnabled(false);
				textSalario.setEnabled(false);
				comboBox.setEnabled(false);
				textId.setEnabled(false);
				btnSalvar.setEnabled(false);
				
			}
		});
		btnPesquisar.setBounds(30, 184, 101, 23);
		panel.add(btnPesquisar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblId.setBounds(41, 12, 46, 14);
		panel.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(161, 4, 86, 20);
		panel.add(textId);
		textId.setColumns(10);
		textId.setEnabled(false);
		
		//bot�o sair
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(374, 264, 89, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new Funcionario().setVisible(false);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnSair.setBackground(new Color(176, 224, 230));
		btnSair.setFont(new Font("Calibri", Font.PLAIN, 14));
		contentPane.add(btnSair);
		
		//bot�o novo
		JButton btnNovo = new JButton("Novo"); 
		btnNovo.setBackground(new Color(30, 144, 255));
		btnNovo.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=1;
				textNome.setEnabled(true);
				formattedTextCpf.setEnabled(true);
				textSalario.setEnabled(true);
				comboBox.setEnabled(true);
				textId.setText("");
				textNome.setText("");
				formattedTextCpf.setText("");
				textSalario.setText("");
				comboBox.setSelectedItem("");
				textPesquisa.setText("");
				textId.setEnabled(false);
				btnSalvar.setEnabled(true);
				
			
			}
		});
		btnNovo.setBounds(174, 264, 89, 23);
		contentPane.add(btnNovo);
		
		//bot�o editar
		final JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(250, 128, 114));
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEditar.setBounds(273, 264, 89, 23);
		contentPane.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=2;
				textNome.setEnabled(true);
				formattedTextCpf.setEnabled(true);
				textSalario.setEnabled(true);
				comboBox.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(true);
				
				
			}
		});
	}

	private void initComponents() {
		
	}
}
