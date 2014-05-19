package controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.FaseModoDesafioGerenciador;

public class FaseModoDesafioGerenciadorControle extends MouseAdapter {

	private FaseModoDesafioGerenciador coisa;

	public FaseModoDesafioGerenciadorControle(FaseModoDesafioGerenciador coisa) {
		super();
		this.coisa = coisa;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == coisa.fase.tv.botoes.get(1)) {
			coisa.fase.faseModelo.resetFase();
			coisa.comp.resetar();
			coisa.setTextoJogador(1);
			coisa.stop.setVisible(false);
			coisa.play.setVisible(true);
			coisa.fase.tv.setVisible(false);
			coisa.fase.jogador = 1;
		}
	}

}
