public class Entrada {
    private int id;
    private int mes;
    private double valor;
    
	public Entrada(int id, int mes, double valor) {
		super();
		this.id = id;
		this.mes = mes;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public int getMes() {
		return mes;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", mes=" + mes + ", valor=" + valor + "]";
	}
}
