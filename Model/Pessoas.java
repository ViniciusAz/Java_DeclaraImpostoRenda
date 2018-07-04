import java.time.LocalDate;
import java.time.Period;

public class Pessoas implements Pessoa {

	private int id;
	private String nome;
	private int nasc_ano, nasc_mes, nasc_dia;
	
	public Pessoas(int id, String nome, int dia, int mes, int ano) {
		this.id = id;
		this.nome = nome;
		nasc_dia = dia;
		nasc_mes = mes;
		nasc_ano = ano;
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

}
