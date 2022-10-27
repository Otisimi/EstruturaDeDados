package tdeEstruturaDados;

public class Jogador {

	private Integer id;
	private String nome;
	private Integer idade;
	private String nacao;
	private Integer ovr;
	private String time;

	public Jogador(Integer id, String nome, Integer idade, String nacao, Integer ovr, String time) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.nacao = nacao;
		this.ovr = ovr;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNacao() {
		return nacao;
	}

	public void setNacao(String nacao) {
		this.nacao = nacao;
	}

	public Integer getOvr() {
		return ovr;
	}

	public void setOvr(Integer ovr) {
		this.ovr = ovr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
