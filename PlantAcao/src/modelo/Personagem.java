package modelo;

import java.awt.Image;
import javax.swing.ImageIcon;



public class Personagem {
	
	private int x, y;
	private int xInicial, yInicial;
	private int i, j;
	public static String acoes[] = { "ANDAR", "BAIXO", "CIMA", "DIREITA", "ESQUERDA", "ENXADA", "SEMENTE", "REGADOR", "MACHADO", 
		"MARTELO", "FOICE", "F1"};
	
	private ImageIcon imgIcon;
	private Image imgPersonagem;
	private String direcao;
	private int frame;
	private boolean usandoFerramenta;
	private boolean moveu;
	
	public Personagem() {
		
		
		this.setX(0);
		setY(0);
		this.i = 0;
		this.j = 8;
		this.usandoFerramenta = false;
		this.moveu = false;
		
		setFrame(0);
		this.direcao = "baixo";
		
		imgIcon = new ImageIcon(getClass().getResource("sprites/allsprites.png"));
		
		
		imgPersonagem = imgIcon.getImage();
		
	}

	public void updateTresFrames(int fr0, int fr1, int fr2) {
		if(this.frame == fr0)
			this.frame = fr1;
		else if(this.frame == fr1)
			this.frame = fr2;
		else if(this.frame == fr2)
			this.frame = fr1;
	}
	
	public void andar(int fase[][]) {
		
		if(this.direcao.equalsIgnoreCase("baixo")) {
			this.updateTresFrames(0, 1, 2);
			if(this.getI() < 9 && (fase[this.getI() + 1][this.getJ()] == FaseModelo.GRAMA || 
					fase[this.getI() + 1][this.getJ()] == FaseModelo.TERRA || fase[this.getI() + 1][this.getJ()] == FaseModelo.TERRA_ARADA ||
					fase[this.getI() + 1][this.getJ()] == FaseModelo.TERRA_PLANTADA || fase[this.getI() + 1][this.getJ()] == FaseModelo.TERRA_PLANTADA_MOLHADA)) {
				this.moveu = true;
				this.y += 2;
			}
			
		} else if(this.direcao.equalsIgnoreCase("cima")) {
			this.updateTresFrames(3, 4, 5);
			
			if(this.getI() > 0 && (fase[this.getI() - 1][this.getJ()] == FaseModelo.GRAMA || 
					fase[this.getI() - 1][this.getJ()] == FaseModelo.TERRA || fase[this.getI() - 1][this.getJ()] == FaseModelo.TERRA_ARADA ||
					fase[this.getI() - 1][this.getJ()] == FaseModelo.TERRA_PLANTADA || fase[this.getI() - 1][this.getJ()] == FaseModelo.TERRA_PLANTADA_MOLHADA)) {
				this.moveu = true;
				this.y -= 2;
			}
			
			
		} else if(this.direcao.equalsIgnoreCase("direita")) {
			this.updateTresFrames(6, 7, 8);
			
			if(this.getJ() <= 19 && (fase[this.getI()][this.getJ() + 1] == FaseModelo.GRAMA || 
					fase[this.getI()][this.getJ() + 1] == FaseModelo.TERRA || fase[this.getI()][this.getJ() + 1] == FaseModelo.TERRA_ARADA ||
					fase[this.getI()][this.getJ() + 1] == FaseModelo.TERRA_PLANTADA || fase[this.getI()][this.getJ() + 1] == FaseModelo.TERRA_PLANTADA_MOLHADA)) {
				this.moveu = true;
				this.x += 2;
			}
			
		} else if(this.direcao.equalsIgnoreCase("esquerda")) {
			this.updateTresFrames(9, 10, 11);
			if(this.getJ() > 0 && (fase[this.getI()][this.getJ() - 1] == FaseModelo.GRAMA || 
					fase[this.getI()][this.getJ() - 1] == FaseModelo.TERRA || fase[this.getI()][this.getJ() - 1] == FaseModelo.TERRA_ARADA ||
					fase[this.getI()][this.getJ() - 1] == FaseModelo.TERRA_PLANTADA || fase[this.getI()][this.getJ() - 1] == FaseModelo.TERRA_PLANTADA_MOLHADA)) {
				this.moveu = true;
				this.x -= 2;
			}
			
		}
	}
	
