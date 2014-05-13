package modelo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Save {
	private File diretorio;
	private File fase;
	public Save() {
		diretorio = new File("save");
		fase = new File("save/save.sv");
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		if(!fase.exists()) {
			try {
				
				fase.createNewFile();
				DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fase)));
		    	BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("padrao.sv")));
		    	int i = 0;
		    	
		    	while(in.ready()) {
		    		i++;
		    		out.writeBytes(in.readLine());
		    		if(i != 30)
		    			out.writeBytes("\n");
		    	}
		    	out.flush();
		    	out.close();
		    	in.close();
		    	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public ArrayList<String> carregarSave() {
		ArrayList<String> arquivo = new ArrayList<String>();
		try {
		BufferedReader in = new BufferedReader(new FileReader("save/save.sv"));
		
			while(in.ready())
				arquivo.add(in.readLine());
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return arquivo;
	}
	
	public void salvar(ArrayList<String> arquivo) {
	
		DataOutputStream out;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("save/save.sv")));
			for(int i = 0; i < arquivo.size(); i++) {

				try {
					out.writeBytes(arquivo.get(i));
			   		if(i != 29)
		    			out.writeBytes("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	

		
	}	
}
