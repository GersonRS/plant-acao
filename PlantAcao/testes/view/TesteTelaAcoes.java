package view;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import org.junit.Test;

public class TesteTelaAcoes {

	TelaAcoes telaAcoes =new TelaAcoes(600, 480);
	
	@Test
	public void testeConstrutor() {
		
		assertEquals("Largura da imagem da tela errada!", 600, telaAcoes.getTelaImagem().getWidth(null), 0);
		assertEquals("Altura da imagem da tela errada!", 480, telaAcoes.getTelaImagem().getHeight(null), 0);
		assertEquals("Não carregou o Array de botões", 1, telaAcoes.getBotoes().size(), 0);
		
		
	}
	
	@Test
	public void testeGetTelaImagem() {
		
		assertEquals("Erro ao carregar imagem tela!", new Image() {
			@Override
			public int getWidth(ImageObserver observer) {
				return 0;
			}
			
			@Override
			public ImageProducer getSource() {
				return null;
			}
			
			@Override
			public Object getProperty(String name, ImageObserver observer) {
				return null;
			}
			
			@Override
			public int getHeight(ImageObserver observer) {
				return 0;
			}
			
			@Override
			public Graphics getGraphics() {
				return null;
			}
		}, telaAcoes.getTelaImagem());
		
//		fail("Not yet implemented");
	}

}
