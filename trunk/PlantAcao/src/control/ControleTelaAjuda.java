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
import view.TelaAjuda;

public class ControleTelaAjuda extends MouseAdapter {

	private TelaAjuda menu;
	private Controladora app;

	public ControleTelaAjuda(Controladora app) {
		this.app = app;
		this.menu = (TelaAjuda) app.getTela(3);
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
			app.setEstado(7);
		}
	}
}
