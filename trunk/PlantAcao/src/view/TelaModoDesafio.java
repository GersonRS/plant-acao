package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TelaModoDesafio extends Tela {

	public TelaModoDesafio(int larguraTela, int alturaTela) {
		super(larguraTela, alturaTela);
	}

	@Override
	protected void carregarImagens() {
		botoes = new ArrayList<Botao>();
		imagens = new ArrayList<BufferedImage>();
		int x = 140;
		int y = 155;
		for (int i = 0; i < 12; i++) {

			if (i > 10) {
				BufferedImage img = carregarImagem("Imagem_Modo_Desafio/imagem ("
						+ (i + 1) + ").png");
				imagens.add(img);
			} else if (i < 5) {
				if (i == 2) {
					x = 140;
					y += 80;
				} else if (i == 4) {
					y += 80;
					x = 140;
					x += 81;
				}
				Botao btn = new Botao(x, y,
						carregarImagem("Imagem_Modo_Desafio/imagem (" + (i + 1)
								+ ").png"),
						carregarImagem("Imagem_Modo_Desafio/imagem (" + (i + 6)
								+ ").png"));
				botoes.add(btn);
				x += 163;
			}

		}
		Botao b = new Botao(LARGURA - 23, 0,
				carregarImagem("Imagem_Jogo/voltar1.png"),
				carregarImagem("Imagem_Jogo/voltar2.png"));
		botoes.add(b);
	}

	@Override
	protected void desenharMenu() {
		if (ativa) {
			g2d = (Graphics2D) telaImagem.getGraphics();
			g2d.drawImage(imagens.get(0), 0, 0, null);
			for (int i = 0; i < botoes.size(); i++) {
				g2d.drawImage(botoes.get(i).getImagem(), botoes.get(i)
						.getPosX(), botoes.get(i).getPosY(), null);
			}
		}
	}
}
