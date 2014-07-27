package view;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class TesteTelaModoDesafio {

	@Test
	public void test() {

		Tela telaModoDesafio = new TelaModoDesafio(800, 600);
		telaModoDesafio.setAtiva(true);

		assertNotNull("Retornou uma imagem nula",
				telaModoDesafio.getTelaImagem());
		assertNotNull("A lista de botões está nula",
				telaModoDesafio.getBotoes());
		for (Botao botao : telaModoDesafio.getBotoes()) {
			assertNotNull("Botão nulo", botao);
			botao.setPosX(1);
			botao.setPosY(25);
			assertEquals("Valor de posX incorreto", 1, botao.getPosX());
			assertEquals("Valor de posY incorreto", 25, botao.getPosY());

			BufferedImage img1 = botao.getImagem();
			Rectangle rect = new Rectangle(botao.getPosX(), botao.getPosY(),
					img1.getWidth(), img1.getHeight());
			assertEquals("Rectangle incorreto", rect, botao.getRect());

			botao.setEntered(true);
			BufferedImage img2 = botao.getImagem();
			assertNotEquals("Não atualizou a variável entered", img2,
					img1);
		}
	}

}
