package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

	public static List<Funcionario> ler(String path) {
        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            Funcionario funcionarioAtual = null;

            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) {
                    
                    if (funcionarioAtual != null) {
                        funcionarios.add(funcionarioAtual);
                        funcionarioAtual = null;
                    }
                    continue;
                }

                String[] dados = linha.split(";");

                if (funcionarioAtual == null) {
                    
                    funcionarioAtual = new Funcionario(
                        dados[0].trim(),              
                        dados[1].trim(),             
                        LocalDate.parse(dados[2].trim(), fmt), 
                        Double.parseDouble(dados[3].trim())   
                    );
                } else {
                    
                    try {
                        Dependente dep = new Dependente(
                            dados[0].trim(), 
                            dados[1].trim(),
                            LocalDate.parse(dados[2].trim(), fmt),
                            Parentesco.valueOf(dados[3].trim().toUpperCase())
                        );
                        funcionarioAtual.adicionarDependente(dep);
                    } catch (DependenteException e) {
                        System.out.println("Dependente ignorado: " + e.getMessage());
                    }
                }
            }

            
            if (funcionarioAtual != null) {
                funcionarios.add(funcionarioAtual);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return funcionarios;
    }
}