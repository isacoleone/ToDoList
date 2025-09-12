package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService {
    // Declaração do array para armazenar as tarefas
    private final List<Tarefas> listaTarefas = new ArrayList<>();
    private long proximoId = 1;

    /**
     * CRIAÇÃO DA TAREFA
     */
    public String criarTarefa(String titulo, String descricao) {
        Tarefas tarefa = new Tarefas(titulo, descricao); // Instância de Tarefas
        tarefa.setID(proximoId++); // Define o ID e incrementa para o próximo

        // A tarefa estava sendo adicionada duas vezes. Removida a adição duplicada.
        listaTarefas.add(tarefa); // Adiciona a tarefa à lista

        return "Sua tarefa foi adicionada com sucesso!";
    }

    /**
     * LISTAGEM TOTAL DA LISTA DE TAREFAS
     */
    public List<Tarefas> exibirLista() {
        return listaTarefas.stream()
                // Ordena, de forma decrescente as tarefas por data de criação
                .sorted(Comparator.comparing(Tarefas::getDataAgora).reversed())
                .collect(Collectors.toList()); // Cria uma cópia da lista ordenada
    }

    /**
     * LISTAGEM PELO STATUS (tarefas não completas)
     */
    public List<Tarefas> exibirListaStatus() {
        return listaTarefas.stream()
                .filter(s -> !s.getCompleta()) // Lista somente as tarefas com Completa = false
                .collect(Collectors.toList());
    }

    /**
     * PESQUISA POR TITULO OU DESCRIÇÃO
     */
    public List<Tarefas> pesquisaTarefas(String termo) {
        // Cria uma lista somente com as tarefas que têm o trecho citado pelo usuário
        // no título ou na descrição.
        return listaTarefas.stream()
                .filter(t -> t.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                        (t.getDescricao() != null && t.getDescricao().toLowerCase().contains(termo.toLowerCase())))
                .collect(Collectors.toList());
    }

    /**
     * ATUALIZAÇÃO DA TAREFA
     */
    public String atualizarTarefa(long id, String novoTitulo, String novaDescricao, boolean novaStatus) {
        for (Tarefas tarefa : listaTarefas) {
            if (tarefa.getID() == id) {
                tarefa.setTitulo(novoTitulo);
                tarefa.setDescricao(novaDescricao);
                tarefa.setCompleta(novaStatus);
                return "Tarefa com ID " + id + " atualizada com sucesso.";
            }
        }
        // tinha um erro de indexação. '}' do for foi adicionada na posição correta,
        return "Erro: Tarefa com ID " + id + " não encontrada.";
    }

    /**
     * REMOÇÃO DA TAREFA
     */
    public String removerTarefa(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return "O título não pode ser vazio.";
        }

        // ajustando a forma como as tarefas eram removidas...
        //temos muito a melhorar jovens mancebos, não teve uma função sem erro \(;_;)/

        boolean removido = listaTarefas.removeIf(tarefa -> tarefa.getTitulo().equalsIgnoreCase(titulo));

        if (removido) {
            return "Tarefa com o título '" + titulo + "' foi removida com sucesso.";
        } else {
            return "Nenhuma tarefa com o título '" + titulo + "' foi encontrada.";
        }
    }
}
