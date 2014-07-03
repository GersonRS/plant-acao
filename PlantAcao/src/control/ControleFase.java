package control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Controladora;
import view.TelaFase;

public class ControleFase extends MouseAdapter {

	private TelaFase menu;
	private Controladora app;

	public ControleFase(Controladora app) {
		this.menu = (TelaFase) app.getTela(6);
		this.app = app;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
			}else{
			}
		}
		
		
		Rectangle rec = menu.getBotoes().get(35).getRect();
		if (rec.intersects(rectangle)) {
			menu.getBotoes().get(35).setEntered(true);
		}else{
			menu.getBotoes().get(35).setEntered(false);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				if(i==35){
					app.setEstado(11);
				}
			}
		}
	}
	
}
