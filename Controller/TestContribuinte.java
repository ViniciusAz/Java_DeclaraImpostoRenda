import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestContribuinte {

	//Informacoes basicas
	Contribuinte c = new Contribuintes(1, "Joao", 14, 03, 1965);
	Pessoa p = new Pessoas(11, "Junior", 14, 03, 1990);
	
	@Test
	public void testNovoContribuinte() {
		c = new Contribuintes(2,"Carlos", 31,9,1988);
		assertEquals("Carlos", c.getNome());
		assertEquals(null,c.getDespesas());
		assertEquals(null,c.getRendimentos());
		assertEquals(0,c.getTotalRendimentos());
		assertEquals(0,c.getTotalDespesas());
	}
	
	@Test
	public void testCadastraDependente() {
		c.cadastraDependente(p);
		assertEquals(c.getDependentes().size(),1);
		assertEquals(c.getDependentes().get(0),p);
		assertEquals(c.getDependentes().get(0).getId(),11);
		assertEquals(c.getDependentes().get(0).getNome(),"Junior");
		assertEquals(c.getDependentes().get(0).getIdade(),28);
		c.cadastraDependente(new Pessoas(12,"Maria",15,4,2001));
		assertEquals(c.getDependentes().size(),2);
		assertEquals(c.getDependentes().get(1).getNome(),"Maria");
	}

	//Testar Cadastro de novo rendimento, e retorno total valor
	//Testar Cadastro de nova despesa, e retorno total valor
	//Testar Calculo da base de pagamento simples com / sem dependentes
	//Testar Calculo da base de pagamento completo com / sem dependentes
	//Testar Calculo do imposto simples
	//Testar Calculo do imposto completo	

	@Test
	public void testCalculaImposto() {
		Contribuintes c = new Contribuintes(5,"Mario", 17,1,1978);
		c.cadastraDependente(new Pessoas(10051,"Felipe", 2,5,2005));
		c.cadastraDependente(new Pessoas(10052,"Fernanda", 6,12,2007));

		c.cadastraDespesa(new Despesa(1, c.getId(), 0, 2, 1600));
		c.cadastraDespesa(new Despesa(2, c.getId(), 1, 5, 1600));
				
		//Testa resultado calculo imposto simples
		assertEquals((c.getTotalTributavel() - 8000 - (c.getDependentes().size() * 4000)),c.getBaseDeCalculoSimplificado());
		
		//Testa resultado do calculo do imposto completo
		assertEquals((c.getTotalTributavel() - c.getTotalAbateDespesaTitular() - c.getAbateDepensasTodosDependentes()),
				/* atual = */ c.getBaseDeCalculoCompleto());
	}	
	
	
	
	
	
}