	public boolean estaEmLugarCorreto(int[][]fase) {
		return (fase[this.getI()][this.getJ()] == FaseModelo.GRAMA || fase[this.getI()][this.getJ()] == FaseModelo.TERRA);
		
	}
	
	public void virarParado(String direcao) {
		this.direcao = direcao;
		
		if(direcao.equalsIgnoreCase("baixo"))
			this.frame = 0;
		else if(direcao.equalsIgnoreCase("cima")) 
			this.frame = 3;
		else if(direcao.equalsIgnoreCase("direita"))
			this.frame = 6;
		else if(direcao.equalsIgnoreCase("esquerda"))
			this.frame = 9;
		
	}
	
	public void usarEnxada() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.usarFerramenta(16, 17, 18, 19);
		else if(this.direcao.equalsIgnoreCase("cima")) 
			this.usarFerramenta(20, 21, 22, 23);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.usarFerramenta(24, 25, 26, 27);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.usarFerramenta(28, 29, 30, 31);
	}
	
	public void pularVenceu(int frameAtual) {
		this.updateTresFrames(frameAtual, 12, 13);
	}
	
	public void usarSemente() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.updateTresFrames(0, 96, 97);
		else if(this.direcao.equalsIgnoreCase("cima"))
			this.updateTresFrames(3, 98, 99);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.updateTresFrames(6, 100, 101);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.updateTresFrames(9, 102, 103);
	}
	
	public void usarFoice() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.usarFerramenta(64, 65, 66, 67);
		else if(this.direcao.equalsIgnoreCase("cima"))
			this.usarFerramenta(68, 69, 70, 71);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.usarFerramenta(72, 73, 74, 75);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.usarFerramenta(76, 77, 78, 79);
		
	}
	
	public void usarMachado() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.usarFerramenta(48, 49, 50, 51);
		else if(this.direcao.equalsIgnoreCase("cima"))
			this.usarFerramenta(52, 53, 54, 55);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.usarFerramenta(56, 57, 58, 59);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.usarFerramenta(60, 61, 62, 63);
				
	}
	
	public void usarMartelo() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.usarFerramenta(32, 33, 34, 35);
		else if(this.direcao.equalsIgnoreCase("cima"))
			this.usarFerramenta(36, 37, 38, 39);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.usarFerramenta(40, 41, 42, 43);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.usarFerramenta(44, 45, 46, 47);
				
	}

	public void usarRegador() {
		if(this.direcao.equalsIgnoreCase("baixo"))
			this.usarFerramenta(80, 81, 82, 83);
		else if(this.direcao.equalsIgnoreCase("cima"))
			this.usarFerramenta(84, 85, 86, 87);
		else if(this.direcao.equalsIgnoreCase("direita"))
			this.usarFerramenta(88, 89, 90, 91);
		else if(this.direcao.equalsIgnoreCase("esquerda"))
			this.usarFerramenta(92, 93, 94, 95);
				
	}
	
	public void usarFerramenta(int fr0, int fr1, int fr2, int fr3) {
		if(!this.usandoFerramenta) {
			this.frame = fr0;
			this.usandoFerramenta = true;
		}
		else if(this.frame == fr0)
			this.frame = fr1;
		else if(this.frame == fr1)
			this.frame = fr2;
		else if(this.frame == fr2) {
			this.frame = fr3;
			this.usandoFerramenta = false;
		}
	}
		
	public void resetPersonagem() {
		this.x = 0;
		this.y = 0;
		this.i = 0;
		this.j = 8;
		this.usandoFerramenta = false;
		this.frame = 0;
		this.direcao = "baixo";
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Image getImgPersonagem() {
		return imgPersonagem;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public String getDirecao() {
		return direcao;
	}

	public int getxInicial() {
		return xInicial;
	}

	public void setxInicial(int xInicial) {
		this.xInicial = xInicial;
	}

	public int getyInicial() {
		return yInicial;
	}

	public void setyInicial(int yInicial) {
		this.yInicial = yInicial;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i += i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j += j;
	}

	public boolean isMoveu() {
		return moveu;
	}

	public void setMoveu(boolean moveu) {
		this.moveu = moveu;
	}
}
