package classMain;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import daos.DependenteDao;
import daos.FolhaPagamentoDao;
import daos.FuncionarioDao;
import model.ConnectionFactory;
import model.Dependente;
import model.DependenteException;
import model.Funcionario;
import model.Parentesco; 

public class AppMain {

    public static void main(String[] args) {
        ConnectionFactory conexaoBanco = new ConnectionFactory();
        try (Connection conn = conexaoBanco.getConnection();
             Scanner sc = new Scanner(System.in)) {

            FuncionarioDao funcionarioDao = new FuncionarioDao();
            DependenteDao dependenteDao = new DependenteDao(conn);
            FolhaPagamentoDao folhaDao = new FolhaPagamentoDao(conn);

            int opcao;
            do {
                mostrarMenu();
                opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case 1: cadastrarFuncionario(sc, funcionarioDao); break;
                    case 2: cadastrarDependente(sc, dependenteDao); break;
                    case 3: gerarFolha(sc, folhaDao); break;
                    case 4: removerFuncionario(sc, funcionarioDao); break;
                    case 5: removerDependente(sc, dependenteDao); break;
                    case 6: atualizarFuncionario(sc, funcionarioDao); break;
                    case 7: atualizarDependente(sc, dependenteDao); break;
                    case 8: removerFolha(sc, folhaDao); break;
                    case 9: System.out.println("Encerrando..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } while (opcao != 9);

        } catch (Exception e) {
            System.err.println("Erro na aplicação: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n==== MENU PRINCIPAL ====");
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Cadastrar dependente");
        System.out.println("3 - Gerar folha de pagamento");
        System.out.println("4 - Remover funcionário");
        System.out.println("5 - Remover dependente");
        System.out.println("6 - Atualizar funcionário");
        System.out.println("7 - Atualizar dependente");
        System.out.println("8 - Remover folha de pagamento");
        System.out.println("9 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarFuncionario(Scanner sc, FuncionarioDao funcionarioDao) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data nascimento (yyyy-MM-dd): ");
        String data = sc.nextLine();
        System.out.print("Salário bruto: ");
        double salario = sc.nextDouble();

        Funcionario f = new Funcionario(nome, cpf, LocalDate.parse(data), salario);
        funcionarioDao.inserir(f);
    }

    private static void cadastrarDependente(Scanner sc, DependenteDao dependenteDao) {
        try {
            System.out.print("ID do funcionário responsável: ");
            int idFuncionario = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome do dependente: ");
            String nome = sc.nextLine();
            System.out.print("CPF do dependente: ");
            String cpfDep = sc.nextLine();
            System.out.print("Data nascimento (yyyy-MM-dd): ");
            String data = sc.nextLine();
            System.out.print("Parentesco (FILHO, FILHA, SOBRINHO, OUTROS): ");
            String parentesco = sc.nextLine();

            Dependente dep = new Dependente(
                nome,
                cpfDep,
                LocalDate.parse(data),
                Parentesco.valueOf(parentesco.toUpperCase())
            );

            dependenteDao.inserir(dep, idFuncionario);

        } catch (DependenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void gerarFolha(Scanner sc, FolhaPagamentoDao folhaDao) {
        System.out.print("CPF do funcionário: ");
        String cpf = sc.nextLine();
        folhaDao.inserirPorCpf(cpf);
    }

    private static void removerFuncionario(Scanner sc, FuncionarioDao funcionarioDao) {
        System.out.print("CPF do funcionário: ");
        String cpf = sc.nextLine();
        funcionarioDao.remover(cpf);
    }

    private static void removerDependente(Scanner sc, DependenteDao dependenteDao) {
        System.out.print("CPF do dependente: ");
        String cpf = sc.nextLine();
        dependenteDao.remover(cpf);
    }

    private static void atualizarFuncionario(Scanner sc, FuncionarioDao funcionarioDao) {
        System.out.print("CPF do funcionário a atualizar: ");
        String cpf = sc.nextLine();
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo salário bruto: ");
        double salario = sc.nextDouble();

       
        Funcionario f = new Funcionario(nome, cpf, LocalDate.now(), salario);
        funcionarioDao.atualizar(f);
    }

    private static void atualizarDependente(Scanner sc, DependenteDao dependenteDao) {
        try {
            System.out.print("CPF do dependente a atualizar: ");
            String cpfDep = sc.nextLine();

            System.out.print("Novo nome: ");
            String nome = sc.nextLine();

            System.out.print("Novo parentesco (FILHO, FILHA, SOBRINHO, OUTROS): ");
            String parentesco = sc.nextLine();

            System.out.print("Novo ID do funcionário responsável: ");
            int idFuncionario = sc.nextInt();
            sc.nextLine();

            Dependente dep = new Dependente(
                nome,
                cpfDep,
                LocalDate.now(), 
                Parentesco.valueOf(parentesco.toUpperCase())
            );

            dependenteDao.atualizar(dep, idFuncionario);

        } catch (DependenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerFolha(Scanner sc, FolhaPagamentoDao folhaDao) {
        System.out.print("ID da folha de pagamento: ");
        int idFolha = sc.nextInt();
        folhaDao.remover(idFolha);
    }

    
}