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


    public String removerTarefa(String titulo){ // remover a tarefa pelo titulo

        if (titulo == null || titulo.isEmpty()) { // procura o titulo

            String mensagem = "o titulo esta incorreto"; // caso o titulo esteja incorreto vai aparecer a mensagem


            return mensagem;
        }
        for (Tarefas tarefa : listaTarefas) { // caso o titulo esteja com o nome correto a tarefa vai ser removida com sucesso
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                listaTarefas.remove(tarefa);
                return "tarefa" + tarefa.getTitulo() + " removida com sucesso";
            }
        }
        return "nenhuma tarefa foi encontrada!"; // caso o titulo esteja nulo vai retornar para essa linha

    }


}
