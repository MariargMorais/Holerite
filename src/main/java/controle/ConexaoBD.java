package controle;

import java.sql.*;// pacote para acesso e processamento de dados
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
	// abertura de conex�o com o banco
	public Statement stm; // executa as instru��es SQL ao bd
	public ResultSet rs; // buscar os resultados do bd
	public Connection con; // fazer conex�o
	private String driver = "com.mysql.jdbc.Driver";// Driver para conectar com o banco
	private String caminho = "jdbc:mysql://localhost:5306/projeto";// endere�o onde o banco est� alocado
	private String usuario = "root";
	private String senha = "banco2020";

	// m�todo para conectar com o banco
	public void conexao() {
		try {

			System.setProperty("jdbc.Drivers", driver);
			con = DriverManager.getConnection(caminho, usuario, senha);// Classe DriveManager chama conex�o com o banco
			JOptionPane.showMessageDialog(null, "Conectado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o Conectado: \n" + e.getMessage());
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
			JOptionPane.showMessageDialog(null, " Desconectado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao fechar conex�o do BD: \n" + e.getMessage());
		}
	}

}
