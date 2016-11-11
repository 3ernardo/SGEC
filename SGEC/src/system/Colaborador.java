package system;

public class Colaborador {

	private String nomeProj;
	private String nomeFunc;
	private String competencia;
	
	public Colaborador(String nomeProj, String nomeFunc, String competencia) {
		super();
		this.nomeProj = nomeProj;
		this.nomeFunc = nomeFunc;
		this.competencia = competencia;
	}

	public String getProjeto(){
		return nomeProj;
	}
	
	public String getFuncionario(){
		return nomeFunc;
	}
	
	public String getCompetencia(){
		return competencia;
	}
	
	@Override
	public String toString() {
		return "Colaborador [Projeto: " + nomeProj + ", Funcionário: " + nomeFunc + ", Competencia: " + competencia + "]";
	}
		
}
