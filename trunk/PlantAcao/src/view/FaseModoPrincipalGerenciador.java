package view;

import controle.FaseModoPrincipralGerenciadorControle;


@SuppressWarnings("serial")
public class FaseModoPrincipalGerenciador extends FaseGerenciador {
	
	private FaseModoPrincipralGerenciadorControle controle;

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
		
		controle = new FaseModoPrincipralGerenciadorControle(this);
		
		bg.setBounds(4,4,imgBg.getIconWidth(),imgBg.getIconHeight());
		fase.setLocation(4, 180);

		fase.tv.botoes.get(0).addMouseListener(controle);
		
		fase.tv.botoes.get(2).addMouseListener(controle);
		

		comp.setBounds(Componente.xComponente-5, 0, Componente.widthComponente, Componente.heightComponente);

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
