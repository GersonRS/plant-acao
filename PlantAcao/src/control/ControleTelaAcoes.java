package control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Controladora;
import view.TelaAcoes;

public class ControleTelaAcoes extends MouseAdapter {

	private TelaAcoes menu;
	private Controladora app;

	public ControleTelaAcoes(Controladora app) {
		this.app = app;
		this.menu = (TelaAcoes) app.getTela(4);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		if (menu.getBotoes().get(0).getRect()
				.intersects(rectangle)) {
			menu.getBotoes().get(0).setEntered(true);
		} else {
			menu.getBotoes().get(0).setEntered(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		if (menu.getBotoes().get(0).getRect()
				.intersects(rectangle)) {
			app.setEstado(8);
		}
	}

}
