package view;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteClasseFase {
	
	TelaFase tela = new TelaFase(600, 480);
	
	@Test
	public void verificarListaDeBotoes(){		
		assertNotNull("Botoes nulos!", tela.getBotoes());
	}
	
	public void verificarListaDeImagens(){
		assertNotNull("Botoes nulos!", tela.imagens);
	}
	
	@Before
	public void verificarTelaAtiva(){
		assertTrue("Tela ativa no momento errado", !tela.ativa);	
		
	}
	
	public void verificarTamanhoDoFrame(){
		assertEquals("A Largura da Tela está diferente!", 600, tela.larguraTela);
		assertEquals("A Altura da Tela está diferente!", 480, tela.alturaTela);	
	}
	

}
