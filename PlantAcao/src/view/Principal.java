package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controle.PrincipalControle;

public class Principal extends JFrameComIcone{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Botao> botoes = new ArrayList<Botao>();
	JLabel fundo;
	public ImagemComBot�o sobre;
	public ImagemComBot�o a��es;
	public ImagemComBot�o ajuda;
	public JFrame frameA��es;
	public ModoPrincipal mp;
	public ModoDesafio md;
	public Principal() {
		super("Plant-A��o");
		setSize(600, 480);
		
		sobre = new ImagemComBot�o(new ImageIcon(getClass().getResource("imagens/cr�ditos.png")));
		sobre.setLocationRelativeTo(this);
		sobre.setModal(true);
		sobre.setBounds(100, 50, 400, 300);
		sobre.setLocationRelativeTo(this);
		
		a��es = new ImagemComBot�o(new ImageIcon(getClass().getResource("imagens/A��es.png")));
		a��es.setVisible(false);
		a��es.setBounds(0, 0, 600, 480);
		a��es.x.setLocation(550, 10);
		a��es.setModal(true);
		a��es.setLocationRelativeTo(this);
		
		ajuda = new ImagemComBot�o(new ImageIcon(getClass().getResource("imagens/ajuda.png")));
		ajuda.setVisible(false);
		ajuda.setBounds(0, 0, 600, 480);
		ajuda.x.setLocation(550, 10);
		ajuda.setModal(true);
		ajuda.setLocationRelativeTo(this);

		botoes.add(new Botao("modoPrincipal"));
		botoes.add(new Botao("modoDesafio"));
		botoes.add(new Botao("ajuda"));
		botoes.add(new Botao("acoes"));
		botoes.add(new Botao("cr�ditos"));
		botoes.add(new Botao("sair"));

		fundo = new JLabel(new ImageIcon(getClass().getResource("imagens/fundo.png")));

		PrincipalControle controle = new PrincipalControle(this);
		
		fundo.setBounds(0, 0, 600, 480);
		for(int i = 0; i < botoes.size(); i++) {
			botoes.get(i).setBounds(50, 68*i+12, 128, 64);
			add(botoes.get(i));
			botoes.get(i).addMouseListener(controle);
		}

		add(fundo);
		setLocationRelativeTo(null);
		setVisible(true);
	}

		public static void main(String[] args) {
			new Principal();

		}

	}
