package view;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.FaseModelo;
import modelo.Personagem;
import modelo.Player;

@SuppressWarnings("serial")
public class Fase extends JPanel {


	public FaseModelo faseModelo;
	public ImageIcon imgFase;
	public Image imgBg;
	public ImageIcon imgTile;
	public Image tile;

	public Personagem personagem;
	public Point [][] faseRec = new Point[10][20];
	//public int [][]fase = new int[10][20];
	//public int [][]estaFase = new int[10][20];

	public String diretorioFase;

	public ArrayList<String> acoes;
	public ArrayList<String> comandoFuncao;

	public boolean desafio;
	public int faseNum;
	public int recorde;
	public int quantidadeDeAcoes;
	public String nomeVencedor;
	public ArrayList<String> save;
	public TelaVenceu tv;
	public TelaVenceu tvDesafio;

	public Player player[] = new Player[2];
	public int jogador;
	public static int widthFase = 352, heightFase = 240;
	//	ArrayList<BotaoFase> b = new ArrayList<BotaoFase>();

	public Fase(String diretorioFase, int faseNum, int recorde) {
		setSize(widthFase, heightFase);
		setLayout(null);
		faseModelo = new FaseModelo(this);
		faseModelo.setTilePoints();
		this.desafio = false;

		personagem = new Personagem();
		this.faseNum = faseNum;
		this.recorde = recorde;
		imgFase = new ImageIcon(getClass().getResource("imagens/fasebg3.png"));
		imgBg = imgFase.getImage();

		imgTile = new ImageIcon(getClass().getResource("imagens/tiles.png"));
		tile = imgTile.getImage();
		
		tv = new TelaVenceu(new ImageIcon(getClass().getResource("imagens/vencer/venceu.png")));
		tv.setModal(true);

		personagem.setxInicial(122);
		personagem.setyInicial(32);

		this.diretorioFase = diretorioFase;

		faseModelo.carregarFase(diretorioFase);



	}

	public Fase(String dificuldade, int recorde, String[] nome) {
		setSize(widthFase, heightFase);
		setLayout(null);
		faseModelo = new FaseModelo(this);
		faseModelo.setTilePoints();
		this.desafio = true;
		personagem = new Personagem();
		imgFase = new ImageIcon(getClass().getResource("imagens/fasebg3.png"));
		imgBg = imgFase.getImage();
		imgTile = new ImageIcon(getClass().getResource("imagens/tiles.png"));
		tile = imgTile.getImage();

		for(int i = 0; i < player.length; i++) {
			player[i] = new Player(nome[i]);
		}
		
		tvDesafio = new TelaVenceu();
		tvDesafio.setModal(true);
		tv = new TelaVenceu(new ImageIcon(getClass().getResource("imagens/vencer/venceu2.png")), nome);
		tv.setModal(true);
		
		jogador = 0;
		personagem.setxInicial(122);
		personagem.setyInicial(32);

		faseModelo.gerarFaseAleatoria(dificuldade); 


	}

	

	public void desenharQuadro(Image source, Graphics g,
			int x, int y, int cols, int frame,
			int width, int height)
	{
		int fx = (frame % cols) * width;
		int fy = (frame / cols) * height;
		g.drawImage(source, x, y, x+width, y+height,
				fx, fy, fx+width, fy+height, this);

	}

	public void desenharFase(int fase[][], Graphics g) {
		g.drawImage(imgBg, 0, 0, widthFase, heightFase, null);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if(fase[i][j] != 20)
					desenharQuadro(tile, g, faseRec[i][j].x, faseRec[i][j].y, 4, fase[i][j], 16, 16);
			}
		}

	}
 
	public void paint(Graphics g) {
		super.paint(g);
		desenharFase(faseModelo.fase, g);
		desenharQuadro(personagem.getImgPersonagem(), g, personagem.getxInicial() + personagem.getX(), personagem.getyInicial() + personagem.getY(), 16, personagem.getFrame(), 59, 57);

	}

	public String getDiretorioFase() {
		return diretorioFase;
	}

	public void setDiretorioFase(String diretorioFase) {
		this.diretorioFase = diretorioFase;
	}
	
	public void setFaseNum(int faseNum) {
		this.faseNum = faseNum;
	}

	public void setRecorde(int recorde) {
		this.recorde = recorde;
	}

	public int getRecorde() {
		return this.recorde;
	}

	public int getQuantidadeDeAcoes() {
		return this.quantidadeDeAcoes;
	}

	public String getNomeVencedor() {
		return nomeVencedor;
	}

	public void setNomeVencedor(String nomeVencedor) {
		this.nomeVencedor = nomeVencedor;
	}

	public void setQuantidadeDeAcoes(int quantidadeDeAcoes) {
		this.quantidadeDeAcoes = quantidadeDeAcoes;
	}

	public int getFaseNum() {
		return faseNum;
	}

	public TelaVenceu getTvDesafio() {
		return tvDesafio;
	}
	public TelaVenceu getTv() {
		return tv;
	}

}