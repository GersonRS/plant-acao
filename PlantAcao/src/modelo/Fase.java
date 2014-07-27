package modelo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Fase {

	
	public static enum elementos
	{
		grama(20), terra(0), terra_arada(1), terra_plantada(2), terra_plantada_molhada(3), muda1(4), muda2(5), 
		muda3(6), muda4(7), pedra(8), toco(9), mato(10), pedra_quebrada(12), toco_quebrado(13), mato_cortado(14);
		
		public final int valor;
		
		private elementos(int v) {
			valor = v;
		}
	}
	
	public Personagem personagem;
	public Fase classFase;
	public int [][]matrizFase = new int[10][20];
	public int [][]matrizEstaFase = new int[10][20];
	public Thread thread;
	
	public Fase(Fase fase) {
		this.classFase = fase;
	}
	public void gerarFaseAleatoria(String dificuldade) {
		if(dificuldade.equalsIgnoreCase("facil")) {
			ArrayList<Point> posicao = gerarAleatorio();  


			for(int i = 0; i < 3; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = 0;
			}
			
			matrizFase[posicao.get(3).y][posicao.get(3).x] = (( int ) ( Math.random() * 3 ) ) + 8;

		} else if(dificuldade.equalsIgnoreCase("medio")) {

			ArrayList<Point> posicao = gerarAleatorio();
			for(int i = 0; i < 3; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = elementos.terra.valor;
			}
			for(int i = 3; i < 5; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("dificil")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 5; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = elementos.terra.valor;
			}

			for(int i = 5; i < 10; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = matrizFase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("muito dificil")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 4; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = elementos.terra.valor;
			}

			for(int i = 4; i < 15; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = matrizFase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
			}


		} else if(dificuldade.equalsIgnoreCase("31337")) {
			ArrayList<Point> posicao = gerarAleatorio();

			for(int i = 0; i < 10; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = elementos.terra.valor;
			}

			for(int i = 10; i < 20; i++) {
				matrizFase[posicao.get(i).y][posicao.get(i).x] = matrizFase[posicao.get(i).y][posicao.get(i).x] = (( int ) ( Math.random() * 3 ) ) + 8;
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
				matrizFase[i][j] = 20;
			}
		}

		return posicao;
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
					matrizFase[i][k] = Integer.parseInt(tile); 
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
				matrizEstaFase[i][j] = matrizFase[i][j];
			}
		}
	}
	
//	public void verificarSePisouEmTerraPlantada() {
	//		
	//		if(fase1[personagem.getI()][personagem.getJ()] == TERRA_PLANTADA_MOLHADA) {
	//			fase1[personagem.getI()][personagem.getJ()] = TERRA_ARADA;
	//			repaint();
	//		}
	//			
	//	}

	public boolean verificarFase(int constante, int incremento) {
		if(classFase.personagem.getDirecao().equalsIgnoreCase("baixo")) {
			if(classFase.personagem.getI()+1 < 10)		
				if(matrizFase[classFase.personagem.getI()+1][classFase.personagem.getJ()] == constante) {
					matrizFase[classFase.personagem.getI() + 1][classFase.personagem.getJ()] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("cima")) {
			if(classFase.personagem.getI()-1 >= 0)		
				if(matrizFase[classFase.personagem.getI() - 1][classFase.personagem.getJ()] == constante) {
					matrizFase[classFase.personagem.getI() - 1][classFase.personagem.getJ()] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("direita")) {
			if(classFase.personagem.getJ() + 1 < 20)		
				if(matrizFase[classFase.personagem.getI()][classFase.personagem.getJ() + 1] == constante) {
					matrizFase[classFase.personagem.getI()][classFase.personagem.getJ() + 1] = constante + incremento;
					return true;
				}
		} else if(classFase.personagem.getDirecao().equalsIgnoreCase("esquerda")) {
			if(classFase.personagem.getJ()-1 >= 0)		
				if(matrizFase[classFase.personagem.getI()][classFase.personagem.getJ() - 1] == constante) {
					matrizFase[classFase.personagem.getI()][classFase.personagem.getJ() - 1] = constante + incremento;
					return true;
				}
		}
		return false;
	}

	public ArrayList<Point> encontrarTerraPlantada() {
		ArrayList<Point> posicao = new ArrayList<Point>();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 20; j++) {
				if(matrizFase[i][j] == elementos.terra_plantada_molhada.valor)
					posicao.add(new Point(j, i));
			}
		}
		return posicao;
	}
	
	public void nascerPlantas(ArrayList<Point> pos, int frame) {
		for(int i = 0; i < pos.size(); i++) {
			matrizFase[pos.get(i).y][pos.get(i).x] = frame;
		}
		
	}
	
	public void realizarAcao(ArrayList<String> comando, ArrayList<String> comandoFuncao, int quantidadeDeAcoes) {
		classFase.acoes = comando;
		classFase.quantidadeDeAcoes = quantidadeDeAcoes;
		classFase.comandoFuncao = comandoFuncao;
		thread = new Thread(new RunnableHandler(this));
		thread.start();

	} 
	
	
	@SuppressWarnings("deprecation")
	public void resetFase() {
		classFase.personagem.resetPersonagem();
		this.thread.stop();
//		this.thread.interrupt();
//		thread = null;
//		System.gc();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				matrizFase[i][j] = matrizEstaFase[i][j];
			}
		}

		classFase.repaint();
	}
	
	public boolean verificarSeGanhou() {

		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 20; j++)
			{
				if((matrizFase[i][j] == elementos.terra.valor || matrizFase[i][j] == elementos.terra_arada.valor || matrizFase[i][j] == elementos.terra_plantada.valor
						||matrizFase[i][j] ==  elementos.mato.valor || matrizFase[i][j] == elementos.pedra.valor || matrizFase[i][j] == elementos.toco.valor) )
					return false;
				else if(!classFase.personagem.estaEmLugarCorreto(matrizFase))
					return false;
			}

		return true;

	}
}
