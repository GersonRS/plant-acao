package controle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import view.Acao;
import view.Componente;

public class ComponentHandler implements MouseMotionListener, MouseListener {

	private Componente componente;
	
	public ComponentHandler(Componente componente) {
		this.componente = componente;
	}

	public void mouseDragged(MouseEvent e) {
			
		if( (e.getX() > 8 && e.getX() < componente.getWidth() - 7) )
			componente.arrastar.setBounds(e.getX() - 16, componente.arrastar.getY(), 32, 32);
			
		if(e.getY() < componente.getHeight() - 30 && e.getY() > 8) 
			componente.arrastar.setBounds(componente.arrastar.getX(), e.getY() - 16, 32, 32);

			
	}
			
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)	{
			verificarCliqueParaArrastar(e, componente.acoes);
			
			int k = verificarCliqueParaArrastar(e, componente.sequenciaPrincipal);
			if(k >= 0) {
				componente.sequenciaPrincipal.get(k).setIcon(null);
				componente.sequenciaPrincipal.get(k).setMovimento("");
			}
			
			k = verificarCliqueParaArrastar(e, componente.sequenciaFuncao);
			if(k >= 0) {
				componente.sequenciaFuncao.get(k).setIcon(null);
				componente.sequenciaFuncao.get(k).setMovimento("");
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			int k = verificarClique(e, componente.sequenciaPrincipal);
			if(k >= 0) {
				componente.sequenciaPrincipal.get(k).setMovimento("");
				componente.sequenciaPrincipal.get(k).setIcon(null);
			}
			k = verificarClique(e, componente.sequenciaFuncao);
			if(k >= 0) {

				componente.sequenciaFuncao.get(k).setMovimento("");
				componente.sequenciaFuncao.get(k).setIcon(null);
			}
			
			k = verificarClique(e, componente.acoes);
			if(k >= 0) {
				for(int i = 0; i < componente.sequenciaPrincipal.size(); i++) {
					if(componente.sequenciaPrincipal.get(i).getMovimento().equals("")) {
						
						componente.sequenciaPrincipal.get(i).setIcon(componente.acoes.get(k).getIcon());
						componente.sequenciaPrincipal.get(i).setMovimento(componente.acoes.get(k).getMovimento());
						break;
					}
				}
				

			}
			
		}

	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			verificarSoltar(e, componente.sequenciaPrincipal);
			verificarSoltar(e, componente.sequenciaFuncao);					
			componente.pressionouAcao = false;
		}
		componente.arrastar.setIcon(null);
		System.gc();
	
	}
	
	public int verificarCliqueParaArrastar (MouseEvent e, ArrayList<Acao> a) {

		for(int i = 0; i < a.size(); i++) {
			if( (e.getX() > a.get(i).getX() && e.getX() < a.get(i).getX() + 32) &&
					(e.getY() > a.get(i).getY() && e.getY() < a.get(i).getY() + 32) ) {

				componente.arrastar.setIcon(a.get(i).getIcon());
				componente.arrastar.setMovimento(a.get(i).getMovimento());
				componente.arrastar.setBounds(e.getX() - 16, e.getY() - 16, 32, 32);
				componente.pressionouAcao = true;
				
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
		if( componente.pressionouAcao && (e.getX() > a.get(i).getX() && e.getX() < a.get(i).getX() + 32) &&
				(e.getY() > a.get(i).getY() && e.getY() < a.get(i).getY() + 32) ) {
			a.get(i).setIcon(componente.arrastar.getIcon());
			a.get(i).setMovimento(componente.arrastar.getMovimento());
		}
	}
}
