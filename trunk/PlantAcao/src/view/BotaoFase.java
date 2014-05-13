package view;

import javax.swing.ImageIcon;


public class BotaoFase extends Botao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeVencedor;
	private int comandos;
	
	public BotaoFase(ImageIcon img1, ImageIcon img2, boolean ativo, String botao) {
		super(img1, img2, ativo, botao);
	}

	public int getComandos() {
		return comandos;
	}

	public void setComandos(int comandos) {
		this.comandos = comandos;
	}

	public String getNomeVencedor() {
		return nomeVencedor;
	}

	public void setNomeVencedor(String nomeVencedor) {
		this.nomeVencedor = nomeVencedor;
	}

	
}