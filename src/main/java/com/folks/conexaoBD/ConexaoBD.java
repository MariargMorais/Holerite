package com.folks.conexaoBD;

import java.sql.*;// pacote para acesso e processamento de dados
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
	// abertura de conex�o com o banco
	public Statement stm; // executa as instru��es SQL ao bd
	public ResultSet rs; // buscar os resultados do bd
	public Connection con; // fazer conex�o
	private String caminho = "jdbc:mysql://localhost:3306/projeto";// endere�o on // alocado
	private String usuario = "root";
	private String senha = "";

	// m�todo para conectar com o banco
	public void conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(caminho, usuario, senha);// Classe DriveManager chama conex�o com o banco
			//JOptionPane.showMessageDialog(null, "Conectado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o Conectado: \n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// m�todo para consultar no banco de dados
	public void executaSql(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);// Sem menu de op��es pesquisadas
																						// e somente ler os dados
			rs = stm.executeQuery(sql);// Executar instru��o de pesquisa ao SQL
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no executaSql: \n" + e.getMessage());
		}

	}

	// m�todo para desconectar com o banco
	public void desconecta() {
		try {
			con.close();// Fechar e liberar um objeto de conex�o
			//JOptionPane.showMessageDialog(null, " Desconectado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao fechar conex�o do BD: \n" + e.getMessage());
		}
	}

}
