package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.FaseModelo;

import view.FaseGerenciador;

public class FaseGerenciadorControle implements ActionListener {

	private FaseGerenciador faseGerenciador;
	private FaseModelo faseModelo;
	
	public FaseGerenciadorControle(FaseGerenciador faseGerenciador) {
		this.faseGerenciador = faseGerenciador;
		this.faseModelo = faseGerenciador.fase.faseModelo;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==faseGerenciador.duvida){
			faseGerenciador.ações.setVisible(true);
		}

		if(e.getSource()==faseGerenciador.stop){

			faseGerenciador.play.setVisible(true);
			faseGerenciador.stop.setVisible(false);
			faseModelo.resetFase();
		}

		if(e.getSource()==faseGerenciador.play){

				ArrayList<String> comandos = new ArrayList<String>();
				ArrayList<String> comandoFuncao = new ArrayList<String>();
				String func = "";
				int quantidadeDeAcoes = 0;
				for (int i = 0; i < faseGerenciador.comp.sequenciaPrincipal.size(); i++) {
					if (faseGerenciador.comp.sequenciaPrincipal.get(i).getMovimento()
							.equalsIgnoreCase("f1")) {

						for (int j = 0; j < faseGerenciador.comp.sequenciaFuncao.size(); j++) {

							if (!faseGerenciador.comp.sequenciaFuncao.get(j).getMovimento()
									.equalsIgnoreCase("")) {
								func = faseGerenciador.comp.sequenciaFuncao.get(j)
										.getMovimento();
								comandos.add(func);
								comandoFuncao.add(func);
							}
						}

					} else {
						if (!faseGerenciador.comp.sequenciaPrincipal.get(i).getMovimento()
								.equalsIgnoreCase("")) {
							comandos.add(faseGerenciador.comp.sequenciaPrincipal.get(i)
									.getMovimento());

						} else {
						}
					}

					func = "";
				}

				for (int i = 0; i < faseGerenciador.comp.sequenciaPrincipal.size(); i++)
					if (!faseGerenciador.comp.sequenciaPrincipal.get(i).getMovimento()
							.equalsIgnoreCase(""))
						quantidadeDeAcoes++;
				for (int i = 0; i < faseGerenciador.comp.sequenciaFuncao.size(); i++)
					if (!faseGerenciador.comp.sequenciaFuncao.get(i).getMovimento()
							.equalsIgnoreCase(""))
						quantidadeDeAcoes++;

				faseModelo.realizarAcao(comandos, comandoFuncao,
						quantidadeDeAcoes);

				faseGerenciador.play.setVisible(false);
				faseGerenciador.stop.setVisible(true);

		}

		if(e.getSource()==faseGerenciador.reset){
				if (JOptionPane.showConfirmDialog(null,
						"Deseja realmente resetar todos os comandos?",
						"Restar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					faseGerenciador.comp.resetar();

		}
	}
}
