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

        listaTarefas.add(tarefa);

        String mensagem = "Sua tarefa foi adicionada com sucesso!";

        return mensagem;
    }

    //LISTAGEM TOTAL DA LISTA DE TAREFAS

    public List<Tarefas> exibirLista() {
        return listaTarefas.stream()
                .sorted(Comparator.comparing(Tarefas::getDataAgora).reversed())
                .collect(Collectors.toList());
    }

    //LISTAGEM PELO STATUS

    public List<Tarefas> exibirListaStatus() {
        return listaTarefas.stream()
                .filter(s -> !s.getCompleta())
                .collect(Collectors.toList());
    }

    
}
