package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.FaseModoPrincipalGerenciador;
import view.ModoPrincipal;


public class ModoPrincipalControle extends MouseAdapter{

	ModoPrincipal modoprincipal;
	
	public ModoPrincipalControle(ModoPrincipal modoPrincipal) {
		this.modoprincipal = modoPrincipal;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < modoprincipal.b.size(); i++) {
			if(modoprincipal.b.get(i).isAtivo()) {
				if(e.getSource() == modoprincipal.b.get(i))	{
					modoprincipal.fase = new FaseModoPrincipalGerenciador("fase"+(i+1)+".txt", i+1, modoprincipal.b.get(i).getComandos());
					modoprincipal.fase.getFase().getTv().getBotoes().get(1).addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							modoprincipal.carregarBotoes(true);
							modoprincipal.fase.getFase().getTv().setVisible(false);
							mudarFechar();
							
						};
					});
					modoprincipal.setVisible(false);
					modoprincipal.fase.voltar.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							modoprincipal.carregarBotoes(true);
							mudarFechar();
							
						}
					});

				}
			}
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		for(int i = 0; i < modoprincipal.b.size(); i++) {
			if(modoprincipal.b.get(i).isAtivo()) {
				if(e.getSource() == modoprincipal.b.get(i))	{
					modoprincipal.nome.setText(modoprincipal.b.get(i).getNomeVencedor());
					if(modoprincipal.b.get(i).getComandos() !=0 )
						modoprincipal.comandos.setText(modoprincipal.b.get(i).getComandos()+"");
					modoprincipal.icone.setIcon(modoprincipal.b.get(i).getIcon());
				}
			}
		}
	}
	public void mouseExited(MouseEvent e) {
		for(int i = 0; i < modoprincipal.b.size(); i++) {
			if(modoprincipal.b.get(i).isAtivo()) {
				if(e.getSource() == modoprincipal.b.get(i))	{
					modoprincipal.nome.setText("Nenhum");
					modoprincipal.comandos.setText("--");
					modoprincipal.icone.setIcon(null);
				}
			}
		}
		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	
	public void mudarFechar() {
		if(modoprincipal.fase.isVisible()) { 
			modoprincipal.fase.dispose();
			modoprincipal.fase = null;
			System.gc();
		}
		modoprincipal.setVisible(true);
	}
	
}
