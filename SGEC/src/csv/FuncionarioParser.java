package csv;

import java.util.Scanner;

import system.Funcionario;

public class FuncionarioParser implements Parser<Funcionario> {

	public Funcionario parse(String dados) {

		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");

		String nome = arquivo.next();
		double salario = Double.parseDouble(arquivo.next());
		int numCompetencias = arquivo.nextInt();
		String[] competencias = new String[numCompetencias];
		
		for (int i = 0; i < numCompetencias; i++) {
			competencias[i] = arquivo.next();
		}
		
		Funcionario Funcionario = new Funcionario(nome, salario, numCompetencias, competencias);
				
		arquivo.close();
		return Funcionario;
	}
	
}