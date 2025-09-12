package ucb.aplicacao.cli;

import ucb.aplicacao.model.Tarefas;
import ucb.aplicacao.service.TarefaService;

import java.util.List;
import java.util.Scanner;

public class AppToDoList {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        TarefaService servico = new TarefaService();
        boolean sair = false;

        while (!sair) {
            System.out.println("\n-----------MENU-----------");
            System.out.println("| Opção 1 - Criar Tarefa");
            System.out.println("| Opção 2 - Listar Tarefas");
            System.out.println("| Opção 3 - Atualizar Tarefa");
            System.out.println("| Opção 4 - Remover Tarefa");
            System.out.println("| Opção 5 - Pesquisar Tarefas");
            System.out.println("| Opção 6 - Sair");
            System.out.print("Escolha uma opção: ");

            //Adicionado tratamento para entrada de dados inválida (não numérica).
            if (!entrada.hasNextInt()) {
                System.out.println("Opção inválida. Por favor, digite um número.");
                entrada.next(); // Limpa o buffer do scanner
                continue;
            }

            int opcao = entrada.nextInt();
            entrada.nextLine(); // Consome o caractere de nova linha pendente

            switch (opcao) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Descrição da tarefa: ");
                    String descricao = entrada.nextLine();

                    String confirmacao = servico.criarTarefa(titulo, descricao);
                    System.out.println(confirmacao);
                    break;

                case 2:
                    List<Tarefas> lista = servico.exibirLista();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n--- Lista de Tarefas ---");
                        for (Tarefas t : lista) {
                            System.out.println("--------------------------");
                            System.out.println("ID: " + t.getID());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                            System.out.println("Criada em: " + t.getDataAgora());
                            System.out.println("Concluída: " + (t.getCompleta() ? "Sim" : "Não")); // Melhoria na exibição
                        }
                        System.out.println("--------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID da tarefa que deseja atualizar: ");
                    long id = entrada.nextLong();
                    entrada.nextLine(); // Limpa o buffer

                    System.out.print("Novo título: ");
                    String novoTitulo = entrada.nextLine();

                    System.out.print("Nova descrição: ");
                    String novaDescricao = entrada.nextLine();

                    System.out.print("A tarefa foi concluída? (true/false): ");
                    boolean novoStatus = entrada.nextBoolean();
                    entrada.nextLine(); // Limpa o buffer

                    System.out.println(servico.atualizarTarefa(id, novoTitulo, novaDescricao, novoStatus));
                    break;

                case 4:
                    System.out.print("Digite o título da tarefa que deseja remover: ");
                    String tituloRemover = entrada.nextLine();
                    System.out.println(servico.removerTarefa(tituloRemover));
                    break;

                case 5:
                    System.out.print("Digite um termo para buscar nas tarefas: ");
                    String palavra = entrada.nextLine();
                    List<Tarefas> resultado = servico.pesquisaTarefas(palavra);

                    if (resultado.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada com o termo '" + palavra + "'.");
                    } else {
                        System.out.println("\n--- Resultados da Pesquisa ---");
                        for (Tarefas t : resultado) {
                            System.out.println("--------------------------");
                            System.out.println("ID: " + t.getID());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                        }
                        System.out.println("--------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema. Até logo!");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        entrada.close();
    }
}