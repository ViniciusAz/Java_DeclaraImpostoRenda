
public class RendimentosA implements RendimentoAssalariado {

	private int id;
	private String descricao;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public double getTotalRecebidoAno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalTributavel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalIrRecolhidoNaFonte() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalINSSPago() {
		// TODO Auto-generated method stub
		return 0;
	}

}
