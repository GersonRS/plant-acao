package view;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameComIcone extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton voltar;
	ImageIcon imgVoltar;
	public JFrameComIcone(String titulo) {
		super(titulo);
		

		Image icone = new ImageIcon(JFrameComIcone.class.getResource("resource/iconImagem.png")).getImage();
		setIconImage(icone);
		imgVoltar = new ImageIcon(JFrameComIcone.class.getResource("resource/voltar.png"));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		setLayout(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}
	
	public void instanciarVoltar(int width) {
		this.voltar = new JButton(this.imgVoltar);
		this.voltar.setBounds(width-27, 0, 22, 20);
	}
	
}
