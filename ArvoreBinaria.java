package tdeEstruturaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArvoreBinaria {

	protected FolhaJogador raiz;

	public FolhaJogador getRaiz() {
		return raiz;
	}

	public FolhaJogador busca(Long chave) {
		FolhaJogador nodo = raiz;
		while (nodo != null) {
			if (chave.equals(nodo.id)) {
				return nodo;
			} else if (nodo.id > chave) {
				nodo = nodo.esq;
			} else {
				nodo = nodo.dir;
			}
		}

		return null;
	}

	public void insere(Long chave, String nome, String time) {
		FolhaJogador newFolhaJogador = new FolhaJogador(chave, nome, time);

		if (raiz == null) {
			raiz = newFolhaJogador;
			return;
		}

		FolhaJogador node = raiz;
		while (true) {
			if (chave < node.id) {
				if (node.esq != null) {
					node = node.esq;
				} else {
					node.esq = newFolhaJogador;
					return;
				}
			} else if (chave > node.id) {
				if (node.dir != null) {
					node = node.dir;
				} else {
					node.dir = newFolhaJogador;
					return;
				}
			} else {
				System.out.println("Valor ja inserido");
				return;
			}
		}

	}

	public void arvore() {
		String linha = "";
		String[] cod;
		FolhaJogador jog;

		try {
			FileReader arq = new FileReader("FIFA23_official_data.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			linha = lerArq.readLine();

			while (linha != null) {

				cod = linha.split(",");

				this.insere(Long.parseLong(cod[0].trim()), cod[1].trim(), cod[8].trim());

				linha = lerArq.readLine();

			}

			lerArq.close();
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		jog = this.busca(Long.valueOf(238794));
		System.out.println("Jogador = " + jog.nome + ", " + jog.time);

	}

}
