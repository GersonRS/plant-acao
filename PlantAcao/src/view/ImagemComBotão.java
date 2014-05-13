package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ImagemComBotão extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton x;
	JLabel img;
	public ImagemComBotão(ImageIcon img) {
		this.img = new JLabel(img);
		setLayout(null);
		
		x = new JButton("x");
		x.setBounds(320, 20, 45, 20);
		
		add(x);
		add(this.img);
		this.img.setBounds(0,0, img.getIconWidth(), img.getIconHeight());


		x.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		
	}

}
