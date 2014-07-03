package control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Controladora;
import view.TelaCredito;

public class ControleTelaCredito extends MouseAdapter {

	private TelaCredito menu;
	private Controladora app;

	public ControleTelaCredito(Controladora app) {
		this.app = app;
		this.menu = (TelaCredito) app.getTela(5);
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
			app.setEstado(9);
		}
	}

}
