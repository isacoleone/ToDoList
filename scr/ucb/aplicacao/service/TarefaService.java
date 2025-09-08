package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    List<Tarefas> listaTarefas= new ArrayList<Tarefas>(); // declaração do array para armazenar as tarefas
    private long proximoId = 1;
    
    public String criarTarefa(String titulo, String descricao){
        Tarefas tarefa = new Tarefas(titulo, descricao); // instância de Tarefas

        tarefa.setID(proximoId++);

        listaTarefas.add(tarefa);

        String mensagem = "Sua tarefa foi adicionada com sucesso!";

        return mensagem;
    }

    public String atualizarTarefa(long id, String novoTitulo, String novaDescricao, boolean novaStatus) {
    
    for (Tarefas tarefa : listaTarefas) {
        if (tarefa.getID() == id) {
            
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setCompleta(novaStatus);
            return "Tarefa com ID " + id + " atualizada com sucesso.";
        }
    }
    
    return "Erro: Tarefa com ID " + id + " não encontrada.";
}
}
