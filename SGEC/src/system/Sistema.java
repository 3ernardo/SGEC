package system;

import java.io.FileNotFoundException;

public class Sistema {
	
	public static void run(){
		
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
		
		
		
		/// Testes
		
		System.out.println("testa testa testa testador");

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
		
	}
	
}
