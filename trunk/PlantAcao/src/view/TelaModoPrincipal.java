package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TelaModoPrincipal extends Tela {

	private String nome;
	private String record;
	private int faseLiberadas;

	public TelaModoPrincipal(int larguraTela, int alturaTela) {
		super(larguraTela, alturaTela);
	}

	@Override
	protected void carregarImagens() {
		botoes = new ArrayList<Botao>();
		imagens = new ArrayList<BufferedImage>();
		nome = "Nenhum";
		record = "--";
		int x = 80, y = 132;
		for (int i = 0; i < 21; i++) {

			if (i > 19) {
				BufferedImage img = carregarImagem("Imagem_Modo_Principal/imagem ("
						+ (i + 1) + ").png");
				imagens.add(img);
			} else if (i < 10) {
				if (i == 5) {
					y += 94;
					x = 80;
				}
				Botao btn = new Botao(x, y,
						carregarImagem("Imagem_Modo_Principal/imagem ("
								+ (i + 1) + ").png"),
						carregarImagem("Imagem_Modo_Principal/imagem ("
								+ (i + 11) + ").png"));
				btn.setEntered(true);
				botoes.add(btn);
				x += 94;
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
			g2d.setColor(new Color(51, 51, 51));
			g2d.setFont(new Font("Arial", Font.BOLD, 20));
			g2d.drawString(nome, 210, 392);
			g2d.drawString(record, 255, 413);
		}
	}

	public void setFases(int x) {
		this.faseLiberadas = x;
		for (int i = 0; i < x; i++) {
			botoes.get(i).setEntered(false);
		}
	}

	public int getFaseLiberadas() {
		if (faseLiberadas > 10)
			return 10;
		else
			return faseLiberadas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRecord(String record) {
		this.record = record;
	}
}
