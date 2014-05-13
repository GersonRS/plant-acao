package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


import modelo.Constante;


public class FaseModoDesafioGerenciador extends FaseGerenciador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel textoJogador;
	JLabel faseDesafio;
	public FaseModoDesafioGerenciador(String dificuldade, String[]nome) {
		super();
		
		setSize(800, 600);
		setLocationRelativeTo(null);

		
		fase = new Fase(dificuldade, 0, nome);
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

		

		fase.tv.botoes.get(1).addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					fase.faseModelo.resetFase();
					comp.resetar();
					setTextoJogador(1);
					stop.setVisible(false);
					play.setVisible(true);
					fase.tv.setVisible(false);
					fase.jogador = 1;
					
					
				}
			});


		bg.setBounds(4,107,imgBg.getIconWidth(),imgBg.getIconHeight());
		fase.setLocation(4, 283);

		comp.setBounds(Constante.xComponente + 25, 0, Constante.widthComponente, Constante.heightComponente);
		
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


