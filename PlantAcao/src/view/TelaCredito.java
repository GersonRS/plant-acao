package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TelaCredito extends Tela {

	public TelaCredito(int larguraTela, int alturaTela) {
		super(larguraTela, alturaTela);
	}

	@Override
	protected void carregarImagens() {
		botoes = new ArrayList<Botao>();
		imagens = new ArrayList<BufferedImage>();
		BufferedImage img = carregarImagem("Imagem_Jogo/imagem (" + 3 + ").png");
		imagens.add(img);
		Botao b = new Botao((larguraTela / 2) + (imagens.get(0).getWidth() / 2)
				- 24, (alturaTela / 2) - (imagens.get(0).getHeight() / 2) + 2,
				carregarImagem("Imagem_Jogo/voltar1.png"),
				carregarImagem("Imagem_Jogo/voltar2.png"));
		botoes.add(b);
	}

	@Override
	public void desenharMenu() {
		if (ativa) {
			g2d = (Graphics2D) telaImagem.getGraphics();
			g2d.drawImage(imagens.get(0), (larguraTela / 2)
					- (imagens.get(0).getWidth() / 2), (alturaTela / 2)
					- (imagens.get(0).getHeight() / 2), null);
			g2d.drawImage(botoes.get(0).getImagem(), botoes.get(0).getPosX(),
					botoes.get(0).getPosY(), null);
		}
	}
}
