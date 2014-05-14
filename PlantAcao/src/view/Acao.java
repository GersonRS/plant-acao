package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.Personagem;

@SuppressWarnings("serial")
public class Acao extends JLabel {

	private String movimento;
		
	public Acao(ImageIcon img, int i) {
		super(img);
		
		this.movimento = Personagem.acoes[i];
	}
	

	
	public Acao() {
		this.movimento = "";
	}
	
	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}
	
	public String getMovimento() {
		return this.movimento;
	}
}
