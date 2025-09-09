package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService {
    List<Tarefas> listaTarefas= new ArrayList<Tarefas>(); // declaração do array para armazenar as tarefas

    //CRIAÇÃO DA TAREFA

    public String criarTarefa(String titulo, String descricao){
        Tarefas tarefa = new Tarefas(titulo, descricao); // instância de Tarefas

        listaTarefas.add(tarefa); //Adiciona tarefa a lista de tarefas

        String mensagem = "Sua tarefa foi adicionada com sucesso!";

        return mensagem;
    }

    //LISTAGEM TOTAL DA LISTA DE TAREFAS

    public List<Tarefas> exibirLista() {
        return listaTarefas.stream()
                .sorted(Comparator.comparing(Tarefas::getDataAgora).reversed()) //Ordena, de forma decrescente as tarefas por data de criação
                .collect(Collectors.toList()); //Cria uma copia da lista ordenada
    }

    //LISTAGEM PELO STATUS

    public List<Tarefas> exibirListaStatus() {
        return listaTarefas.stream()
                .filter(s -> !s.getCompleta()) //Lista somente as tarefas com Completo = false
                .collect(Collectors.toList());
    }

    //PESQUISA POR TITULO OU DESCRIÇÃO

    public List<Tarefas> pesquisaTarefas(String termo) {
        return listaTarefas.stream()
                .filter(t -> t.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                        (t.getDescricao() != null && t.getDescricao().toLowerCase().contains(termo.toLowerCase())))
                .collect(Collectors.toList());
    } //Cria uma lista com somente com as tarefas que tem o trecho citado pelo usuario
    //no titulo ou na descrição
}
