import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Contribuintes implements Contribuinte{
	private int id, nasc_ano, nasc_mes, nasc_dia;
	private String nome;
	private Set<Pessoa> dependente = new HashSet<Pessoa>();
	private Set<Despesa> despesa = new HashSet<Despesa>();
	private Set<Rendimento> rendimento = new HashSet<Rendimento>();
	// private Set<RendimentoAssalariado> rendimentoAS = new HashSet<RendimentoAssalariado>();
	// private Set<RendimentoNaoAssalariado> rendimentoNA = new HashSet<RendimentoNaoAssalariado>();

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getIdade() {
		return Period.between(LocalDate.of(nasc_ano, nasc_mes, nasc_dia), LocalDate.now()).getYears();
	}

	@Override
	public void cadastraDependente(Pessoa dependente) {
		this.dependente.add(dependente);
	}

	@Override
	public Set<Pessoa> getDependentes() {
		return dependente;
	}

	@Override
	public void cadastraDespesa(Despesa despesa) {
		this.despesa.add(despesa);
	}

	@Override
	public Set<Despesa> getDespesas() {
		return despesa;
	}

	@Override
	public void cadastraRendimento(Rendimento rendimento) {
		this.rendimento.add(rendimento);
	}

	@Override
	public Set<Rendimento> getRendimentos() {
		return rendimento;
	}

	@Override
	public Set<RendimentoAssalariado> getRendimentosAssalariado() {
		Set<RendimentoAssalariado> rend = new HashSet<RendimentoAssalariado>();
        Iterator<Rendimento> it = rendimento.iterator();
        while (it.hasNext()){
        	Rendimento r = it.next();
        	if(r instanceof RendimentoAssalariado) rend.add((RendimentoAssalariado) r);
        }
		return rend;
	}

	@Override
	public Set<RendimentoNaoAssalariado> getRendimentoNaoAssalariado() {
		Set<RendimentoNaoAssalariado> rend = new HashSet<RendimentoNaoAssalariado>();
        Iterator<Rendimento> it = rendimento.iterator();
        while (it.hasNext()){
        	Rendimento r = it.next();
        	if(r instanceof RendimentoNaoAssalariado) rend.add((RendimentoNaoAssalariado) r);
        }
		return rend;
	}

	@Override
	public double getTotalRendimentos() {
		//TODO
		return 0;
	}

	@Override
	public double getTotalDespesas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBaseDeCalculoSimplificado() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBaseDeCalculoCompleto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getImpostoPagarSimplificado() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getImpostoPagarCompleto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
