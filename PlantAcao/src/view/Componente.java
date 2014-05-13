package view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import modelo.Constante;

@SuppressWarnings("serial")
public abstract class Componente extends JPanel {
	
	
	public ImageIcon imgComponente;
	public JLabel lblComp;
	
	public boolean pressionouAcao;
	public ArrayList<Acao> acoes;
	
	public ArrayList<Acao> sequenciaPrincipal;
	public ArrayList<Acao> sequenciaFuncao;
	
	public ArrayList<Point> posicaoPrincipal;
	public ArrayList<Point> posicaoFuncao;
	
	public Acao arrastar;
	

	public Componente() {
			
		setSize(Constante.widthComponente, Constante.heightComponente);
		setLayout(null);
		setVisible(true);
		
		arrastar = new Acao();
		add(arrastar);
		
		int inc = 36;
		int x = 86;
		int y = 8;
		int n = 12;
		int j = 0;
		int incY = 0;
		
		acoes = new ArrayList<Acao>();
		for(int i = 0; i < n; i++) {
			acoes.add(i, new Acao(new ImageIcon(getClass().getResource("imagensIcone/comp"+(i+1)+".png")), i));	
		}

		for(int i = 0; i < acoes.size(); i++) {
			
			if(i == 6) {
				incY = 36;
				j = 0;
			}
			acoes.get(i).setBounds(x + inc * j, y + incY, 32, 32);
			j++;
			
			add(acoes.get(i));
					
		}

		
		
		addMouseMotionListener(new ComponentHandler());
		addMouseListener(new ComponentHandler());
		
		
		
		
	}
		
	public int verificarCliqueParaArrastar (MouseEvent e, ArrayList<Acao> a) {

		for(int i = 0; i < a.size(); i++) {
			if( (e.getX() > a.get(i).getX() && e.getX() < a.get(i).getX() + 32) &&
					(e.getY() > a.get(i).getY() && e.getY() < a.get(i).getY() + 32) ) {

				this.arrastar.setIcon(a.get(i).getIcon());
				this.arrastar.setMovimento(a.get(i).getMovimento());
				this.arrastar.setBounds(e.getX() - 16, e.getY() - 16, 32, 32);
				this.pressionouAcao = true;
				
				return i;
			}				
		}
		return -1;
			
	}
	
	public int verificarClique (MouseEvent e, ArrayList<Acao> a) {

		for(int i = 0; i < a.size(); i++) {
			if( (e.getX() > a.get(i).getX() && e.getX() < a.get(i).getX() + 32) &&
					(e.getY() > a.get(i).getY() && e.getY() < a.get(i).getY() + 32) ) {

				return i;
			}				
		}
		return -1;
			
	}
	
	public void verificarSoltar(MouseEvent e, ArrayList<Acao> a) {
		for(int i = 0; i < a.size(); i++)
		if( pressionouAcao && (e.getX() > a.get(i).getX() && e.getX() < a.get(i).getX() + 32) &&
				(e.getY() > a.get(i).getY() && e.getY() < a.get(i).getY() + 32) ) {
			a.get(i).setIcon(arrastar.getIcon());
			a.get(i).setMovimento(arrastar.getMovimento());
		}
	}
		
	private class ComponentHandler implements MouseMotionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent e) {
				
			if( (e.getX() > 8 && e.getX() < getWidth() - 7) )
				arrastar.setBounds(e.getX() - 16, arrastar.getY(), 32, 32);
				
			if(e.getY() < getHeight() - 30 && e.getY() > 8) 
				arrastar.setBounds(arrastar.getX(), e.getY() - 16, 32, 32);

				
		}
				
		public void mouseMoved(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1)	{
				verificarCliqueParaArrastar(e, acoes);
				
				int k = verificarCliqueParaArrastar(e, sequenciaPrincipal);
				if(k >= 0) {
					sequenciaPrincipal.get(k).setIcon(null);
					sequenciaPrincipal.get(k).setMovimento("");
				}
				
				k = verificarCliqueParaArrastar(e, sequenciaFuncao);
				if(k >= 0) {
					sequenciaFuncao.get(k).setIcon(null);
					sequenciaFuncao.get(k).setMovimento("");
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				int k = verificarClique(e, sequenciaPrincipal);
				if(k >= 0) {
					sequenciaPrincipal.get(k).setMovimento("");
					sequenciaPrincipal.get(k).setIcon(null);
				}
				k = verificarClique(e, sequenciaFuncao);
				if(k >= 0) {

					sequenciaFuncao.get(k).setMovimento("");
					sequenciaFuncao.get(k).setIcon(null);
				}
				
				k = verificarClique(e, acoes);
				if(k >= 0) {
					for(int i = 0; i < sequenciaPrincipal.size(); i++) {
						if(sequenciaPrincipal.get(i).getMovimento().equals("")) {
							
							sequenciaPrincipal.get(i).setIcon(acoes.get(k).getIcon());
							sequenciaPrincipal.get(i).setMovimento(acoes.get(k).getMovimento());
							break;
						}
					}
					

				}
				
			}

		}

		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				verificarSoltar(e, sequenciaPrincipal);
				verificarSoltar(e, sequenciaFuncao);					
				pressionouAcao = false;
			}
			arrastar.setIcon(null);
			System.gc();
		
		}
	}

	public void resetar() {
		for(int i = 0; i < this.sequenciaPrincipal.size(); i++) {
			this.sequenciaPrincipal.get(i).setIcon(null);
			this.sequenciaPrincipal.get(i).setMovimento("");
		}
		
		for(int i = 0; i < this.sequenciaFuncao.size(); i++) {
			this.sequenciaFuncao.get(i).setIcon(null);
			this.sequenciaFuncao.get(i).setMovimento("");
		}
		
	}
	
	public int getComandos() {
		return this.sequenciaFuncao.size() + this.sequenciaFuncao.size();
	}
}
