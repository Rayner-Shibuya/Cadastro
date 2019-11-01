package cadastro;

public class Venda {

	private int idVenda;
	private Pedido idpedido;
	private Mercadoria idMercadoria;
	private int quantidade;
	private double preco;
	public Venda(int idVenda, Pedido idpedido, Mercadoria idMercadoria, int quantidade, double preco) {
		super();
		this.idVenda = idVenda;
		this.idpedido = idpedido;
		this.idMercadoria = idMercadoria;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public Pedido getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Pedido idpedido) {
		this.idpedido = idpedido;
	}
	public Mercadoria getIdMercadoria() {
		return idMercadoria;
	}
	public void setIdMercadoria(Mercadoria idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
