package system;

import java.util.Arrays;

public class Funcionario {

	private String nome;
	private Double salario;
	private int numCompetencias;
	private String[] competencias;
	
	public Funcionario(String nome, double salario, int numCompetencias, String[] competencias) {
		this.nome = nome;
		this.salario = salario;
		this.numCompetencias = numCompetencias;
		this.competencias = competencias;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salario=" + salario + ", numCompetencias=" + numCompetencias
				+ ", competencias=" + Arrays.toString(competencias) + "]";
	}
	
	

}
