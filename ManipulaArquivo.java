package tdeEstruturaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManipulaArquivo {

	public void criaIndice(String arquivo, String nomeIndice) {

		String linha = "";

		try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			FileWriter arqIndex = new FileWriter(nomeIndice);
			try (PrintWriter gravarArq = new PrintWriter(arqIndex)) {
				linha = lerArq.readLine();
				int tamNoArq = 0;
				int i = 0;
				while (linha != null) {
					int tam = linha.length();

					linha = i + " - " + tamNoArq;

					tamNoArq += tam + 2;

					int tamInd = linha.length();

					while (tamInd != 16) {
						linha += " ";
						tamInd++;
					}

					gravarArq.println(linha);
					i++;

					linha = lerArq.readLine();
				}
			}

			arq.close();
			System.out.println("Arquivo criado com sucesso: " + nomeIndice);
			return;

		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo");
			return;
		}
	}

	public void buscaBinInd(Long id) {
		int maior = 17660;
		int menor = 0;
		int pos, media;
		String linha = "";
		String[] dado;

		try {

			while (menor < maior) {

				media = (maior + menor) / 2;
				pos = media * 18;

				RandomAccessFile arq = new RandomAccessFile("indiceFIFA.txt", "r");

				arq.seek(pos);
				linha = arq.readLine();
				dado = linha.split(" - ");

				Long dadoId = Long.parseLong(dado[0]);

				if (dadoId < id) {
					menor = media + 1;
				} else if (dadoId > id) {
					maior = media - 1;
				} else {
					RandomAccessFile arqPrin = new RandomAccessFile("dadosFIFAOrd.txt", "r");

					Long posicao = Long.parseLong(dado[1].trim());

					arqPrin.seek(posicao);

					String achou = arqPrin.readLine();

					System.out.println("Registro: " + achou);
					arq.close();
					arqPrin.close();
					return;
				}

				arq.close();

			}

			System.out.println("Registro não existe!");
			return;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void arquivoPais(String arquivo, String destino) {
		String linha = "";
		String[] dados;

		try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			FileWriter arqIndex = new FileWriter(destino);
			PrintWriter gravarArq = new PrintWriter(arqIndex);
			List<JogadorPais> conteudo = new ArrayList<JogadorPais>();

			linha = lerArq.readLine();
			Integer i = 0;
			Integer tamNoArq = 0;

			while (linha != null) {
				dados = linha.split(",");

				int tam = linha.length();

				JogadorPais jogador = new JogadorPais(dados[3], tamNoArq);

				conteudo.add(jogador);

				tamNoArq += tam + 2;
				i++;
				linha = lerArq.readLine();
			}

			Collections.sort(conteudo, Comparator.comparing(JogadorPais::getPais));

			for (JogadorPais jogador : conteudo) {
				linha = jogador.getPais() + " - " + jogador.getIndice();

				while (linha.length() != 35) {
					linha += " ";
				}

				gravarArq.println(linha);
			}

			lerArq.close();
			arq.close();
			arqIndex.close();
			gravarArq.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscaPais(String pais) {
		String linha = "";
		String[] dados;
		int i = 0;
		String paisArq;

		try {
			FileReader arq = new FileReader("paisesFIFA.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			linha = lerArq.readLine();

			while (linha != null) {

				dados = linha.split(" - ");
				paisArq = dados[0].trim();

				if (paisArq.equals(pais)) {
					i = 1;

					Long pos = Long.parseLong(dados[1].trim());
					String achou = "";

					RandomAccessFile arqNormal = new RandomAccessFile("dadosFIFAOrd.txt", "r");
					arqNormal.seek(pos);
					achou = arqNormal.readLine();

					System.out.println("Registro: " + achou);

					arqNormal.close();

				} else {
					if (i != 0) {
						break;
					}
				}

				linha = lerArq.readLine();
			}

			arq.close();
			lerArq.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
