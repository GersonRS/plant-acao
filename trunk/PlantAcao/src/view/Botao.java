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
package view;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Botao {

	private int posX;
	private int posY;
	private BufferedImage imagem1, imagem2;
	private boolean entered = false;

	public Botao(int posX, int posY, BufferedImage imagem1,
			BufferedImage imagem2) {
		this.posX = posX;
		this.posY = posY;
		this.imagem1 = imagem1;
		this.imagem2 = imagem2;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Rectangle getRect() {
		return new Rectangle(posX, posY, imagem1.getWidth(),
				imagem1.getHeight());
	}

	public void setEntered(boolean entered) {
		this.entered = entered;
	}

	public BufferedImage getImagem() {
		if(entered)
			return imagem2;
		else
			return imagem1;
	}
}
