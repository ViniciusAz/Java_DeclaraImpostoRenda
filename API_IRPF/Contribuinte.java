import java.util.Set;

public interface Contribuinte extends Pessoa {
    void cadastraDependente(Pessoa dependente);
    Set<Pessoa> getDependentes();

    void cadastraDespesa(Despesa despesa);
    Set<Despesa> getDespesas();

    void cadastraRendimento(Rendimento rendimento);
    Set<Rendimento> getRendimentos();
    Set<RendimentoAssalariado> getRendimentosAssalariado();
    Set<RendimentoNaoAssalariado> getRendimentoNaoAssalariado();

    double getTotalRendimentos();
    double getTotalDespesas();
    double getBaseDeCalculoSimplificado();
    double getBaseDeCalculoCompleto();
    double getImpostoPagarSimplificado();
    double getImpostoPagarCompleto();
}
