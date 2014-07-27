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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TelaFase extends Tela {

	public TelaFase(int larguraTela, int alturaTela) {
		super(larguraTela, alturaTela);
	}

	@Override
	protected void carregarImagens() {
		botoes = new ArrayList<Botao>();
		imagens = new ArrayList<BufferedImage>();
		telaImagem = new BufferedImage(larguraTela, alturaTela,
				BufferedImage.TYPE_4BYTE_ABGR);
		int inc = 36;
		int x = 86+352;
		int y = 8;
		int j = 0;
		int incY = 0;
		for (int i = 0; i < 21; i++) {
			if(i == 7) {
				incY = 36;
				j = 0;
			}

			if (i == 0) {
				BufferedImage img = carregarImagem("Imagem_Fase/1.png");
				imagens.add(img);
			}
			if (i > 0 && i < 13) {
				Botao btn = new Botao(x + inc * j, y + incY,
						carregarImagem("Imagem_Fase/" + (i + 1) + ".png"), null);
				botoes.add(btn);
				j++;
			}
			if(i==13){
				Botao btn = new Botao(16, 440,
						carregarImagem("Imagem_Fase/" + (i + 1) + ".png"), carregarImagem("Imagem_Fase/" + (i + 2) + ".png"));
				botoes.add(btn);
			}
			if(i>14 && i<17){
				Botao btn = new Botao(i==15?84:152, 440,
						carregarImagem("Imagem_Fase/" + (i + 1) + ".png"), null);
				botoes.add(btn);
			}
			if (i > 16) {
				BufferedImage img = carregarImagem("Imagem_Fase/" + (i + 1)
						+ ".png");
				imagens.add(img);
			}
			Botao b = new Botao(larguraTela - 23, 0,
					carregarImagem("Imagem_Jogo/voltar1.png"),
					carregarImagem("Imagem_Jogo/voltar2.png"));
			botoes.add(b);
		}
	}

	@Override
	public void desenharMenu() {
		if (ativa) {
			g2d = (Graphics2D) telaImagem.getGraphics();
			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, larguraTela, alturaTela);
			g2d.drawImage(imagens.get(4), 0, 0, null);
			g2d.drawImage(imagens.get(3), 0, 192, null);
			g2d.drawImage(imagens.get(1), 368, 88, null);
			for (int i = 0; i < botoes.size(); i++) {
				g2d.drawImage(botoes.get(i).getImagem(), botoes.get(i)
						.getPosX(), botoes.get(i).getPosY(), null);
			}
		}
	}
}