/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package view;

import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Tela {

	protected BufferedImage telaImagem;
	protected List<Botao> botoes;
	protected List<BufferedImage> imagens;

	protected final int LARGURA = 600;
	protected final int ALTURA = 480;
	protected int larguraTela;
	protected int alturaTela;
	protected Graphics2D g2d;
	protected boolean ativa = false;

	public Tela(int larguraTela, int alturaTela) {
		this.larguraTela = larguraTela;
		this.alturaTela = alturaTela;
		telaImagem = new BufferedImage(LARGURA, ALTURA,
				BufferedImage.TYPE_4BYTE_ABGR);
		carregarImagens();
		desenharMenu();
	}

	protected BufferedImage carregarImagem(String image) {
		try {

			BufferedImage img = ImageIO.read(getClass().getClassLoader()
					.getResource(image));

			BufferedImage imagem = GraphicsEnvironment
					.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice()
					.getDefaultConfiguration()
					.createCompatibleImage(img.getWidth(), img.getHeight(),
							Transparency.TRANSLUCENT);

			Graphics2D g2d = imagem.createGraphics();
			g2d.drawImage(img, 0, 0, imagem.getWidth(), imagem.getHeight(), 0,
					0, img.getWidth(), img.getHeight(), null);
			g2d.dispose();

			return imagem;
		} catch (IOException e) {
			throw new RuntimeException("Não foi possível carregar a imagem");
		}
	}

	protected abstract void carregarImagens();

	protected abstract void desenharMenu();

	public Image getTelaImagem() {
		return telaImagem.getScaledInstance(larguraTela, alturaTela, Image.SCALE_DEFAULT);
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public List<Botao> getBotoes() {
		return botoes;
	}
	
}