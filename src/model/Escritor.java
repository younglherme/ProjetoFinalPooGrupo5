package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritor {

	public static void escrever(String path, List<FolhaPagamento> folhaDePagamento) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for (FolhaPagamento folha : folhaDePagamento) {
				
				bw.write(folha.toString());
				bw.newLine();
			}
			System.out.println("Arquivo criado com sucesso!");
			
		} catch (IOException e) {
			
			System.out.println("Erro ao acessar arquivo: " + e.getMessage());
		}
	}
}
