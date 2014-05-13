package view;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Botao extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img1, img2;
	private String botao;

	private boolean ativo;
	
	public Botao(String botao) {
		this.botao = botao;
		img1 = new ImageIcon(getClass().getResource("imagens/" + botao + "1.png"));
		img2 = new ImageIcon(getClass().getResource("imagens/" + botao + "2.png"));

		this.setIcon(img1);
	}
	
	public Botao(ImageIcon img1, ImageIcon img2, boolean ativo, String botao) {
		this.botao = botao;
		this.ativo = ativo; 
		this.img1 = img1;
		this.img2 = img2;
		if(ativo)
			this.setIcon(this.img1);
		else
			this.setIcon(this.img2);
	}
	public Botao(ImageIcon img1, ImageIcon img2, String botao) {
		this.botao = botao;
		this.img1 = img1;
		this.img2 = img2;
		this.setIcon(img1);
	}
	
	public void setIconAtivo() {
		this.ativo = true;
		this.setIcon(img1);
	}
	
	public void mudarIcone(MouseEvent e) {
		if(e.getID() == MouseEvent.MOUSE_ENTERED) {
			
			this.setIcon(img2);
		} else if(e.getID() == MouseEvent.MOUSE_EXITED) {
			this.setIcon(img1);

		}

	}
	
	public String getBotao() {
		return botao;
	}

	public boolean isAtivo() {
		return ativo;
	}

}


