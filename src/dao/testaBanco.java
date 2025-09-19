package dao;

import model.Funcionario;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class testaBanco {

    public static void main(String[] args) {

/* REMOVER
        Scanner sc = new Scanner(System.in);
        LocalDate dataAtual = LocalDate.now();
        FuncionarioDao dao = new FuncionarioDao();

        System.out.println("Deletando Cliente...");
        System.out.println("Codigo:");
        int codigo = Integer.parseInt(sc.nextLine());

        dao.remover(codigo);

        sc.close();


 */
        FuncionarioDao dao = new FuncionarioDao();
        Scanner sc = new Scanner(System.in);
        LocalDate dataAtual = LocalDate.now();
        Funcionario f1 = new Funcionario(5,"Guilherme","151151",dataAtual,2000.00);


        dao.inserir(f1);

        sc.close();



    }
}