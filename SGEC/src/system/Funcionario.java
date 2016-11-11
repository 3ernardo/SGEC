package system;

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
	
	public String getNome() {
		return nome;
	}
	
	public String[] getCompetencias() {
		return competencias;
	}

	public String listaComp() {
		String lista = "";
		for (int i = 0; i < numCompetencias; i++) {
			lista += competencias[i];
			if (i != numCompetencias - 1) {lista += ", ";}
		}
		return lista;
	}
	
	@Override
	public String toString() {
		return "Funcionario [Nome: " + nome + ", Salário: " + salario + ", Número de competências: " + numCompetencias
				+ ", Competencias: " + listaComp() + "]";
	}
	
	

}
