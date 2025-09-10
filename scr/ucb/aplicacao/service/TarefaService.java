package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.service;

import ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.model.Tarefas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService {
    private List<Tarefas> tarefas = new ArrayList<>();


    List<Tarefas> listaTarefas= new ArrayList<Tarefas>(); // declaração do array para armazenar as tarefas

    //CRIAÇÃO DA TAREFA

    private long proximoId = 1;

    public String criarTarefa(String titulo, String descricao){
        Tarefas tarefa = new Tarefas(titulo, descricao); // instância de Tarefas

        listaTarefas.add(tarefa); //Adiciona tarefa a lista de tarefas
        tarefa.setID(proximoId++);

        listaTarefas.add(tarefa);

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

    public String atualizarTarefa(long id, String novoTitulo, String novaDescricao, boolean novaStatus) {

    for (Tarefas tarefa : listaTarefas) {
        if (tarefa.getID() == id) {

            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setCompleta(novaStatus);
            return "Tarefa com ID " + id + " atualizada com sucesso.";
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


    return "Erro: Tarefa com ID " + id + " não encontrada.";
}

}
