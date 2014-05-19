package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controle.ImagemComBotaoControle;

public class ImagemComBot�o extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton x;
	JLabel img;
	public ImagemComBot�o(ImageIcon img) {
		this.img = new JLabel(img);
		setLayout(null);
		
		x = new JButton("x");
		x.setBounds(320, 20, 45, 20);
		
		add(x);
		add(this.img);
		this.img.setBounds(0,0, img.getIconWidth(), img.getIconHeight());


		x.addActionListener(new ImagemComBotaoControle(this));
		
		setUndecorated(true);
		
	}

}
