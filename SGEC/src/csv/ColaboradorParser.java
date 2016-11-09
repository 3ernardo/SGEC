package csv;

import java.util.Scanner;

import system.Colaborador;

public class ColaboradorParser implements Parser<Colaborador> {

	public Colaborador parse(String dados) {

		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");

		String nomeProj = arquivo.next();
		String nomeFunc = arquivo.next();
		String competencia = arquivo.next();
		
		Colaborador colaborador = new Colaborador(nomeProj, nomeFunc, competencia);
				
		arquivo.close();
		return colaborador;
	}
	
}
