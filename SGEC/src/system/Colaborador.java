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

	@Override
	public String toString() {
		return "Colaborador [nomeProj=" + nomeProj + ", nomeFunc=" + nomeFunc + ", competencia=" + competencia + "]";
	}
		
}
