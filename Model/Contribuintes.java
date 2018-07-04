import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Contribuintes implements Contribuinte{
	private int id, nasc_ano, nasc_mes, nasc_dia;
	private String nome;
	private List<Pessoa> dependente;
	private List<Despesa> despesa;
	private List<Rendimento> rendimento;

	public Contribuintes (int id, String nome, int dia, int mes, int ano) {
		this.id = id;
		this.nome = nome;
		nasc_dia = dia;
		nasc_mes = mes;
		nasc_ano = ano;
		dependente = new ArrayList<Pessoa>();
		despesa = new ArrayList<Despesa>();
		rendimento = new ArrayList<Rendimento>();
	}
	
	@Override
	public /*@ pure helper @*/ int getId() {
		return id;
	}

	@Override
	public /*@ pure helper @*/ String getNome() {
		return nome;
	}

	@Override
	public /*@ pure helper @*/ int getIdade() {
		return Period.between(LocalDate.of(nasc_ano, nasc_mes, nasc_dia), LocalDate.now()).getYears();
	}

	@Override
	public void cadastraDependente(Pessoa dependente) {
		this.dependente.add(dependente);
	}

	@Override
	public List<Pessoa> getDependentes() {
		return dependente;
	}

	@Override
	public void cadastraDespesa(Despesa despesa) {
		this.despesa.add(despesa);
	}

	@Override
	public List<Despesa> getDespesas() {
		return despesa;
	}

	@Override
	public void cadastraRendimento(Rendimento rendimento) {
		this.rendimento.add(rendimento);
	}

	@Override
	public List<Rendimento> getRendimentos() {
		return rendimento;
	}

	@Override
	public List<RendimentoAssalariado> getRendimentosAssalariado() {
		List<RendimentoAssalariado> rend = new ArrayList<RendimentoAssalariado>();
        for (Rendimento r : rendimento){
        	if(r instanceof RendimentoAssalariado) rend.add((RendimentoAssalariado) r);
        }
		return rend;
	}

	@Override
	public List<RendimentoNaoAssalariado> getRendimentoNaoAssalariado() {
		List<RendimentoNaoAssalariado> rend = new ArrayList<RendimentoNaoAssalariado>();
				for (Rendimento r : rendimento){
					if(r instanceof RendimentoNaoAssalariado) rend.add((RendimentoNaoAssalariado) r);
        }
		return rend;
	}

	@Override
	public double getTotalRendimentos() {
		double total = 0;
		for (Rendimento r : rendimento)
			total += r.getTotalRecebidoAno();
		return total;
	}

	@Override
	public double getTotalDespesas() {
		double total = 0;
		for (Despesa d : despesa)
			total += d.getValor();
		return total;
	}

	public double getTotalTributavel() {
		double total = 0;
		for (Rendimento r : rendimento)
			total += r.getTotalTributavel();
		return total;
	}
	
	public double getTotalAbateDespesaTitular() {
		double educa = 0,
			   saude = 0;
		for (Despesa d : despesa) {
			if(d.getIdPessoa() == id) {
				if(d.getTipoDespesa() == 0 /*SAUDE*/) saude += d.getValor();
				else /*EDUCACAO*/ educa += d.getValor(); 
			}
		}
		if(educa > 10000) educa = 10000;
		if(saude > 10000) saude = 10000;
		return (saude + educa) * 0.5;
	}
	
	public double getTotalAbateDespesaDependentes(Pessoa p) {
		double educa = 0, 
			   saude = 0;
		for (Despesa d : despesa) {
			if(d.getId() == p.getId()) { 
				if(d.getTipoDespesa() == 0 /*SAUDE*/) saude += d.getValor();
				else /*EDUCACAO*/ educa += d.getValor(); 
			}
		}
		if(saude > 3000) saude = 3000;
		if(educa > 5000) educa = 5000;
		return educa + (saude * 0.5);
	}
	
	public double getAbateDepensasTodosDependentes() {
		double despDepen = 0;
		for (Pessoa d : dependente) {
			despDepen += getTotalAbateDespesaDependentes(d);
		}
		return despDepen;
	}
	
	@Override
	public double getBaseDeCalculoSimplificado() {
		double calculo = 0;
		calculo = getTotalTributavel() - 8000 - (dependente.size() * 4000);
		return calculo;
	}

	@Override
	public double getBaseDeCalculoCompleto() {
		return getTotalTributavel() - getTotalAbateDespesaTitular() - getAbateDepensasTodosDependentes();
	}

	@Override
	public double getImpostoPagarSimplificado() {
		double base = getBaseDeCalculoSimplificado();
		if(base > 35000) return base * 0.3;
		else if (base > 15000 && base <= 35000) return base * 0.15;
		else return 0;
	}

	@Override
	public double getImpostoPagarCompleto() {
		double base = getBaseDeCalculoCompleto();
		if(base > 35000) return base * 0.3;
		else if (base > 15000 && base <= 35000) return base * 0.15;
		else return 0;
	}
}
