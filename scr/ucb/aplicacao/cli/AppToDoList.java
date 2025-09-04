package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.cli;

import ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.service.TarefaService;

import java.util.Scanner;

public class AppToDoList {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        TarefaService servico = new TarefaService();
        String titulo;
        String descricao;

        while(true) {
            System.out.println("-----------MENU-----------");
            System.out.println("| Opção 1 - Criar Tarefa");
            System.out.println("| Opção 2 - Listar Tarefas");
            System.out.println("| Opção 3 - Atualizar Tarefa");
            System.out.println("| Opção 4 - Remover Tarefa");
            System.out.println("| Opção 5 - Pesquisar Tarefas");
            System.out.println("| Opção 6 - Sair");
            System.out.print("Escolhe uma opção: ");

            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    titulo = entrada.nextLine();

                    System.out.print("Descrição da tarefa: ");
                    descricao = entrada.nextLine();

                    String confirmacao = servico.criarTarefa(titulo, descricao);
                    System.out.println(confirmacao);
                    break;
            }
        }


    }
}
