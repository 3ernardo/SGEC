package system;

import java.time.LocalDate;

public class Projeto {
	
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private int numCompetencias;
	private String[] competencias;
	
	public Projeto(String nome, LocalDate dataInicio, LocalDate dataFim, int numCompetencias, String[] competencias) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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
		return "Projeto [Nome: " + nome + ", Data de início: " + dataInicio + ", Data de término: " + dataFim + ", Número de competências: "
				+ numCompetencias + ", Competencias: " + listaComp() + "]";
	}

}
