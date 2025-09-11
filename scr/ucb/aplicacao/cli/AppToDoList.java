package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.cli;

import ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.model.Tarefas;
import ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.service.TarefaService;

import java.util.List;
import java.util.Scanner;

public class AppToDoList {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);    // cria o scanner
        TarefaService servico = new TarefaService();
        Boolean sair = false;

        while(!sair) {
            System.out.println("-----------MENU-----------");
            System.out.println("| Opção 1 - Criar Tarefa");
            System.out.println("| Opção 2 - Listar Tarefas");
            System.out.println("| Opção 3 - Atualizar Tarefa");
            System.out.println("| Opção 4 - Remover Tarefa");
            System.out.println("| Opção 5 - Pesquisar Tarefas");
            System.out.println("| Opção 6 - Sair");
            System.out.print("Escolhe uma opção: ");

            int opcao = entrada.nextInt();   // escolhe a opção
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título da tarefa: ");   // coloca o título
                    String titulo = entrada.nextLine();

                    System.out.print("Descrição da tarefa: ");   // coloca a descrição
                    String descricao = entrada.nextLine();

                    String confirmacao = servico.criarTarefa(titulo, descricao);
                    System.out.println(confirmacao);     // mostra mensagem de confirmação
                    break;

                case 2:
                    List<Tarefas> lista = servico.exibirLista();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");   // mostra mensagem se a lista estiver vazia
                    } else {
                        for (Tarefas t : lista) {
                            System.out.println("ID: " + t.getID());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                            System.out.println("Criada: " + t.getDataAgora());
                            System.out.println("Concluída: " + t.getCompleta());
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID da tarefa: ");
                    int id = entrada.nextInt();   // guarda o id
                    entrada.nextLine();
                    System.out.print("Novo título: ");       // atualiza os dados
                    String novoTitulo = entrada.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = entrada.nextLine();
                    System.out.print("Concluída (true/false): ");
                    boolean novoStatus = entrada.nextBoolean();
                    entrada.nextLine();
                    System.out.println(servico.atualizarTarefa(id, novoTitulo, novaDescricao, novoStatus));  // atualiza e mostra mensagem de confirmação
                    break;

                case 4:
                    System.out.print("Título da tarefa que vai remover: ");
                    String tituloRemover = entrada.nextLine();  // pega o titulo para remover
                    System.out.println(servico.removerTarefa(tituloRemover));   // remove
                    break;

                case 5:
                    System.out.print("Digite uma palavra para buscar a tarefa: ");
                    String palavra = entrada.nextLine();             // pega a palavra
                    List<Tarefas> resultado = servico.pesquisaTarefas(palavra);   // pesquisa as tarefas e guarda o retorno
                    if (resultado.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada.");   // se a variavel estiver vazia não achou nenhuma tarefa
                    } else {
                        for (Tarefas t : resultado) {                           // se nao tiver vazia mostra os resultados
                            System.out.println("ID: " + t.getID());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saindo");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }


    }
}
