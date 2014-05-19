package controle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.TelaVenceu;

public class TratarBotao implements MouseListener {

	private TelaVenceu telaVenceu;

	public TratarBotao(TelaVenceu telaVenceu) {
		this.telaVenceu = telaVenceu;
	}
	
		public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {
			for(int i = 0; i < telaVenceu.botoes.size(); i++) {
				if(e.getSource() == telaVenceu.botoes.get(i))
					telaVenceu.botoes.get(i).mudarIcone(e);

			}

		}

		public void mouseExited(MouseEvent e) {
			for(int i = 0; i < telaVenceu.botoes.size(); i++) {
				if(e.getSource() == telaVenceu.botoes.get(i))
					telaVenceu.botoes.get(i).mudarIcone(e);

			}

		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}

}
