package controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import modelo.Save;
import view.FaseModoPrincipalGerenciador;

public class FaseModoPrincipralGerenciadorControle extends MouseAdapter {

	private FaseModoPrincipalGerenciador coisa;

	public FaseModoPrincipralGerenciadorControle(
			FaseModoPrincipalGerenciador coisa) {
		this.coisa = coisa;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == coisa.fase.tv.botoes.get(0)) {
			coisa.fase.setFocusable(true);
			coisa.fase.faseModelo.resetFase();
			coisa.fase.tv.setVisible(false);
			coisa.stop.setVisible(false);
			coisa.play.setVisible(true);
		}
		if (e.getSource() == coisa.fase.tv.botoes.get(2)) {
			if (coisa.fase.getFaseNum() != 10) {
				Save s = new Save();
				ArrayList<String> save = s.carregarSave();
				coisa.fase.tv.setVisible(false);
				coisa.stop.setVisible(false);
				coisa.play.setVisible(true);
				coisa.fase.faseModelo.carregarFase("fase"
						+ (coisa.fase.getFaseNum() + 1) + ".txt");
				coisa.fase.setFaseNum(coisa.fase.getFaseNum() + 1);
				coisa.fase.setRecorde(Integer.parseInt(save.get((coisa.fase
						.getFaseNum() + 1) * 3 + 1)));
				coisa.fase.faseModelo.resetFase();
				coisa.comp.resetar();
			}
		}
	}

}