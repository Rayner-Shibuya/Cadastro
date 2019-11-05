package cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Pedido {
	
	private int idPedido;
	private String data;
	private int totalItens;
	private double totalPedido;
	private boolean cancelado;
	
	public Pedido(int idPedido, String data, int totalItens, double totalPedido, boolean cancelado) {
		super();
		this.idPedido = idPedido;
		this.data = data;
		this.totalItens = totalItens;
		this.totalPedido = totalPedido;
		this.cancelado = cancelado;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(int totalItens) {
		this.totalItens = totalItens;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	public void trazer(Connection conn){
	      String comando = "SELECT * FROM mercadoria (codigo, descricao, unidade, preco, dataAtualizacao, ativo) values(?,?,?,?,?,?)";
	      try(PreparedStatement pst = conn.prepareStatement(comando);){
	    	  
	    	  
	      } 
	      catch (SQLException e){
	    	  JOptionPane.showMessageDialog(null, "Favor verificar, dados invalidos");
	      }
	   }
	
	
}
