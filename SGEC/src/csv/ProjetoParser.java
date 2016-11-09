package csv;

import java.time.LocalDate;
import java.util.Scanner;

import system.Projeto;

public class ProjetoParser implements Parser<Projeto> {

	public Projeto parse(String dados) {

		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		
		String nome = arquivo.next();
		LocalDate dataInicio = LocalDate.parse(arquivo.next());
		LocalDate dataFim = LocalDate.parse(arquivo.next());
		int numCompetencias = arquivo.nextInt();
		String[] competencias = new String[numCompetencias];
		
		for (int i = 0; i < numCompetencias; i++) {
			competencias[i] = arquivo.next();
		}
		
		Projeto Projeto = new Projeto(nome, dataInicio, dataFim, numCompetencias, competencias);
		
		arquivo.close();
		return Projeto;
	}

}
