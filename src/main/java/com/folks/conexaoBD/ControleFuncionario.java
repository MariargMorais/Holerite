package com.folks.conexaoBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.ModeloFuncionario;

public class ControleFuncionario {
	
	//inst�ncia das classes
	ConexaoBD conex= new ConexaoBD();
	ModeloFuncionario mod =new ModeloFuncionario();
	
	//m�todo para salvar
	public void salvar(ModeloFuncionario mod) throws ClassNotFoundException {
		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into funcionarios(nome, cpf, salario, depto) values(?,?,?,?)");//Prepara instru��es SQL para adicionar dados
			pst.setString(1, mod.getNome());//chama as vari�veis para adicionar os dados
			pst.setString(2, mod.getCpf());
			pst.setString(3, mod.getSalario());
			pst.setString(4, mod.getDepto());
			pst.execute();//Executar instru��o SQL
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao inserir os dados: \n"+e);
		}

		conex.desconecta();
	}
	
	//m�todo de busca 
	public ModeloFuncionario buscaFuncionario (ModeloFuncionario mod) {
		conex.conexao();
		conex.executaSql("select * from  funcionarios where nome like '%" +mod.getPesquisa()+ "%'" );//Prepara instru��es SQL para buscar dados
		try {
			conex.rs.first();
			mod.setId(conex.rs.getInt("id"));//Recuperar valores do banco pelo nome das colunas
			mod.setNome(conex.rs.getString("nome"));
			mod.setCpf(conex.rs.getString("cpf"));
			mod.setSalario(conex.rs.getString("salario"));
			mod.setDepto(conex.rs.getString("depto"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao buscar funcion�rio: \n"+e);
		}
			
		conex.desconecta();
		return mod;
	}
	
	//m�todo para editar os dados
	public void Editar(ModeloFuncionario mod) {
		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement("update funcionarios set nome=?,cpf=?,salario=?,depto=? where id=?");//Prepara instru��es SQL para atualizar dados
			pst.setString(1, mod.getNome());//chama as vari�veis para atualizar os dados
			pst.setString(2, mod.getCpf());
			pst.setString(3, mod.getSalario());
			pst.setString(4, mod.getDepto());
			pst.setInt(5, mod.getId());
			pst.execute();//Executar instru��o SQL
			JOptionPane.showMessageDialog(null, " Dados alterados com sucesso \n");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao alterar os dados: \n"+e);
		}

		conex.desconecta();
		
	}

}
