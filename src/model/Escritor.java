package teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritor {

	public static void escrever(String path, List<FolhaPagamento> folhaDePagamento) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (FolhaPagamento folha : folhaDePagamento) {
				String descontoINSSFormatado = String.format("%.2f", folha.getDescontoINSS());
				String descontoIRFormatado = String.format("%.2f", folha.getDescontoIR());
				String salarioLiquidoFormatado = String.format("%.2f", folha.getSalarioLiquido());

				String linha = String.format("%s;%s;%s;%s;%s", folha.getFuncionario().getNome(),
						folha.getFuncionario().getCpf(), descontoINSSFormatado, descontoIRFormatado,
						salarioLiquidoFormatado);

				bw.write(linha);
				bw.newLine();
			}
			System.out.println("Arquivo criado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo: " + e.getMessage());
		}
	}
}
