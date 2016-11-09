package csv;

import java.util.Scanner;

import system.Competencia;

public class CompetenciaParser implements Parser<Competencia> {

	public Competencia parse(String dados) {

		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");

		String nome = arquivo.next();
		
		Competencia Competencia = new Competencia(nome);
				
		arquivo.close();
		return Competencia;
	}
	
}