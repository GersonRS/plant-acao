package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ImagemComBotão;

public class ImagemComBotaoControle implements ActionListener {

	private ImagemComBotão imgBotao;
	
	public ImagemComBotaoControle(ImagemComBotão imgBotao) {
		this.imgBotao = imgBotao;
	}

	public void actionPerformed(ActionEvent e) {
		imgBotao.setVisible(false);
	}

}
