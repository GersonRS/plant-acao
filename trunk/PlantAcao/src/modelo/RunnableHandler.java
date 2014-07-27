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
package modelo;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RunnableHandler implements Runnable {

	int i = 0;
	
	Fase faseModelo;


	public RunnableHandler(Fase faseModelo2) {
		this.faseModelo = faseModelo2;
	}


	@SuppressWarnings("deprecation")
	public void run() {
		while(i < faseModelo.classFase.acoes.size()) {

			if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("direita") || faseModelo.classFase.acoes.get(i).equalsIgnoreCase("esquerda") ||
					faseModelo.classFase.acoes.get(i).equalsIgnoreCase("cima") || faseModelo.classFase.acoes.get(i).equalsIgnoreCase("baixo")) {
				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.acoes.get(i));
				faseModelo.classFase.repaint();
				try {
					Thread.sleep(200);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("andar")) {
				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				for(int j  = 0; j < 8; j++) {
					faseModelo.classFase.personagem.andar(faseModelo.matrizFase);
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(110);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(faseModelo.classFase.personagem.isMoveu()) {
					if(faseModelo.classFase.personagem.getDirecao().equalsIgnoreCase("baixo"))
						faseModelo.classFase.personagem.setI(1);
					else if(faseModelo.classFase.personagem.getDirecao().equalsIgnoreCase("cima"))
						faseModelo.classFase.personagem.setI(-1);
					else if(faseModelo.classFase.personagem.getDirecao().equalsIgnoreCase("direita"))
						faseModelo.classFase.personagem.setJ(1);
					else if(faseModelo.classFase.personagem.getDirecao().equalsIgnoreCase("esquerda"))
						faseModelo.classFase.personagem.setJ(-1);

					faseModelo.classFase.personagem.setMoveu(false);
				}
				//    				verificarSePisouEmTerraPlantada();
				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("enxada")) {
				for(int j  = 0; j < 4; j++) {
					faseModelo.classFase.personagem.usarEnxada();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				faseModelo.verificarFase(Fase.TERRA, 1);
				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("semente")) {
				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				for(int j  = 0; j < 2; j++) {
					faseModelo.classFase.personagem.usarSemente();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				faseModelo.verificarFase(Fase.TERRA_ARADA, 1);
				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("foice")) {
				for(int j  = 0; j < 4; j++) {
					faseModelo.classFase.personagem.usarFoice();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				if (faseModelo.verificarFase(Fase.MATO, 4)) {
					try {
						faseModelo.classFase.repaint();
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					faseModelo.verificarFase(Fase.MATO_CORTADO, -Fase.MATO_CORTADO);
				}

				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("machado")) {
				for(int j  = 0; j < 4; j++) {
					faseModelo.classFase.personagem.usarMachado();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				if (faseModelo.verificarFase(Fase.TOCO, 4)) {
					try {
						faseModelo.classFase.repaint();
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					faseModelo.verificarFase(Fase.TOCO_QUEBRADO, -Fase.TOCO_QUEBRADO);
				}


				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("martelo")) {
				for(int j  = 0; j < 4; j++) {
					faseModelo.classFase.personagem.usarMartelo();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (faseModelo.verificarFase(Fase.PEDRA, 4)) {
					try {
						faseModelo.classFase.repaint();
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					faseModelo.verificarFase(Fase.PEDRA_QUEBRADA, -Fase.PEDRA_QUEBRADA);
				}

				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("regador")) {
				for(int j  = 0; j < 4; j++) {
					faseModelo.classFase.personagem.usarRegador();
					faseModelo.classFase.repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				faseModelo.verificarFase(Fase.TERRA_PLANTADA, 1);
				faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
				i++;
			} else if(faseModelo.classFase.acoes.get(i).equalsIgnoreCase("f1")) {
				faseModelo.classFase.acoes = faseModelo.classFase.comandoFuncao;
				i = 0;
				if(faseModelo.verificarSeGanhou()) { break; }
			}
		}

		faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
		faseModelo.classFase.repaint();
		if(faseModelo.verificarSeGanhou()) { 
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int frame = faseModelo.classFase.personagem.getFrame();
			ArrayList<Point> pos = faseModelo.encontrarTerraPlantada();
			for(int j  = 0; j < 4; j++) {
				faseModelo.nascerPlantas(pos, Fase.MUDA1+j);
				faseModelo.classFase.repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j  = 0; j < 8; j++) {
				faseModelo.classFase.personagem.pularVenceu(frame);
				faseModelo.classFase.repaint();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			faseModelo.classFase.personagem.virarParado(faseModelo.classFase.personagem.getDirecao());
			faseModelo.classFase.repaint();

			if(!faseModelo.classFase.desafio) {
				if(faseModelo.classFase.recorde == 0 || faseModelo.classFase.getQuantidadeDeAcoes() < faseModelo.classFase.recorde) {
					String nome = JOptionPane.showInputDialog("Novo Recorde: "+faseModelo.classFase.getQuantidadeDeAcoes()+" comandos\nDigite seu nome: ");
					if(nome == null)
						nome="--";
					Save s = new Save();
					faseModelo.classFase.save = s.carregarSave();
					faseModelo.classFase.save.set((faseModelo.classFase.getFaseNum()-1) * 3 + 1, faseModelo.classFase.getQuantidadeDeAcoes()+"");
					faseModelo.classFase.save.set((faseModelo.classFase.getFaseNum()-1) * 3 + 2, nome);
					if(faseModelo.classFase.getFaseNum()!=10)
						faseModelo.classFase.save.set((faseModelo.classFase.getFaseNum()-1) * 3 + 3, "1");
					s.salvar(faseModelo.classFase.save);
					faseModelo.classFase.recorde = faseModelo.classFase.getQuantidadeDeAcoes();
					JOptionPane.showMessageDialog(null, "Recorde de "+faseModelo.classFase.recorde+"comandos salvo!");
				} 
				faseModelo.classFase.tv.qtdComandos.setText(faseModelo.classFase.getQuantidadeDeAcoes()+"");
				faseModelo.classFase.tv.recorde.setText(faseModelo.classFase.recorde+"");
				faseModelo.classFase.tv.setVisible(true);

			} else {
				if(faseModelo.classFase.recorde == 0)
					faseModelo.classFase.recorde = faseModelo.classFase.getQuantidadeDeAcoes();
				else if(faseModelo.classFase.recorde >= faseModelo.classFase.getQuantidadeDeAcoes()) {
					faseModelo.classFase.recorde = faseModelo.classFase.getQuantidadeDeAcoes();
				}
				
				faseModelo.classFase.player[faseModelo.classFase.jogador].setComandos(faseModelo.classFase.getQuantidadeDeAcoes());
				if(faseModelo.classFase.jogador == 1) {
					String nome;
					if(faseModelo.classFase.player[0].getComandos() < faseModelo.classFase.player[1].getComandos()) {
						nome = faseModelo.classFase.player[0].getNome();
					} else if(faseModelo.classFase.player[0].getComandos() > faseModelo.classFase.player[1].getComandos())  {
						nome = faseModelo.classFase.player[1].getNome();
					} else
						nome = "Empate";
					
					faseModelo.classFase.tvDesafio.setVencedor(faseModelo.classFase.player, nome);
					faseModelo.classFase.tvDesafio.setImagem(new ImageIcon(getClass().getResource("imagens/vencer/venceu3.png")));
					
					faseModelo.classFase.tvDesafio.setVisible(true);
					
				} else {
					faseModelo.classFase.tv.qtdComandos.setText(faseModelo.classFase.getQuantidadeDeAcoes()+" ações");
					faseModelo.classFase.tv.setNome(faseModelo.classFase.player[faseModelo.classFase.jogador]);
					faseModelo.classFase.tv.setVisible(true);
				}


			}
			faseModelo.thread.stop();
//			thread.interrupt();
//			thread = null;
		}

		faseModelo.thread.stop();
//		thread.interrupt();
//		thread = null;

	}
}
