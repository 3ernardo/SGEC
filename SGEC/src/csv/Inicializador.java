package csv;

import java.io.FileNotFoundException;

import system.Vetor;
import system.Colaborador;
import system.Competencia;
import system.Funcionario;
import system.Projeto;

public class Inicializador {

	public Vetor<Funcionario> vetorFuncionario = new Vetor<>();
	public Vetor<Projeto> vetorProjeto = new Vetor<>();
	public Vetor<Competencia> vetorCompetencia = new Vetor<>();
	public Vetor<Colaborador> vetorColaborador = new Vetor<>();
	
	
	public void gravaFuncionarios() throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionarioParser(); 
		CSVReader<Funcionario> reader = new CSVReader<>("funcionarios.csv", parser);
	
		reader.skipLine();
		while (reader.hasNext()) {
			Funcionario teste = reader.readObject();
			//System.out.println(teste);
			vetorFuncionario.vetorAdicionaElemento(teste);
		}
		reader.close();
	}
	
	
	public void gravaProjetos() throws FileNotFoundException {
		Parser<Projeto> parser = new ProjetoParser(); 
		CSVReader<Projeto> reader = new CSVReader<>("projetos.csv", parser);
	
		reader.skipLine();
		while (reader.hasNext()) {
			Projeto teste = reader.readObject();
			vetorProjeto.vetorAdicionaElemento(teste);
		}
		reader.close();
	}
	
	
	public void gravaCompetencia() throws FileNotFoundException {
		Parser<Competencia> parser = new CompetenciaParser(); 
		CSVReader<Competencia> reader = new CSVReader<>("competencias.csv", parser);
	
		reader.skipLine();
		while (reader.hasNext()) {
			Competencia teste = reader.readObject();
			vetorCompetencia.vetorAdicionaElemento(teste);
		}
		reader.close();
	}
	
	
	public void gravaColaborador() throws FileNotFoundException {
		Parser<Colaborador> parser = new ColaboradorParser(); 
		CSVReader<Colaborador> reader = new CSVReader<>("colaboradores.csv", parser);
		
		reader.skipLine();
		while (reader.hasNext()) {
			Colaborador teste = reader.readObject();
			vetorColaborador.vetorAdicionaElemento(teste);
		}
		reader.close();
	}
	
}
