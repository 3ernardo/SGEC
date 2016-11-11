package system;

public class Competencia {
	
	private String nome;

	public Competencia(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Competencia [Descrição: " + nome + "]";
	}	
	
}
