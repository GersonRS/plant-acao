package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import modelo.Constante;
import modelo.Save;


@SuppressWarnings("serial")
public class FaseModoPrincipalGerenciador extends FaseGerenciador {
	

	public FaseModoPrincipalGerenciador(String diretorioFase, int faseNum, int recorde) {
		super();
		
		setSize(768, 500);
		setLocationRelativeTo(null);

		fase = new Fase(diretorioFase, faseNum, recorde);
		comp = new ComponenteModoPrincipal();
		instanciarVoltar(this.getWidth());
		add(this.voltar);
		reset.setBounds(84, 430, 64, 32);
		stop.setBounds(16, 430, 64, 32);
		play.setBounds(16, 430, 64, 32);
		duvida.setBounds(152, 430, 26, 34);
		
		
		
		bg.setBounds(4,4,imgBg.getIconWidth(),imgBg.getIconHeight());
		fase.setLocation(4, 180);

		fase.tv.botoes.get(0).addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fase.setFocusable(true);
				fase.faseModelo.resetFase();
				fase.tv.setVisible(false);
				stop.setVisible(false);
				play.setVisible(true);
				
			}
		});
		
		fase.tv.botoes.get(2).addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(fase.getFaseNum()!=10) {
					Save s = new Save();
					ArrayList<String> save = s.carregarSave();
					fase.tv.setVisible(false);
					stop.setVisible(false);
					play.setVisible(true);
					fase.faseModelo.carregarFase("fase"+(fase.getFaseNum()+1)+".txt");
					fase.setFaseNum(fase.getFaseNum()+1);
					fase.setRecorde(Integer.parseInt(save.get((fase.getFaseNum()+1) * 3 + 1)) );
					fase.faseModelo.resetFase();
					comp.resetar();
				}
			}
		});
		

		comp.setBounds(Constante.xComponente-5, 0, Constante.widthComponente, Constante.heightComponente);

		add(bg);
		add(comp);
		add(fase);
		add(stop);
		add(play);
		add(reset);
		add(duvida);
		setVisible(true);


		
	}
}
