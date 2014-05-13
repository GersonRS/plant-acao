package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Player;



public class TelaVenceu extends JDialog  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Botao> botoes = new ArrayList<Botao>();
	public JLabel img;
	public JLabel qtdComandos;
	public JLabel recorde;
	public JLabel nomeJogador;
	public JLabel textoResultado;

	public TelaVenceu(ImageIcon img) {
		this.img = new JLabel(img);
		setUndecorated(true);
		setSize(400, 300);

		this.img.setVisible(true);
		this.img.setBounds(0, 0, 400, 300);

		qtdComandos = new JLabel("--");
		qtdComandos.setBounds(280, 105, 100, 20);
		qtdComandos.setFont(new Font("Arial", Font.BOLD, 20));
		qtdComandos.setForeground(Color.BLACK);
		add(qtdComandos);

		recorde = new JLabel("--");
		recorde.setBounds(105, 135, 100, 20);
		recorde.setFont(new Font("Arial", Font.BOLD, 20));
		recorde.setForeground(Color.BLACK);
		add(recorde);
		int x = 40;
		for(int i = 0; i < 3; i++) {
			botoes.add(new Botao(new ImageIcon(getClass().getResource("imagens/vencer/botao"+(i+1)+".2.png")),
					new ImageIcon(getClass().getResource("imagens/vencer/botao"+(i+1)+".1.png")), "botao"+(i+1)));

			botoes.get(i).setBounds(x, 190, 72, 72);
			botoes.get(i).addMouseListener(new TratarBotao());
			add(botoes.get(i));
			x+=110;

		}

		add(this.img);
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

	public TelaVenceu(ImageIcon img, String[] player) {
		this.img = new JLabel(img);
		setUndecorated(true);
		setSize(400, 300);
		this.img.setVisible(true);
		this.img.setBounds(0, 0, 400, 300);
		qtdComandos = new JLabel("--");
		qtdComandos.setBounds(280, 105, 100, 20);
		qtdComandos.setFont(new Font("Arial", Font.BOLD, 20));
		qtdComandos.setForeground(Color.BLACK);
		add(qtdComandos);

		nomeJogador = new JLabel("--");
		nomeJogador.setBounds(105, 135, 100, 20);
		nomeJogador.setFont(new Font("Arial", Font.BOLD, 20));
		nomeJogador.setForeground(Color.BLACK);
		add(nomeJogador);
		int x = 95;
		for(int i = 1; i < 3; i++) {
			botoes.add(new Botao(new ImageIcon(getClass().getResource("imagens/vencer/botao"+(i+1)+".2.png")),
					new ImageIcon(getClass().getResource("imagens/vencer/botao"+(i+1)+".1.png")), "botao"+(i+1)));

			botoes.get(i-1).setBounds(x, 190, 72, 72);
			botoes.get(i-1).addMouseListener(new TratarBotao());
			add(botoes.get(i-1));
			x+=110;

		}

		add(this.img);
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}
	public void setImagem(ImageIcon img) {
		this.img = new JLabel(img);
		this.img.setBounds(0, 0, 400, 300);
		add(this.img);

	}
	public void setVencedor(Player p[], String nome) {
		String txt = String.format("<html>%s: %d comandos <br>%s: %d comandos<br>Vencedor: %s</html>", p[0].getNome(), p[0].getComandos(), p[1].getNome(), p[1].getComandos(), nome);

		textoResultado = new JLabel(txt);
		this.textoResultado.setBounds(10, 40, 280, 200);
		this.textoResultado.setFont(new Font("Arial", Font.BOLD, 20));
		this.textoResultado.setForeground(new Color(0, 51, 0));
		add(this.textoResultado);
	}
	public TelaVenceu() {
		setUndecorated(true);
		setSize(400, 300);
		botoes.add(new Botao(new ImageIcon(getClass().getResource("imagens/vencer/botao4.2.png")),
				new ImageIcon(getClass().getResource("imagens/vencer/botao4.1.png")), "botao4"));

		botoes.get(0).setBounds(150, 190, 72, 72);
		botoes.get(0).addMouseListener(new TratarBotao());
		add(botoes.get(0));
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}
	public void setNome(Player p) {

		nomeJogador.setText(p.getNome());
	}

	public ArrayList<Botao> getBotoes() {
		return botoes;
	}

	private class TratarBotao implements MouseListener {

		public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {
			for(int i = 0; i < botoes.size(); i++) {
				if(e.getSource() == botoes.get(i))
					botoes.get(i).mudarIcone(e);

			}

		}

		public void mouseExited(MouseEvent e) {
			for(int i = 0; i < botoes.size(); i++) {
				if(e.getSource() == botoes.get(i))
					botoes.get(i).mudarIcone(e);

			}

		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}

	}

}
