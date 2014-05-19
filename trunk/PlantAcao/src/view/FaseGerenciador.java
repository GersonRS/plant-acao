package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controle.FaseGerenciadorControle;



public abstract class FaseGerenciador extends JFrameComIcone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageIcon imgBg;
	public JLabel bg;
	public Fase fase;

	public Fase getFase() {
		return fase;
	}
	public JButton play;
	public JButton stop;
	public JButton reset;
	public JButton duvida;
	public Componente comp;
	public ImagemComBot�o a��es;
	public FaseGerenciadorControle controle;
	
	public FaseGerenciador(int modo,String diretorioFase, int faseNum, int recorde,String[] nome) {
		super("Plant-A��o");

		imgBg = new ImageIcon(getClass().getResource("imagens/generico2.png"));

		if(modo==1){
			fase = new Fase(diretorioFase, faseNum, recorde);			
		}
		if(modo==2){
			fase = new Fase(diretorioFase, 0, nome);
		}
		
		bg = new JLabel(imgBg);
		a��es = new ImagemComBot�o(new ImageIcon(Principal.class.getResource("imagens/A��es.png")));
		a��es.setVisible(false);
		a��es.setBounds(0, 10, 600, 480);
		a��es.setModal(true);
		a��es.x.setLocation(550, 10);
		a��es.setLocationRelativeTo(this);	
		reset = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/reset.png")));
		stop = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/stop.png")));
		play = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/play.png")));
		duvida = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/duvida.png")));
		
		stop.setVisible(false);

		controle = new FaseGerenciadorControle(this);
		
		play.addActionListener(controle);
		stop.addActionListener(controle);
		reset.addActionListener(controle);
		duvida.addActionListener(controle);
		
	}
}
