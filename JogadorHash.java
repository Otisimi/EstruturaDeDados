package tdeEstruturaDados;

public class JogadorHash {
	private Long id;
	private String nome;
	private String time;
	private String pais;

	public JogadorHash(Long id, String nome, String time, String pais) {
		this.id = id;
		this.nome = nome;
		this.time = time;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
