
public class Despesa extends Entrada {
    public static final int SAUDE = 0;
    public static final int EDUCACAO = 1;
    
    private int tipoDespesa;
    
	public Despesa(int id, int tipoDespesa, int mes, double valor) {
		super(id, mes, valor);
	   	this.tipoDespesa = tipoDespesa;
	}

	public int getTipoDespesa() {
		return tipoDespesa;
	}

	@Override
	public String toString() {
		return "Despesa [tipoDespesa=" + tipoDespesa + ", getId()=" + getId() + ", getMes()=" + getMes()
				+ ", getValor()=" + getValor() + "]";
	}
}
