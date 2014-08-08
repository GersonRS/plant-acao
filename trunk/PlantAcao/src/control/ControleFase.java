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

/*
 * 
 * PLAY = 25
 * RESET = 28
 * AJUDA = 30
 * ANDAR = 1
 * PARADO = 3
 * DE COSTAS = 5
 * DIREITA = 7
 * ESQUERDA = 9
 * ENXADA = 11
 * SEMENTES = 13
 * REGADOR = 15
 * MACHADO = 17
 * MARTELO = 19
 * FOICE = 21
 * F1 = 23
 * 
 */
package control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Botao;
import view.Controladora;
import view.Dragg;
import view.TelaFase;

public class ControleFase extends MouseAdapter {

	private TelaFase menu;
	private Controladora app;
	private Rectangle retangulo = new Rectangle();
	private Botao bt = new Botao();
	private Dragg dg;

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
				if(i==1){
					/*retangulo = menu.getBotoes().get(i).getRect();
					bt = menu.getBotoes().get(i);*/
					dg = new Dragg(menu.getBotoes().get(i).getPosX(), menu.getBotoes().get(i).getPosY(), menu.getBotoes().get(i).getImagem());
				}
							
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		/*if( (e.getX() > 8 && e.getX() < 600 - 7) )
			retangulo.setBounds(e.getX() - 16, bt.getPosY(), 32, 32);
		
			
		if(e.getY() < 480 - 30 && e.getY() > 8) 
			retangulo.setBounds(bt.getPosX(), e.getY() - 16, 32, 32);*/
		//retangulo.setBounds(bt.getPosX() + e.getX(), bt.getPosY() + e.getY(), 32, 32);
		dg.setBounds(dg.x + e.getX(), dg.y + e.getY(), 32, 32);
		//bt.setPosX((int)retangulo.getX());
		//bt.setPosY((int)retangulo.getY());
		//retangulo.setLocation(bt.getPosX() + e.getX(), bt.getPosY() + e.getY());
		System.out.println(dg.getBounds());
		
		
	}
	
}
