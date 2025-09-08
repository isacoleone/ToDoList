package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;
import java.util.ArrayList;
import java.util.List;

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

    public List<Tarefas> exibirLista(){
        return new ArrayList<> (listaTarefas); //Cria uma copia da lista de tarefas para exibição
    }
}
