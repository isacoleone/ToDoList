package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.cli;

import java.util.Scanner;

public class AppToDoList {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-----------MENU-----------");
        System.out.println("| Opção 1 - Criar Tarefa");
        System.out.println("| Opção 2 - Listar Tarefas");
        System.out.println("| Opção 3 - Atualizar Tarefa");
        System.out.println("| Opção 4 - Remover Tarefa");
        System.out.println("| Opção 5 - Pesquisar Tarefas");
        System.out.println("| Opção 6 - Sair");
        System.out.print("Escolhe uma opção: ");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                break;

            case 2:
                break;

        }

    }
}
