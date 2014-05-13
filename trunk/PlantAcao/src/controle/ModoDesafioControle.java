package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.FaseModoDesafioGerenciador;
import view.ModoDesafio;


public class ModoDesafioControle extends MouseAdapter{

	ModoDesafio mododesafio;
	
	public ModoDesafioControle(ModoDesafio modoDesafio) {
		this.mododesafio = modoDesafio;
	}

	private void mudarFechar() {
		if(mododesafio.fase.isVisible()) { 
			mododesafio.fase.dispose();
			mododesafio.fase = null;
			System.gc();
		}
		mododesafio.setVisible(true);

	}
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < mododesafio.dificuldade.size(); i++) {
			if(e.getSource() == mododesafio.dificuldade.get(i)) {
				String nome[] = new String[2];
				nome[0] = JOptionPane.showInputDialog(null, "Nome do Jogador 1: ");
				if(nome[0] != null) {
					nome[1] = JOptionPane.showInputDialog(null, "Nome do Jogador 2: ");

					if(nome[1] != null) {
						mododesafio.setVisible(false);
						mododesafio.fase = new FaseModoDesafioGerenciador(mododesafio.dificuldade.get(i).getBotao(), nome);
						mododesafio.fase.voltar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								mudarFechar();

							}


						});
						mododesafio.fase.getFase().getTv().getBotoes().get(0).addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								mododesafio.fase.getFase().getTv().setVisible(false);
								mudarFechar();
							}
						});
						try{mododesafio.fase.getFase().getTvDesafio().getBotoes().get(0).addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								mododesafio.fase.getFase().getTvDesafio().setVisible(false);
								mudarFechar();
							}
						});} catch(Exception excp) {
						}
						
					}
				}
			}

		}
	}
		public void mouseEntered(MouseEvent e) {
			for(int i = 0; i < mododesafio.dificuldade.size(); i++) {
				if(e.getSource() == mododesafio.dificuldade.get(i))
					mododesafio.dificuldade.get(i).mudarIcone(e);

			}

		}

		public void mouseExited(MouseEvent e) {
			for(int i = 0; i < mododesafio.dificuldade.size(); i++) {
				if(e.getSource() == mododesafio.dificuldade.get(i))
					mododesafio.dificuldade.get(i).mudarIcone(e);

			}

		}
	
}
