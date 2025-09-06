package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;

import java.util.List;

public class TarefaService {
    private List<Tarefas> ListaTarefas; //Cria lista de tarefas
    private long NovoId; //Armazena os IDs

    public TarefaService() { // Objeto que cria a lista de tarefas
       this.ListaTarefas = new ArrayList<>();
       this.NovoId = 1; // Obriga a tarefa a nunca ter 0 como ID
   }
}
