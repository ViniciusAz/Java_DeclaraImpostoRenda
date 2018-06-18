import java.util.Set;

public interface RendimentoNaoAssalariado extends Rendimento{
    void cadastraValorRecebido(Entrada valor);
    void cadastraDespesa(Entrada valor);
    double getTotalRecebidoMes(int mes);
    double getDespesaTotalMes(int mes);
    double getTotalTributavelMes(int mes);
    Set<Entrada> valoresRecebidos();
    Set<Entrada> valoresGastos();
}
