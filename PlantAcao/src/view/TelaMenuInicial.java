package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TelaMenuInicial extends Tela {

	public TelaMenuInicial(int larguraTela, int alturaTela) {
		super(larguraTela, alturaTela);
	}

	@Override
	protected void carregarImagens() {
		ativa = true;
		botoes = new ArrayList<Botao>();
		imagens = new ArrayList<BufferedImage>();
		for (int i = 0; i < 14; i++) {

			if (i > 12) {
				BufferedImage img = carregarImagem("Imagem_Menu_Inicial/imagem ("
						+ i + ").png");
				imagens.add(img);
			} else if (i < 6) {
				Botao btn = new Botao(50, 68 * i + 12,
						carregarImagem("Imagem_Menu_Inicial/imagem (" + (i + 1)
								+ ").png"),
						carregarImagem("Imagem_Menu_Inicial/imagem (" + (i + 7)
								+ ").png"));
				botoes.add(btn);
			}

		}
	}

	@Override
	public void desenharMenu() {
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
