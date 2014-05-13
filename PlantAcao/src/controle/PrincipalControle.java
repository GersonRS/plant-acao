package controle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.ModoDesafio;
import view.ModoPrincipal;
import view.Principal;

public class PrincipalControle extends MouseAdapter{

	Principal principal;
	
	public PrincipalControle(Principal principal) {
		this.principal = principal;
	}

	public void botaoClicado(String botao) {

		if(botao.equalsIgnoreCase("sair")) {
			if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				System.exit(0);

		} else if(botao.equalsIgnoreCase("créditos")) {
			principal.sobre.setVisible(true);
		} else if(botao.equalsIgnoreCase("modoPrincipal")) {
			principal.setVisible(false);
			principal.mp = new ModoPrincipal();
			principal.mp.voltar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					mudarFechar();

				}
			});			
		} else if(botao.equalsIgnoreCase("modoDesafio")) {
			principal.setVisible(false);
			principal.md = new ModoDesafio();
			principal.md.voltar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					mudarFechar();

				}
			});			
		} else if(botao.equalsIgnoreCase("acoes")) {
			principal.ações.setVisible(true);
		}else if(botao.equalsIgnoreCase("ajuda")) {
			principal.ajuda.setVisible(true);
		}

	}

	public void mudarFechar() {
		if(principal.mp != null) { 
			principal.mp.dispose(); 
			principal.mp = null; 
			System.gc(); 
		}
		else if(principal.md != null) {
			principal.md.dispose();
			principal.md = null;
			System.gc();
		}

		principal.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		for(int i = 0; i < principal.botoes.size(); i++) {
			if(e.getButton() == MouseEvent.BUTTON1 && e.getSource() == principal.botoes.get(i))
				botaoClicado(principal.botoes.get(i).getBotao());
		}

	}

	public void mouseEntered(MouseEvent e) {

		for(int i = 0; i < principal.botoes.size(); i++) {
			if(e.getSource() == principal.botoes.get(i)) {
				principal.botoes.get(i).mudarIcone(e);
				break;
			}
		}
	}

		public void mouseExited(MouseEvent e) {
			for(int i = 0; i < principal.botoes.size(); i++)
				if(e.getSource() == principal.botoes.get(i)) {
					principal.botoes.get(i).mudarIcone(e);
					break;
				}
		}

	
}
