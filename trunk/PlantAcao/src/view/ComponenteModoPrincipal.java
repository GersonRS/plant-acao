package view;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class ComponenteModoPrincipal extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComponenteModoPrincipal() {
		super();
		
		int inc = 36;
		int x = 0, y = 110;
		int n = 30;
		int j = 0;
		int incY = 0;

		sequenciaPrincipal = new ArrayList<Acao>(); 
		for(int i = 0; i < n; i++) {
			if(i > 0 && i % 10==0 ) {
				incY += inc;
				j = 0;
			}
			sequenciaPrincipal.add(new Acao());
			sequenciaPrincipal.get(i).setBounds(x + inc * j, y + incY, 32, 32);
			j++;
			add(sequenciaPrincipal.get(i));
		}

		x = 0;
		y = 500-220;
		n = 10;
		j = 0;
		incY = 0;
		
		sequenciaFuncao = new ArrayList<Acao>(); 
		for(int i = 0; i < 10; i++) {
			if(i == 10) {
				incY += inc;
				j = 0;
			}
			sequenciaFuncao.add(new Acao());
			sequenciaFuncao.get(i).setBounds(x + inc * j, y + incY, 32, 32);
			j++;
			add(sequenciaFuncao.get(i));
		}








		imgComponente = new ImageIcon(getClass().getResource("imagens/metodosModoPrincipal.png"));
		lblComp = new JLabel(imgComponente);


		lblComp.setBounds(0, 88, imgComponente.getIconWidth(), imgComponente.getIconHeight());

		add(lblComp);
	}
}
