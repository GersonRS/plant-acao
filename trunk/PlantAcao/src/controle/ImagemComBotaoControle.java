package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ImagemComBot�o;

public class ImagemComBotaoControle implements ActionListener {

	private ImagemComBot�o imgBotao;
	
	public ImagemComBotaoControle(ImagemComBot�o imgBotao) {
		this.imgBotao = imgBotao;
	}

	public void actionPerformed(ActionEvent e) {
		imgBotao.setVisible(false);
	}

}
