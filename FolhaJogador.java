package tdeEstruturaDados;

public class FolhaJogador {

	Long id;
	String nome;
	String time;
	FolhaJogador dir;
	FolhaJogador esq;

	public FolhaJogador(Long id, String nome, String time) {
		this.id = id;
		this.nome = nome;
		this.time = time;
	}

}
