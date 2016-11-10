package system;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sistema {
	
	public static void run(){
		
		Scanner input = new Scanner(System.in);
		
		csv.Inicializador ini = new csv.Inicializador();
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
		
		System.out.println("----------------------------");

		for (int i = 0; i < ini.vetorFuncionario.getNumElementos(); i++) {
			System.out.println(ini.vetorFuncionario.getElemento(i));
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < ini.vetorProjeto.getNumElementos(); i++) {
			System.out.println(ini.vetorProjeto.getElemento(i));
		}		 
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < ini.vetorCompetencia.getNumElementos(); i++) {
			System.out.println(ini.vetorCompetencia.getElemento(i));
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < ini.vetorColaborador.getNumElementos(); i++) {
			System.out.println(ini.vetorColaborador.getElemento(i));
		}
		
		System.out.println("----------------------------");
		
		/// Menu
		
		Menu menu = new Menu();
		
		Opcao criarProj = new Opcao("Criar novo projeto.");
		Opcao cadasFunc = new Opcao("Cadastrar novo funcionário.");
		Opcao deletProj = new Opcao("Excluir um projeto.");
		Opcao deletFunc = new Opcao("Excluir um funcionário.");
		Opcao cadasComp = new Opcao("Cadastrar nova competencia.");
		Opcao consuProj = new Opcao("Consultar projetos ativos.");
		Opcao assocFunc = new Opcao("Associar um funcionário a um projeto.");
		Opcao incomProj = new Opcao("Listar projetos com competências não preenchidas.");
		Opcao sugesFunc = new Opcao("Listar sugestões de funcionários para compor projetos.");
		
		
		menu.adicionaOpcao(criarProj);		
		menu.adicionaOpcao(cadasFunc);
		menu.adicionaOpcao(deletProj);		
		menu.adicionaOpcao(deletFunc);		
		menu.adicionaOpcao(cadasComp);		
		menu.adicionaOpcao(consuProj);
		menu.adicionaOpcao(assocFunc);		
		menu.adicionaOpcao(incomProj);		
		menu.adicionaOpcao(sugesFunc);		
		
		menu.mostraMenu();
		System.out.println(menu.escolha(input.nextInt()));
		
		
		input.close();
	}
	
}
