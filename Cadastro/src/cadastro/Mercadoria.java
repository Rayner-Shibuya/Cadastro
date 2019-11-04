package cadastro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Mercadoria {
	
	private  String codigo;
	private String descricao;
	private String unidade;
	private double preco;
	private Date data;
	private boolean ativo;
	
	public Mercadoria() {

	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void inserir(Connection conn){
	      String comando="INSERT INTO mercadoria (codigo, descricao, unidade, preco, dataAtualizacao, ativo) values(?,?,?,?,?,?)";
	      try(PreparedStatement pst = conn.prepareStatement(comando);){

	         pst.setString(1, codigo);
	         pst.setString(2, descricao);
	         pst.setString(3, unidade);
	         pst.setDouble(4, preco);
	         pst.setDate(5, data);
	         pst.setBoolean(6, ativo);
	         pst.execute();
	         
	      } 
	      catch (SQLException e){
	    	  JOptionPane.showMessageDialog(null, "Favor verificar, dados invalidos");
	      }
	   }

	
	
}
