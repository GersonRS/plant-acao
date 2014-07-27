package view;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;

import org.junit.Test;

public class TesteTelaAcoes {

	@Test
	public void testeGetTelaImagem() {
		TelaAcoes telaAcoes =new TelaAcoes(600, 480);
		
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
