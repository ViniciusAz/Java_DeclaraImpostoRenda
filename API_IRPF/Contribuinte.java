import java.util.List;

public interface Contribuinte extends Pessoa {

  /*@
    @ instance invariant getIdade() >= 0;
    @ instance invariant getIdade() < 120;
    @ instance invariant getNome().length() > 3;
    @ instance invariant getTotalDespesas() >= 0;
    @ instance invariant getTotalRendimentos() >= 0;
    @ instance invariant getBaseDeCalculoSimplificado() >= 0;
    @ instance invariant getBaseDeCalculoCompleto() >= 0;
    @ instance invariant getImpostoPagarSimplificado() >= 0;
    @ instance invariant getImpostoPagarCompleto() >= 0;
    @ instance invariant getImpostoPagarSimplificado() < getTotalRendimentos();
    @ instance invariant getImpostoPagarCompleto() < getTotalRendimentos();
    @
    @ instance initially getTotalDespesas() == 0;
    @ instance initially getTotalRendimentos() == 0;
    @ instance initially getBaseDeCalculoSimplificado() == 0;
    @ instance initially getBaseDeCalculoCompleto() == 0;
    @ instance initially getImpostoPagarSimplificado() == 0;
    @ instance initially getImpostoPagarCompleto() == 0;
    @ 
  @*/
	
    //@ requires dependente != null
    //@ ensures getDependente().size() == \old(getDependente().size()) + 1;
	void cadastraDependente(Pessoa dependente);
    List<Pessoa> getDependentes();

    //@ requires despesa != null
	//@ requises despesa.getValor() > 0
    //@ ensures getDespesas().size() == \old(getDespesas().size()) + 1;
    void cadastraDespesa(Despesa despesa);
    List<Despesa> getDespesas();

    //@ requires rendimento != null
    //@ ensures getRendimentos().size() == \old(getRendimentos().size()) + 1;
    void cadastraRendimento(Rendimento rendimento);
    
    List<Rendimento> getRendimentos();
    List<RendimentoAssalariado> getRendimentosAssalariado();
    List<RendimentoNaoAssalariado> getRendimentoNaoAssalariado();
    
    //@ ensures \result == (\forall int i;0<=i && i<rendimento.size();valor == rendimento.getTotalTributavel());
    double getTotalRendimentos();
    
    //@ ensures \result == (\forall int i;0<=i && i<despesa.size();valor == despesa.getValor());
    double getTotalDespesas();
    
    double getBaseDeCalculoSimplificado();
    double getBaseDeCalculoCompleto();
    double getImpostoPagarSimplificado();
    double getImpostoPagarCompleto();
}
