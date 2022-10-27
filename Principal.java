package tdeEstruturaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String arquivo = "dadosFIFAOrd.txt";
		String destino = "indiceFIFA.txt";

		Particionamento part = new Particionamento();
		part.criarParticoes();
		part.ordenaPart();

		ManipulaArquivo arq = new ManipulaArquivo();
		arq.criaIndice(arquivo, destino);
		arq.arquivoPais(arquivo, "paisesFIFA.txt");
		arq.buscaBinInd(Long.valueOf(883));
		arq.buscaPais("Afghanistan");

		HashMap<String, JogadorHash> hash = new HashMap<>();
		String linha = "";
		String[] dados;

		try {
			FileReader file = new FileReader("dadosFIFAOrd.txt");
			BufferedReader lerArq = new BufferedReader(file);

			linha = lerArq.readLine();

			while (linha != null) {
				dados = linha.split(",");

				JogadorHash jog = new JogadorHash(Long.parseLong(dados[0].trim()), dados[1].trim(), dados[5].trim(),
						dados[3].trim());

				hash.put(dados[1].trim(), jog);

				linha = lerArq.readLine();
			}

			lerArq.close();
			file.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		@SuppressWarnings("resource")
		Scanner nome = new Scanner(System.in);
		System.out.println("Digite o nome do jogador: ");

		String chave = String.valueOf(nome.nextLine());

		JogadorHash jog = hash.get(chave.trim());

		if (jog == null) {
			System.out.println("Jogador nao existe");
		} else {
			// Vinícius Jr.
			// K. Benzema
			System.out.println("Jogador: " + jog.getNome() + ", " + jog.getPais() + ", " + jog.getTime());
		}

		hash.clear();

		ArvoreBinaria arv = new ArvoreBinaria();
		arv.arvore();

	}

}