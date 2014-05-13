package view;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.ModoDesafioControle;

public class ModoDesafio extends JFrameComIcone{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel bg;
	public ArrayList<Botao> dificuldade = new ArrayList<Botao>();
	public FaseModoDesafioGerenciador fase;

	public ModoDesafio() {
		super("Modo Desafio");
		setSize(600, 480);
		setLocationRelativeTo(null);
		instanciarVoltar(this.getWidth());
		add(this.voltar);

		bg = new JLabel(new ImageIcon(getClass().getResource(
				"imagens/modoDesafio.png")));
		bg.setBounds(0, 0, 600, 480);

		dificuldade.add(new Botao(new ImageIcon(getClass().getResource(
				"dificuldades/facil1.png")), new ImageIcon(getClass()
				.getResource("dificuldades/facil2.png")), "facil"));
		dificuldade.add(new Botao(new ImageIcon(getClass().getResource(
				"dificuldades/medio1.png")), new ImageIcon(getClass()
				.getResource("dificuldades/medio2.png")), "medio"));
		dificuldade.add(new Botao(new ImageIcon(getClass().getResource(
				"dificuldades/dificil1.png")), new ImageIcon(getClass()
				.getResource("dificuldades/dificil2.png")), "dificil"));
		dificuldade.add(new Botao(new ImageIcon(getClass().getResource(
				"dificuldades/muitodificil1.png")), new ImageIcon(getClass()
				.getResource("dificuldades/muitodificil2.png")),
				"muito dificil"));
		dificuldade.add(new Botao(new ImageIcon(getClass().getResource(
				"dificuldades/313371.png")), new ImageIcon(getClass()
				.getResource("dificuldades/313372.png")), "31337"));

		int x = 140;
		int y = 155;

		ModoDesafioControle control = new ModoDesafioControle(this);
		
		for (int i = 0; i < dificuldade.size(); i++) {
			if (i == 2) {
				x = 140;
				y += 80;
			} else if (i == 4) {
				y += 80;
				x = 140;
				x += 81;
			}
			dificuldade.get(i).setBounds(x, y, 150, 70);
			add(dificuldade.get(i));
			dificuldade.get(i).addMouseListener(control);
			x += 163;

		}

		add(bg);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setResizable(false);
		setVisible(true);
	}

}
