package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.service;

import ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.model.Tarefas;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    private List<Tarefas> tarefas = new ArrayList<>();


    List<Tarefas> listaTarefas= new ArrayList<Tarefas>(); // declaração do array para armazenar as tarefas

    public String criarTarefa(String titulo, String descricao){
        Tarefas tarefa = new Tarefas(titulo, descricao); // instância de Tarefas

        listaTarefas.add(tarefa);

        String mensagem = "Sua tarefa foi adicionada com sucesso!";

        return mensagem;
    }
}
