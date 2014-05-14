package view;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Save;
import controle.ModoPrincipalControle;



public class ModoPrincipal extends JFrameComIcone{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FaseModoPrincipalGerenciador fase;
	public ArrayList<BotaoFase> b = new ArrayList<BotaoFase>();
	public JLabel bg;
	public Save save;
	public ArrayList<String> s;
	public JLabel nome, comandos, icone;
	public ModoPrincipal() {
		super("Modo Principal");
		
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		
		instanciarVoltar(this.getWidth());
		add(this.voltar);

		save = new Save();
		this.criarBotoes();
		
		nome = new JLabel("Nenhum");
		nome.setBounds(210, 375, 250, 20);
		nome.setFont(new Font("Arial", Font.BOLD, 20));
		nome.setForeground(new Color(51, 51, 51));
		
		comandos = new JLabel("--");
		comandos.setBounds(250, 396, 100, 20);
		comandos.setFont(new Font("Arial", Font.BOLD, 20));
		comandos.setForeground(new Color(51, 51, 51));
		
		icone = new JLabel();
		icone.setSize(66, 66);
		icone.setLocation(70, 353);
		
		
		add(nome);
		add(comandos);
		add(icone);
		bg = new JLabel(new ImageIcon(getClass().getResource("imagens/modoPrincipal.png")));
		bg.setBounds(0, 0, 600, 480);
		add(bg);
		

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void criarBotoes() {
		int x = 80, y = 132;
		s = save.carregarSave();
		int controle = 0;
		
		ModoPrincipalControle control = new ModoPrincipalControle(this);
		
		for(int i = 0; i < 10; i++) {
			
			if(i == 5) { y+=94; x = 80; }
			
			b.add( new BotaoFase(new ImageIcon(getUrl((i+1), 1)), new ImageIcon(getUrl((i+1), 2)), s.get(controle).equalsIgnoreCase("1"), (i+1)+"" ) );
			b.get(i).setBounds(x, y, 66, 66);

			add(b.get(i));
			b.get(i).addMouseListener(control);
			x+=94;
			
			controle += 3;
		}
		carregarBotoes(false);
		
	}
	
	public void carregarBotoes(boolean alterado) {
		int controle = 0;
		if(alterado) s = save.carregarSave();
		for(int i = 0; i < 10; i++) {
			if(s.get(controle).equalsIgnoreCase("1")) 
				b.get(i).setIconAtivo();
			b.get(i).setComandos(Integer.parseInt(s.get(controle + 1)));
			b.get(i).setNomeVencedor(s.get(controle+2));
			
			controle += 3;
		}
	}
	public URL getUrl(int i, int j) {
		
		return getClass().getResource(String.format("imagens/fases/%d.%d.png", i, j));
	}
}