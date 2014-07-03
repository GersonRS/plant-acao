package view;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.ControleFase;
import control.ControleMenuDesafio;
import control.ControleMenuInicial;
import control.ControleMenuPrincipal;
import control.ControleTelaAcoes;
import control.ControleTelaAjuda;
import control.ControleTelaCredito;

@SuppressWarnings("serial")
public class Controladora extends JFrame implements LoopSteps {

//	private Dimension dimTela = Toolkit.getDefaultToolkit().getScreenSize();
	private Graphics2D g2d;
	private BufferedImage buffer;
	private List<Tela> listaDeTelas;
	private int LARGURA = 600;
	private int ALTURA = 480;
	private Image imagem1;
	private Image imagem2;
	private ControleMenuInicial controleMenuInicial;
	private ControleMenuPrincipal controleMenuFase;
	private ControleMenuDesafio controleMenuDesafio;
	private ControleTelaAjuda controleTelaAjuda;
	private ControleTelaAcoes controleTelaAcoes;
	private ControleTelaCredito controleTelaCredito;
	private ControleFase controleFase;
	private MainLoop mainLoop;

	private volatile float alpha = 1.0f;
	private float add = -0.02f;
	private boolean fadeIn = false;
	private int estado = 0;

	public Controladora() {
		super("Plant-Ação");
//		LARGURA = dimTela.width;
//		ALTURA = dimTela.height;
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		mainLoop = new MainLoop(this);
		new Thread(mainLoop).start();
	}

