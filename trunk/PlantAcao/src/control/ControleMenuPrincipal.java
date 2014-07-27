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
package control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Controladora;
import view.TelaModoPrincipal;

public class ControleMenuPrincipal extends MouseAdapter {

	private TelaModoPrincipal menu;
	private Controladora app;

	public ControleMenuPrincipal(Controladora app) {
		this.menu = (TelaModoPrincipal) app.getTela(1);
		this.app = app;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getFaseLiberadas(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				menu.setNome("Gerson");
			}else{
				menu.setNome("Nenhum");
			}
		}
		
		
		Rectangle rec = menu.getBotoes().get(10).getRect();
		if (rec.intersects(rectangle)) {
			menu.getBotoes().get(10).setEntered(true);
		}else{
			menu.getBotoes().get(10).setEntered(false);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				if(i==0){
					app.getTela(6).setAtiva(true);
					app.setEstado(10);
				}
				if(i==10){
					app.setEstado(5);
				}
			}
		}
	}
	
}
