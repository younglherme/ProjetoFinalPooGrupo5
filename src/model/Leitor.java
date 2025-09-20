package teste;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
	public static void ler(String path) {

		 try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                System.out.println(linha);
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao acessar arquivo: " + e.getMessage());
	        }
	    }
	}