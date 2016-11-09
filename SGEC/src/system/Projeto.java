package system;

import java.time.LocalDate;
import java.util.Arrays;

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

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", numCompetencias="
				+ numCompetencias + ", competencias=" + Arrays.toString(competencias) + "]";
	}

}
