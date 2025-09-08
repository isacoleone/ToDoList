package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;
import java.util.List;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;

import java.util.List;

public class TarefaService {
<<<<<<< Updated upstream
    private List<Tarefas> ListaTarefas; //Cria lista de tarefas
    private long NovoId; //Armazena os IDs

    //CRIAÇÃO DA LISTA DE TAREFAS

    public TarefaService() { // Objeto que cria a lista de tarefas
       this.ListaTarefas = new ArrayList<>();
       this.NovoId = 1; // Obriga a tarefa a nunca ter 0 como ID
   }

   //LISTAGEM TOTAL DA LISTA DE TAREFAS

   public List<Tarefas> exibirLista(){
        return new ArrayList<> (ListaTarefas); //Cria uma copia da lista de tarefas para exibição
   }
}

=======
    List<Tarefas> listaTarefas= new ArrayList<Tarefas>(); // declaração do array para armazenar as tarefas

    //CRIAÇÃO DA TAREFA

    public String criarTarefa(String titulo, String descricao){
        Tarefas tarefa = new Tarefas(titulo, descricao); // instância de Tarefas

        listaTarefas.add(tarefa);

        String mensagem = "Sua tarefa foi adicionada com sucesso!";

        return mensagem;
    }

    //LISTAGEM TOTAL DA LISTA DE TAREFAS

    public List<Tarefas> exibirLista(){
        return new ArrayList<> (listaTarefas); //Cria uma copia da lista de tarefas para exibição
    }
}
>>>>>>> Stashed changes
