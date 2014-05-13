package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



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
	public ImagemComBotão ações;
	public FaseGerenciador() {
		super("Plant-Ação");

		imgBg = new ImageIcon(getClass().getResource("imagens/generico2.png"));

		bg = new JLabel(imgBg);
		ações = new ImagemComBotão(new ImageIcon(Principal.class.getResource("imagens/Ações.png")));
		ações.setVisible(false);
		ações.setBounds(0, 10, 600, 480);
		ações.setModal(true);
		ações.x.setLocation(550, 10);
		ações.setLocationRelativeTo(this);	
		reset = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/reset.png")));
		stop = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/stop.png")));
		play = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/play.png")));
		duvida = new JButton(new ImageIcon(FaseGerenciador.class.getResource("imagens/duvida.png")));
		
		duvida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ações.setVisible(true);
			}
		});
		
		stop.setVisible(false);
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				play.setVisible(true);
				stop.setVisible(false);
				fase.faseModelo.resetFase();
			}
		});

		play.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				
				ArrayList<String> comandos = new ArrayList<String>();
				ArrayList<String> comandoFuncao = new ArrayList<String>();
				String func="";
				int quantidadeDeAcoes = 0;
				for(int i = 0; i < comp.sequenciaPrincipal.size(); i++) {
					if(comp.sequenciaPrincipal.get(i).getMovimento().equalsIgnoreCase("f1")) {

						for(int j = 0; j < comp.sequenciaFuncao.size(); j++) {

							if(! comp.sequenciaFuncao.get(j).getMovimento().equalsIgnoreCase("")) {
								func = comp.sequenciaFuncao.get(j).getMovimento();
								comandos.add(func);
								comandoFuncao.add(func);
							}
						}						


					} else {
						if(!comp.sequenciaPrincipal.get(i).getMovimento().equalsIgnoreCase("")) {
							comandos.add(comp.sequenciaPrincipal.get(i).getMovimento());
							
						} else {
						}
					}

					func = "";
				}
				
				for(int i = 0; i < comp.sequenciaPrincipal.size(); i++)
					if(!comp.sequenciaPrincipal.get(i).getMovimento().equalsIgnoreCase(""))
						quantidadeDeAcoes++;
				for(int i = 0; i < comp.sequenciaFuncao.size(); i++)
					if(!comp.sequenciaFuncao.get(i).getMovimento().equalsIgnoreCase(""))
						quantidadeDeAcoes++;
				
				fase.faseModelo.realizarAcao(comandos, comandoFuncao, quantidadeDeAcoes);
				
				play.setVisible(false);
				stop.setVisible(true);

			}
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente resetar todos os comandos?", "Restar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					comp.resetar();
				
			}
		});
	}
}
