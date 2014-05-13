package modelo;

public class Player {
	private String nome;
	private int comandos;
	
	public Player(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public int getComandos() {
		return comandos;
	}
	public void setComandos(int comandos) {
		this.comandos = comandos;
	}


}
