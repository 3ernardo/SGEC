package system;

public class Menu {

	private Opcao[] opcoes = new Opcao[9];
	private int numOpcoes = 0;
	
	public void mostraMenu() {
		for (int i = 0; i < numOpcoes; i++) {
			System.out.println("[" + (i+1) + "] " + opcoes[i].getDescricao());
		}
	}
	
	public void adicionaOpcao(Opcao opcao) {
		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}
	
	public String escolha(int selecao) {
		selecao--;
		if (selecao >= 0 && selecao < numOpcoes) {
			return opcoes[selecao].getDescricao();
		} else {
			return "Opção inválida.";
		}
	}
	
}
