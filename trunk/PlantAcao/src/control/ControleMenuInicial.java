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
import view.TelaMenuInicial;

public class ControleMenuInicial extends MouseAdapter {

	private TelaMenuInicial menu;
	private Controladora app;

	public ControleMenuInicial(Controladora app) {
		this.app = app;
		this.menu = (TelaMenuInicial) app.getTela(0);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				menu.getBotoes().get(i).setEntered(true);
			} else {
				menu.getBotoes().get(i).setEntered(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				switch (i) {
				case 0: {
					((TelaModoPrincipal) app.getTela(1)).setFases(3);
					app.getTela(1).setAtiva(true);
					app.setEstado(i);
					break;
				}
				case 1: {
					app.getTela(2).setAtiva(true);
					app.setEstado(i);
					break;
				}
				case 2: {
					app.getTela(3).setAtiva(true);
					app.setEstado(i);
					break;
				}
				case 3: {
					app.getTela(4).setAtiva(true);
					app.setEstado(i);
					break;
				}
				case 4: {
					app.getTela(5).setAtiva(true);
					app.setEstado(i);
					break;
				}
				case 5:{
					app.sair();
					break;
				}
				default:
					break;
				}
			}
		}
	}

}
