package view;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.ComponentHandler;



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
	public static int widthComponente = 356, heightComponente = 600;
	public static int xComponente = 368;
	
	public ComponentHandler controle;
	
	public Componente() {
			
		setSize(widthComponente, heightComponente);
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

		controle = new ComponentHandler(this);
		
		addMouseMotionListener(controle);
		addMouseListener(controle);
		
		
		
		
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
