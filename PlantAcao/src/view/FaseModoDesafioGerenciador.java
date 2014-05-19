package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controle.FaseModoDesafioGerenciadorControle;


public class FaseModoDesafioGerenciador extends FaseGerenciador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FaseModoDesafioGerenciadorControle controle;
	
	JLabel textoJogador;
	JLabel faseDesafio;
	public FaseModoDesafioGerenciador(String dificuldade, String[]nome) {
		super(2,dificuldade,0,0,nome);
		
		setSize(800, 600);
		setLocationRelativeTo(null);

		comp = new ComponenteModoDesafio();
		faseDesafio = new JLabel(new ImageIcon(getClass().getResource("imagens/textoDesafio.png")));
		faseDesafio.setBounds(10, 0, 350, 61);
		textoJogador = new JLabel();
		setTextoJogador(0);
		add(textoJogador);
		instanciarVoltar(this.getWidth());
		add(this.voltar);
		
		reset.setBounds(84, 530, 64, 32);
		stop.setBounds(16, 530, 64, 32);
		play.setBounds(16, 530, 64, 32);
		duvida.setBounds(152, 530, 25, 34);

		controle = new FaseModoDesafioGerenciadorControle(this);

		fase.tv.botoes.get(1).addMouseListener(controle);


		bg.setBounds(4,107,imgBg.getIconWidth(),imgBg.getIconHeight());
		fase.setLocation(4, 283);

		comp.setBounds(Componente.xComponente + 25, 0, Componente.widthComponente, Componente.heightComponente);
		
		add(faseDesafio);
		add(bg);
		add(comp);
		add(fase);
		add(stop);
		add(play);
		add(reset);
		add(duvida);

		setVisible(true);
	}
	
	public void setTextoJogador(int num) {
		textoJogador.setText("<html>Vez do jogador: "+fase.player[num].getNome() + "<br>" + "Recorde: "+(fase.getRecorde() != 0 ? fase.getRecorde() : "--") +"</html>");
		textoJogador.setFont(new Font("Arial", Font.BOLD, 15));
		textoJogador.setBounds(15, 65, 300, 30);
	}
}


