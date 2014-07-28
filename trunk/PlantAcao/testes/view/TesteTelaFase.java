package view;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteTelaFase {
	
	TelaFase tela = new TelaFase(600, 480);
	
	@Test
	public void verificarListaDeBotoes(){		
		assertNotNull("Botoes nulos!", tela.getBotoes());
	}
	
	@Test
	public void verificarListaDeImagens(){
		assertNotNull("Botoes nulos!", tela.imagens);
	}
	
	@Test
	@Before
	public void verificarTelaAtiva(){
		assertTrue("Tela ativa no momento errado", !tela.ativa);	
		
	}
	
	@Test
	public void verificarTamanhoDoFrame(){
		assertEquals("A Largura da Tela está diferente!", 600, tela.larguraTela);
		assertEquals("A Altura da Tela está diferente!", 480, tela.alturaTela);	
	}
	

}
