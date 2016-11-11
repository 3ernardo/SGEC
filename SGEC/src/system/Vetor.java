package system;

public class Vetor<V> {

	@SuppressWarnings("unchecked")
	private V[] dados = (V[])new Object[2];
	private int numElementos = 0;
	
	public int vetorEspaco() {
		return dados.length - numElementos;
	}
	
	public V getElemento(int i) {
		return dados[i];
	}
	
	public int getNumElementos() {
		return numElementos;
	}
	
	public int getTamanho() {
		return dados.length;
	}
	
	public boolean vetorCheio() {
		if (vetorEspaco() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void vetorAumentar() {
		@SuppressWarnings("unchecked")
		V[] temp = (V[])new Object[dados.length * 2];
		for (int i = 0; i < dados.length; i++) {
			temp[i] = dados[i];
		}
		dados = temp;
	}
	
	public void vetorAdicionaElemento(V elemento) {
		if (vetorCheio()) {
			vetorAumentar();
			dados[numElementos] = elemento;
			numElementos++;
		} else {
			dados[numElementos] = elemento;
			numElementos++;
		}
	}
	
	public void vetorDeletaElemento(int indice) {
		for (int i = indice; i < dados.length - 1; i++) {
			dados[i] = dados[i+1];
		}
		dados[dados.length - 1] = null;
		numElementos--;
	}
	
	
	public void vetorAlteraElemento(int indice, V alteracao) {
		dados[indice] = alteracao;
	}
	
}
