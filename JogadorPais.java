package tdeEstruturaDados;

public class JogadorPais {

	private String pais;
	private Integer indice;

	public JogadorPais(String pais, Integer indice) {
		this.pais = pais;
		this.indice = indice;
	}

	public JogadorPais() {

	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

}
