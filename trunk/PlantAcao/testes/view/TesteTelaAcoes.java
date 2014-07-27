package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TesteTelaAcoes {

	TelaAcoes telaAcoes =new TelaAcoes(600, 480);
	
	@Test
	public void testeConstrutor() {
		
		assertEquals("Largura da imagem da tela errada!", 600, telaAcoes.getTelaImagem().getWidth(null), 0);
		assertEquals("Altura da imagem da tela errada!", 480, telaAcoes.getTelaImagem().getHeight(null), 0);
		assertNotEquals("Não carregou o Array de botões", 0, telaAcoes.getBotoes().size(), 0);
		
		
	}
	
	@Test
	public void testeGetTelaImagem() {
		
		assertNotNull("Imagem não carregada", telaAcoes.getTelaImagem());
		
		assertEquals("Erro ao escalar largura da imagem tela!", 600, telaAcoes.getTelaImagem().getWidth(null));
		assertEquals("Erro ao escalar altura da imagem tela!", 480, telaAcoes.getTelaImagem().getHeight(null));
	}

}
