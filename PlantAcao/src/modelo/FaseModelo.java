package modelo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import view.Fase;



public class FaseModelo {

	public Fase classFase;
	public Thread thread;
	
	public FaseModelo(Fase fase) {
		this.classFase = fase;
	}
	public void gerarFaseAleatoria(String dificuldade) {
		if(dificuldade.equalsIgnoreCase("facil")) {
			ArrayList<Point> posicao = gerarAleatorio();  


			for(int i = 0; i < 3; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = 0;
			}
			
			classFase.fase[posicao.get(3).y][posicao.get(3).x] = (( int ) ( Math.random() * 3 ) ) + 8;

		} else if(dificuldade.equalsIgnoreCase("medio")) {

			ArrayList<Point> posicao = gerarAleatorio();
			for(int i = 0; i < 3; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = Constante.TERRA;
			}
			for(int i = 3; i < 5; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("dificil")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 5; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = Constante.TERRA;
			}

			for(int i = 5; i < 10; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = classFase.fase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("muito dificil")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 4; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = Constante.TERRA;
			}

			for(int i = 4; i < 15; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = classFase.fase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("31337")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 10; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = Constante.TERRA;
			}

			for(int i = 10; i < 20; i++) {
				classFase.fase[posicao.get(i).y][posicao.get(i).x] = classFase.fase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}

		}

		setEstaFase();

	}
	public ArrayList<Point> gerarAleatorio() {
		ArrayList<Point> posicao = new ArrayList<Point>();  
		for (int i = 0; i < 10; i++) {  
			for(int j = 0; j < 20; j++) {
				posicao.add(new Point(j , i));
			}
		}  

		Collections.shuffle(posicao);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 20; j++) {
				classFase.fase[i][j] = 20;
			}
		}

		return posicao;
	}

	public void setTilePoints() {
		int x = 16, y = 64;
		int width = 16;
		int height = 16;
		int nx = 20;
		int ny = 10;
		// fase 10x20 tiles

		for(int i = 0; i < ny; i++) {
			for(int j = 0; j < nx; j++) {
				classFase.faseRec[i][j] = new Point(x, y);
				x += width;
			}

			x = 16;
			y += height;


		}

	}
	
	public void carregarFase(String diretorio) {

		InputStream is = getClass().getResourceAsStream("fases/"+diretorio);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);

		ArrayList<String> arqText = new ArrayList<String>();

		try {

			while(in.ready())
				arqText.add(in.readLine());

			for(int i = 0; i < arqText.size(); i++) {
				String aux = arqText.get(i).replace(".", "");
				arqText.set(i, aux);
			}

			for(int i = 0; i < arqText.size(); i++) {
				int começo = 0;
				int fim = 2;
				int k = 0;
				for (int j = 0; j < arqText.get(i).length(); j+=2) {
					String tile = arqText.get(i).substring(começo, fim);
					classFase.fase[i][k] = Integer.parseInt(tile); 
					começo += 2;
					fim += 2;
					k++;
				}

			}


			in.close();
			is.close();
			isr.close();

			setEstaFase();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void setEstaFase() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				classFase.estaFase[i][j] = classFase.fase[i][j];
			}
		}
	}
	
//	public void verificarSePisouEmTerraPlantada() {
	//		
	//		if(fase1[personagem.getI()][personagem.getJ()] == Constante.TERRA_PLANTADA_MOLHADA) {
	//			fase1[personagem.getI()][personagem.getJ()] = Constante.TERRA_ARADA;
	//			repaint();
	//		}
	//			
	//	}

	public boolean verificarFase(int constante, int incremento) {
		if(classFase.personagem.getDirecao().equalsIgnoreCase("baixo")) {
			if(classFase.personagem.getI()+1 < 10)		
				if(classFase.fase[classFase.personagem.getI()+1][classFase.personagem.getJ()] == constante) {
					classFase.fase[classFase.personagem.getI() + 1][classFase.personagem.getJ()] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("cima")) {
			if(classFase.personagem.getI()-1 >= 0)		
				if(classFase.fase[classFase.personagem.getI() - 1][classFase.personagem.getJ()] == constante) {
					classFase.fase[classFase.personagem.getI() - 1][classFase.personagem.getJ()] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("direita")) {
			if(classFase.personagem.getJ() + 1 < 20)		
				if(classFase.fase[classFase.personagem.getI()][classFase.personagem.getJ() + 1] == constante) {
					classFase.fase[classFase.personagem.getI()][classFase.personagem.getJ() + 1] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("esquerda")) {
			if(classFase.personagem.getJ()-1 >= 0)		
				if(classFase.fase[classFase.personagem.getI()][classFase.personagem.getJ() - 1] == constante) {
					classFase.fase[classFase.personagem.getI()][classFase.personagem.getJ() - 1] = constante + incremento;
					return true;
				}
		}
		return false;
	}

	public ArrayList<Point> encontrarTerraPlantada() {
		ArrayList<Point> posicao = new ArrayList<Point>();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 20; j++) {
				if(classFase.fase[i][j] == Constante.TERRA_PLANTADA_MOLHADA)
					posicao.add(new Point(j, i));
			}
		}
		return posicao;
	}
	
	public void nascerPlantas(ArrayList<Point> pos, int frame) {
		for(int i = 0; i < pos.size(); i++) {
			classFase.fase[pos.get(i).y][pos.get(i).x] = frame;
		}
		
	}
	
	public void realizarAcao(ArrayList<String> comando, ArrayList<String> comandoFuncao, int quantidadeDeAcoes) {
		classFase.acoes = comando;
		classFase.quantidadeDeAcoes = quantidadeDeAcoes;
		classFase.comandoFuncao = comandoFuncao;
		thread = new Thread(new RunnableHandler(this));
		thread.start();

	} 
	
	
	public void resetFase() {
		classFase.personagem.resetPersonagem();
		this.thread.stop();
//		this.thread.interrupt();
//		thread = null;
//		System.gc();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				classFase.fase[i][j] = classFase.estaFase[i][j];
			}
		}

		classFase.repaint();
	}
	
	public boolean verificarSeGanhou() {

		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 20; j++)
			{
				if((classFase.fase[i][j] == Constante.TERRA || classFase.fase[i][j] == Constante.TERRA_ARADA || classFase.fase[i][j] == Constante.TERRA_PLANTADA
						||classFase.fase[i][j] ==  Constante.MATO || classFase.fase[i][j] == Constante.PEDRA || classFase.fase[i][j] == Constante.TOCO) )
					return false;
				else if(!classFase.personagem.estaEmLugarCorreto(classFase.fase))
					return false;
			}

		return true;

	}
}
