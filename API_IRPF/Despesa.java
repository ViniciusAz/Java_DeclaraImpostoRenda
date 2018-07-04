public class Despesa extends Entrada {
  public static final int SAUDE = 0;
  public static final int EDUCACAO = 1;

  private int tipoDespesa;
  private int idPessoa; // Identificador da pessoa que efetuou a despesa
  // Permite identificar se é despesa do próprio
  // contribuinte ou de um dependente

  public Despesa(int id, int idPessoa, int tipoDespesa, int mes, double valor) {
    super(id, mes, valor);
    this.tipoDespesa = tipoDespesa;
    this.idPessoa = idPessoa;
  }

  public int getIdPessoa() {
    return idPessoa;
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
