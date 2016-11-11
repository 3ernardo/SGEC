package system;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import csv.Inicializador;

public class Sistema {
	
	static csv.Inicializador ini = new csv.Inicializador();
	static Scanner input = new Scanner(System.in);
	
	public static void run(){
		
		
		try {
			ini.gravaFuncionarios();
			ini.gravaProjetos();
			ini.gravaCompetencia();
			ini.gravaColaborador();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
				
		/// Teste dos leitores de CSV
		/*
		System.out.println("----------------------------");

		for (int i = 0; i < Inicializador.vetorFuncionario.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorFuncionario.getElemento(i));
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < Inicializador.vetorProjeto.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorProjeto.getElemento(i));
		}		 
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < Inicializador.vetorCompetencia.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorCompetencia.getElemento(i));
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < Inicializador.vetorColaborador.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorColaborador.getElemento(i));
		}
		
		System.out.println("----------------------------");
		*/
		/// Menu

		int opcao;
		
		do {
			opcao = consoleMenu();
			switch (opcao) {
			case 1:
				criarProjeto();
				break;
			case 2:
				deletaProjeto(leitor("Digite o nome do projeto a ser excluído:"));
				break;
			case 3:	
				mostrarProjetos();
				break;
			case 4:	
				adicionaFuncionario();
				break;
			case 5:	
				deletaFuncionario(leitor("Digite o nome do funcionário a ser excluído:"));
				break;
			case 6:
				mostrarFuncionarios();
				break;
			case 7:
				adicionaCompetencia();
				break;
			case 8:
				mostrarCompetencias();
				break;
			case 9:
				mostrarColaboradores();
				break;
			case 10:
				vincular();
				break;
			case 11:
				projCarentes();
				break;
			case 12:
				System.out.println("Por implementar.");
				break;
			case 0:
				System.out.println("Fechando o programa...");
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
		
		
		

		
	}
	
	public static int consoleMenu() {
		Menu menu = new Menu();
		Opcao criarProj = new Opcao("Criar novo projeto.");
		Opcao deletProj = new Opcao("Excluir um projeto.");
		Opcao consuProj = new Opcao("Consultar projetos ativos.");
		
		Opcao cadasFunc = new Opcao("Cadastrar novo funcionário.");
		Opcao deletFunc = new Opcao("Excluir um funcionário.");
		Opcao consuFunc = new Opcao("Consultar funcionários ativos.");
		
		Opcao cadasComp = new Opcao("Cadastrar nova competência.");
		Opcao consuComp = new Opcao("Consultar lista de competências.");
		
		Opcao consuCola = new Opcao("Consultar lista de colaboradores.");		
		
		Opcao assocFunc = new Opcao("Associar um funcionário a um projeto.");
		Opcao incomProj = new Opcao("Listar projetos com competências preenchidas.");
		Opcao sugesFunc = new Opcao("Listar sugestões de funcionários para compor projetos.");
		
		
		menu.adicionaOpcao(criarProj);
		menu.adicionaOpcao(deletProj);
		menu.adicionaOpcao(consuProj);		
		
		menu.adicionaOpcao(cadasFunc);
		menu.adicionaOpcao(deletFunc);
		menu.adicionaOpcao(consuFunc);
				
		menu.adicionaOpcao(cadasComp);
		menu.adicionaOpcao(consuComp);

		menu.adicionaOpcao(consuCola);
		
		menu.adicionaOpcao(assocFunc);		
		menu.adicionaOpcao(incomProj);		
		menu.adicionaOpcao(sugesFunc);
		
		menu.mostraMenu();
		
		return input.nextInt();
	}
	
	public static String leitor(String texto) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println(texto);
		final String text = input.nextLine(); 
		return text;
	}
	
	public static int encontraProjeto(String nome) {
		int index = -1;
		for (int i = 0; i < Inicializador.vetorProjeto.getNumElementos(); i++) {
			if (Inicializador.vetorProjeto.getElemento(i).getNome().equals(nome)) index = i;
		}
		return index;
	}
	
	public static int encontraFuncionario(String nome) {
		int index = -1;
		for (int i = 0; i < Inicializador.vetorFuncionario.getNumElementos(); i++) {
			if (Inicializador.vetorFuncionario.getElemento(i).getNome().equals(nome)) index = i;
		}
		return index;
	}
	
	public static int encontraCompetencia(String nome, int optre) {
		int index = -1;
		for (int i = 0; i < Inicializador.vetorCompetencia.getNumElementos(); i++) {
			if (Inicializador.vetorCompetencia.getElemento(i).getNome().equals(nome)) index = i;
		}
		return index;
	}
	
	public static void projCarentes() {
		System.out.println("-- PROJETOS COM COMPETÊNCIAS ATENDIDAS --");
		for (int i = 0; i < Inicializador.vetorProjeto.getNumElementos(); i++) {
			String nome = Inicializador.vetorProjeto.getElemento(i).getNome();
			String[] comp = Inicializador.vetorProjeto.getElemento(i).getCompetencias();
			
			for (int j = 0; j < comp.length; j++) {
				String aux = comp[j];
				for (int k = 0; k < Inicializador.vetorColaborador.getNumElementos(); k++) {
					if (Inicializador.vetorColaborador.getElemento(k).getCompetencia().equals(aux) && Inicializador.vetorColaborador.getElemento(k).getProjeto().equals(nome)) {
						System.out.println("Competências atendidas [Projeto: " + nome + " Competência: " + comp[j] + "]");
					}
				}
			}
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void vincular() {
		int funcCompIndex = -1;
		int projCompIndex = -1;
		
		String funcNome = leitor("Digite o nome do funcionário:");
		int funcIndex = encontraFuncionario(funcNome);
		if (funcIndex < 0) System.out.println("Funcionário não encontrado");
		String[] funcComp = Inicializador.vetorFuncionario.getElemento(funcIndex).getCompetencias();
		for (int i = 0; i < funcComp.length; i++) {
			System.out.print(funcComp[i] + ", ");
		}
		System.out.println("");

		String projNome = leitor("Digite o nome do projeto:");
		int projIndex = encontraProjeto(projNome);
		if (projIndex < 0) System.out.println("Projeto não encontrado");
		String[] projComp = Inicializador.vetorProjeto.getElemento(projIndex).getCompetencias();
		for (int i = 0; i < projComp.length; i++) {
			System.out.print(projComp[i] + ", ");
		}
		System.out.println("");
		
		String competencia = leitor("Digite a competência que será aproveitada no projeto:");
		
		for (int i = 0; i < funcComp.length; i++) {
			if (funcComp[i].equals(competencia)) funcCompIndex = i;
		}

		for (int i = 0; i < projComp.length; i++) {
			if (projComp[i].equals(competencia)) projCompIndex = i;
		}
		
		if (funcCompIndex >= 0 && projCompIndex >= 0) {
			Colaborador colaborador = new Colaborador(projNome, funcNome, competencia);
			Inicializador.vetorColaborador.vetorAdicionaElemento(colaborador);
			System.out.println("Vinculação bem sucedida.");
		} else {
			System.out.println("Erro.");
		}
		
	}
	
	public static void criarProjeto() {
		String nome;
		LocalDate dataInicio;
		LocalDate dataFim;
		int numCompetencias;
		String[] competencias;
		
		try {			
			nome = leitor("Insira o nome do novo projeto:");
			dataInicio = LocalDate.parse(leitor("Insira a data de início do novo projeto: (AAAA-MM-DD)"));
			dataFim = LocalDate.parse(leitor("Insira a data de término do novo projeto: (AAAA-MM-DD)"));
			numCompetencias = Integer.parseInt(leitor("Insira a quantidade de competências que deseja solicitar neste projeto:"));
		
			competencias = new String[numCompetencias];
			for (int i = 0; i < numCompetencias; i++) {
				boolean val = false;
				String temp = leitor("Insira a " + (i+1) + "ª competência.");
				for (int j = 0; j < Inicializador.vetorCompetencia.getNumElementos(); j++) {
					if (Inicializador.vetorCompetencia.getElemento(j).getNome().equals(temp)) {
						val = true;
					}
				}
				if (val == true) {
					competencias[i] = temp;
				} else {
					System.out.println("Competência inválida.");
					i--;
				}
			}
			Projeto projeto = new Projeto(nome, dataInicio, dataFim, numCompetencias, competencias);
			Inicializador.vetorProjeto.vetorAdicionaElemento(projeto);
		} catch (Exception e) {
			System.out.println("Erro. Verifique os valores informados.\n");
		}
	}
	
	public static void deletaProjeto(String nome) {
		int index = -1;
		boolean val = false;
		
		try {
			for (int i = 0; i < Inicializador.vetorProjeto.getNumElementos(); i++) {
				if (Inicializador.vetorProjeto.getElemento(i).getNome().equals(nome)) {
					val = true;
					index = i;
				}
			}
			if (val) {
				System.out.println("Deletando o projeto:\n" + Inicializador.vetorProjeto.getElemento(index));
				Inicializador.vetorProjeto.vetorDeletaElemento(index);
				for (int i = 0; i < Inicializador.vetorColaborador.getNumElementos(); i++) {
					
					if (Inicializador.vetorColaborador.getElemento(i).getProjeto().equals(nome)) {
						Inicializador.vetorColaborador.vetorDeletaElemento(i);
						i--;
					}
				}
			} else {
				System.out.println("Projeto não encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro. Verifique o valor informado.\n");
		} 
	}
	
	public static void adicionaFuncionario() {
		String nome;
		Double salario;
		int numCompetencias;
		String[] competencias;
		
		try {
			nome = leitor("Insira o nome do novo funcionário:");
			salario = Double.parseDouble(leitor("Insira o salário do novo funcionário. (utilize o ponto como separador)"));
			numCompetencias = Integer.parseInt(leitor("Insira o número de competências deste funcionário:"));
			
			competencias = new String[numCompetencias];
			
			for (int i = 0; i < numCompetencias; i++) {
				boolean val = false;
				String temp = leitor("Insira a " + (i+1) + "ª competência.");
				for (int j = 0; j < Inicializador.vetorCompetencia.getNumElementos(); j++) {
					if (Inicializador.vetorCompetencia.getElemento(j).getNome().equals(temp)) {
						val = true;
					}
				}
				if (val == true) {
					competencias[i] = temp;
				} else {
					System.out.println("Competência inválida.");
					i--;
				}
			}
			Funcionario funcionario = new Funcionario(nome, salario, numCompetencias, competencias);
			Inicializador.vetorFuncionario.vetorAdicionaElemento(funcionario);
		} catch (Exception e) {
			System.out.println("Erro. Verifique os valores informados.\n");
		}
	}
	
	public static void deletaFuncionario(String nome) {
		int index = -1;
		boolean val = false;
		
		try {
			for (int i = 0; i < Inicializador.vetorFuncionario.getNumElementos(); i++) {
				if (Inicializador.vetorFuncionario.getElemento(i).getNome().equals(nome)) {
					val = true;
					index = i;
				}
			}
			if (val) {
				System.out.println("Excluindo o funcionário:\n" + Inicializador.vetorFuncionario.getElemento(index));
				Inicializador.vetorFuncionario.vetorDeletaElemento(index);
				for (int i = 0; i < Inicializador.vetorColaborador.getNumElementos(); i++) {
					
					if (Inicializador.vetorColaborador.getElemento(i).getFuncionario().equals(nome)) {
						Inicializador.vetorColaborador.vetorDeletaElemento(i);
						i--;
					}
				}
			} else {
				System.out.println("Funcionário não encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro. Verifique o nome informado.\n");
		} 
	}
	
	public static void adicionaCompetencia() {
		String nome;
		
		try {
			nome = leitor("Insira o nome da nova competência:");
			Competencia competencia = new Competencia(nome);
			Inicializador.vetorCompetencia.vetorAdicionaElemento(competencia);
		} catch (Exception e) {
			System.out.println("Erro. Verifique o valor informado.\n");
		}
	}
	
	public static void mostrarProjetos() {
		System.out.println("------------ PROJETOS ATIVOS ------------");
		for (int i = 0; i < Inicializador.vetorProjeto.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorProjeto.getElemento(i));
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void mostrarFuncionarios() {
		System.out.println("---------- FUNCIONÁRIOS ATIVOS ----------");
		for (int i = 0; i < Inicializador.vetorFuncionario.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorFuncionario.getElemento(i));
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void mostrarCompetencias() {
		System.out.println("---------- COMPETÊNCIAS VALIDAS ---------");
		for (int i = 0; i < Inicializador.vetorCompetencia.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorCompetencia.getElemento(i));
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void mostrarColaboradores() {
		System.out.println("------------- COLABORAÇÕES --------------");
		for (int i = 0; i < Inicializador.vetorColaborador.getNumElementos(); i++) {
			System.out.println(Inicializador.vetorColaborador.getElemento(i));
		}
		System.out.println("-----------------------------------------");
	}
}
