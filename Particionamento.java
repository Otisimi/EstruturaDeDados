package tdeEstruturaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Particionamento {

	public void criarParticoes() {

		String linha = "";
		String[] cod;
		List<Jogador> palavras = new ArrayList<Jogador>();

		try {
			FileReader arq = new FileReader("FIFA23_official_data.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			FileWriter arqPart = new FileWriter("partUm.txt");
			PrintWriter gravarArq = new PrintWriter(arqPart);

			int i = 0;

			while (i < 5000) {
				linha = lerArq.readLine();

				cod = linha.split(",");

				Jogador jogador = new Jogador(Integer.parseInt(cod[0]), cod[1], Integer.parseInt(cod[2]), cod[4],
						Integer.parseInt(cod[6]), cod[8]);

				palavras.add(jogador);

				i++;
			}

			Collections.sort(palavras, Comparator.comparing(Jogador::getId));

			for (Jogador reg : palavras) {
				linha = reg.getId() + ", " + reg.getNome() + ", " + reg.getIdade() + ", " + reg.getNacao() + ", "
						+ reg.getOvr() + ", " + reg.getTime();

				gravarArq.println(linha);
			}

			arqPart.close();
			gravarArq.close();
			palavras.clear();

			arqPart = new FileWriter("partDois.txt");
			gravarArq = new PrintWriter(arqPart);

			while (i < 10000) {
				linha = lerArq.readLine();

				cod = linha.split(",");

				Jogador jogador = new Jogador(Integer.parseInt(cod[0].trim()), cod[1].trim(),
						Integer.parseInt(cod[2].trim()), cod[4].trim(), Integer.parseInt(cod[6].trim()), cod[8].trim());

				palavras.add(jogador);

				i++;
			}

			Collections.sort(palavras, Comparator.comparing(Jogador::getId));

			for (Jogador reg : palavras) {
				linha = reg.getId() + ", " + reg.getNome() + ", " + reg.getIdade() + ", " + reg.getNacao() + ", "
						+ reg.getOvr() + ", " + reg.getTime();

				gravarArq.println(linha);
			}

			arqPart.close();
			gravarArq.close();
			palavras.clear();

			arqPart = new FileWriter("partTres.txt");
			gravarArq = new PrintWriter(arqPart);

			while (linha != null) {
				linha = lerArq.readLine();

				if (linha == null) {
					break;
				}

				cod = linha.split(",");

				Jogador jogador = new Jogador(Integer.parseInt(cod[0].trim()), cod[1].trim(),
						Integer.parseInt(cod[2].trim()), cod[4].trim(), Integer.parseInt(cod[6].trim()), cod[8].trim());

				palavras.add(jogador);

				i++;
			}

			Collections.sort(palavras, Comparator.comparing(Jogador::getId));

			for (Jogador reg : palavras) {
				linha = reg.getId() + ", " + reg.getNome() + ", " + reg.getIdade() + ", " + reg.getNacao() + ", "
						+ reg.getOvr() + ", " + reg.getTime();

				gravarArq.println(linha);
			}

			arqPart.close();
			gravarArq.close();
			palavras.clear();

			arq.close();
			return;

		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo");
			return;
		}

	}

	public void ordenaPart() {
		String linha1 = "";
		String linha2 = "";
		String linha3 = "";
		String[] cod1;
		String[] cod2;
		String[] cod3;

		try {
			FileReader part1 = new FileReader("partUm.txt");
			BufferedReader lerUm = new BufferedReader(part1);
			FileReader part2 = new FileReader("partDois.txt");
			BufferedReader lerDois = new BufferedReader(part2);
			FileReader part3 = new FileReader("partTres.txt");
			BufferedReader lerTres = new BufferedReader(part3);
			FileWriter arqOrd = new FileWriter("dadosFIFAOrd.txt");
			PrintWriter gravarArq = new PrintWriter(arqOrd);

			int indica;
			Long menor;

			linha1 = lerUm.readLine();
			linha2 = lerDois.readLine();
			linha3 = lerTres.readLine();

			int fim1 = 0;
			int fim2 = 0;
			int fim3 = 0;

			while (fim1 != -1 || fim2 != -1 || fim3 != -1) {

				cod1 = linha1.split(",");
				cod2 = linha2.split(",");
				cod3 = linha3.split(",");

				Long val1 = Long.parseLong(cod1[0].trim());
				Long val2 = Long.parseLong(cod2[0].trim());
				Long val3 = Long.parseLong(cod3[0].trim());

				if (val1 < val2) {
					indica = 0;
					menor = val1;
				} else {
					indica = 1;
					menor = val2;
				}

				if (val3 < menor) {
					indica = 2;
					menor = val3;
				}

				if (indica == 0) {
					gravarArq.println(linha1);
					linha1 = lerUm.readLine();

					if (linha1 == null) {
						linha1 = "999999999, AAAAAAAAA";
						fim1 = -1;
					}

				} else if (indica == 1) {
					gravarArq.println(linha2);
					linha2 = lerDois.readLine();

					if (linha2 == null) {
						linha2 = "999999999, AAAAAAAAA";
						fim2 = -1;
					}

				} else {
					gravarArq.println(linha3);
					linha3 = lerTres.readLine();

					if (linha3 == null) {
						linha3 = "999999999, AAAAAAAAA";
						fim3 = -1;
					}
				}

			}

			lerUm.close();
			lerDois.close();
			lerTres.close();
			gravarArq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
