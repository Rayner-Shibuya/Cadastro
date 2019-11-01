package cadastro;

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
	
	
	
	
}
