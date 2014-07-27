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
import view.TelaModoDesafio;

public class ControleMenuDesafio extends MouseAdapter{

	private TelaModoDesafio menu;
	private Controladora app;

	public ControleMenuDesafio(Controladora app) {
		this.menu = (TelaModoDesafio) app.getTela(2);
		this.app = app;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < menu.getBotoes().size(); i++) {
			Rectangle rec = menu.getBotoes().get(i).getRect();
			if (rec.intersects(rectangle)) {
				menu.getBotoes().get(i).setEntered(true);
			}else{
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
				if(i==5){
					app.setEstado(6);
				}
			}
		}
	}

}