	@Override
	public void paintScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.drawImage(buffer, 0, 0, null);

	}

	@Override
	public void processLogics() {

		for (int i = 0; i < listaDeTelas.size(); i++) {
			listaDeTelas.get(i).desenharMenu();
		}
		estadoImagem();

	}

	@Override
	public void renderGraphics() {

		buffer = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		g2d = buffer.createGraphics();
		g2d.drawImage(imagem2, 0, 0, null);
		g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
		g2d.drawImage(imagem1, 0, 0, null);

		g2d.dispose();

	}

	@Override
	public void setup() {
		listaDeTelas = new ArrayList<Tela>();
		listaDeTelas.add(new TelaMenuInicial(LARGURA, ALTURA));
		listaDeTelas.add(new TelaModoPrincipal(LARGURA, ALTURA));
		listaDeTelas.add(new TelaModoDesafio(LARGURA, ALTURA));
		listaDeTelas.add(new TelaAjuda(LARGURA, ALTURA));
		listaDeTelas.add(new TelaAcoes(LARGURA, ALTURA));
		listaDeTelas.add(new TelaCredito(LARGURA, ALTURA));
		listaDeTelas.add(new TelaFase(LARGURA+168, ALTURA));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sair();
			}
		});
		controleMenuInicial = new ControleMenuInicial(this);
		controleMenuFase = new ControleMenuPrincipal(this);
		controleMenuDesafio = new ControleMenuDesafio(this);
		controleTelaAjuda = new ControleTelaAjuda(this);
		controleTelaAcoes = new ControleTelaAcoes(this);
		controleTelaCredito = new ControleTelaCredito(this);
		controleFase = new ControleFase(this);
		addMouseMotionListener(controleMenuInicial);
		addMouseListener(controleMenuInicial);
	}

	public void sair() {
		if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?",
				"Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void tearDown() {
		// TODO metodo paraquando o jogo for parado ou fechado.
	}

	public void vaiParaTelaMenuInicial() {
		removeMouseListener(controleMenuFase);
		removeMouseMotionListener(controleMenuFase);
		removeMouseListener(controleMenuDesafio);
		removeMouseMotionListener(controleMenuDesafio);
		removeMouseListener(controleTelaAjuda);
		removeMouseMotionListener(controleTelaAjuda);
		removeMouseListener(controleTelaAcoes);
		removeMouseMotionListener(controleTelaAcoes);
		removeMouseListener(controleTelaCredito);
		removeMouseMotionListener(controleTelaCredito);
		addMouseMotionListener(controleMenuInicial);
		addMouseListener(controleMenuInicial);
		fadeIn = false;
		estado = 0;
		alpha = 1.0f;
		for (int i = 1; i < listaDeTelas.size(); i++) {
			listaDeTelas.get(i).setAtiva(false);
		}
	}

	public void vaiParaTelaMenuFase() {
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		addMouseMotionListener(controleMenuFase);
		addMouseListener(controleMenuFase);
		LARGURA = 600;
		ALTURA = 480;
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		fadeIn = false;
		estado = 5;
		alpha = 1.0f;
	}

	private void vaiParaTelaMenuDesafio() {
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		addMouseMotionListener(controleMenuDesafio);
		addMouseListener(controleMenuDesafio);
		fadeIn = false;
		estado = 6;
		alpha = 1.0f;
	}

	public void vaiParaTelaAjuda() {
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		addMouseMotionListener(controleTelaAjuda);
		addMouseListener(controleTelaAjuda);
		fadeIn = false;
		estado = 7;
		alpha = 1.0f;
	}

	public void vaiParaTelaAcoes() {
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		addMouseMotionListener(controleTelaAcoes);
		addMouseListener(controleTelaAcoes);
		fadeIn = false;
		estado = 8;
		alpha = 1.0f;
	}

	public void vaiParaTelaCredito() {
		removeMouseListener(controleMenuInicial);
		removeMouseMotionListener(controleMenuInicial);
		addMouseMotionListener(controleTelaCredito);
		addMouseListener(controleTelaCredito);
		fadeIn = false;
		estado = 9;
		alpha = 1.0f;
	}
	public void vaiParaTelaFase() {
		removeMouseListener(controleMenuFase);
		removeMouseMotionListener(controleMenuFase);
		addMouseMotionListener(controleFase);
		addMouseListener(controleFase);
		LARGURA = 768;
		ALTURA = 500;
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		fadeIn = false;
		estado = 11;
		alpha = 1.0f;
	}

	public void estadoImagem() {
		switch (estado) {
		// menuInicial-menuPrincipal
		case 0: {
			imagem1 = listaDeTelas.get(0).getTelaImagem();
			imagem2 = listaDeTelas.get(1).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuFase();
				}
			}
			break;
		}
		// menuInicial-menuDesafio
		case 1: {
			imagem1 = listaDeTelas.get(0).getTelaImagem();
			imagem2 = listaDeTelas.get(2).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuDesafio();
				}
			}
			break;
		}
		// menuInicial-telaAjuda
		case 2: {
			imagem1 = listaDeTelas.get(0).getTelaImagem();
			imagem2 = listaDeTelas.get(3).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaAjuda();
				}
			}
			break;
		}
		// menuInicial-telaAcoes
		case 3: {
			imagem1 = listaDeTelas.get(0).getTelaImagem();
			imagem2 = listaDeTelas.get(4).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaAcoes();
				}
			}
			break;
		}
		// menuInicial-telaCreditos
		case 4: {
			imagem1 = listaDeTelas.get(0).getTelaImagem();
			imagem2 = listaDeTelas.get(5).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaCredito();
				}
			}
			break;
		}
		// menuPrincipal-menuInicial
		case 5: {
			imagem1 = listaDeTelas.get(1).getTelaImagem();
			imagem2 = listaDeTelas.get(0).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuInicial();
				}
			}
			break;
		}// menuDesafio-menuInicial
		case 6: {
			imagem1 = listaDeTelas.get(2).getTelaImagem();
			imagem2 = listaDeTelas.get(0).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuInicial();
				}
			}
			break;
		}
		// telaAjuda-menuInicial
		case 7: {
			imagem1 = listaDeTelas.get(3).getTelaImagem();
			imagem2 = listaDeTelas.get(0).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuInicial();
				}
			}
			break;
		}
		// telaAcoes-menuInicial
		case 8: {
			imagem1 = listaDeTelas.get(4).getTelaImagem();
			imagem2 = listaDeTelas.get(0).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuInicial();
				}
			}
			break;
		}
		// telaCredito-menuInicial
		case 9: {
			imagem1 = listaDeTelas.get(5).getTelaImagem();
			imagem2 = listaDeTelas.get(0).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuInicial();
				}
			}
			break;
		}
		//MenuModoPrincipal-Fase
		case 10: {
			imagem1 = listaDeTelas.get(1).getTelaImagem();
			imagem2 = listaDeTelas.get(6).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaFase();
				}
			}
			break;
		}
		//Fase-TelaModoPrincipal
		case 11: {
			imagem1 = listaDeTelas.get(6).getTelaImagem();
			imagem2 = listaDeTelas.get(1).getTelaImagem();
			if (fadeIn) {
				alpha += add;
				if (alpha < 0.02) {
					vaiParaTelaMenuFase();
				}
			}
			break;
		}
		default:
			System.out.println("erro");
			break;
		}
	}

	public void setEstado(int estado) {
		this.estado = estado;
		fadeIn = true;
	}

	public Tela getTela(int index) {
		return listaDeTelas.get(index);
	}

	public static void main(String[] args) {
		new Controladora();
	}
}
