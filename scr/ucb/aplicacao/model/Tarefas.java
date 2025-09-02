package ucb.aplicacao.model;

import java.time.LocalDateTime;

public class Tarefas {
    private long ID; //identificador
    private String Titulo;
    private String Descricao;
    private String Data; //Data de finalização da tarefa cadastrada (inserida pelo usuario)
    private boolean completa; //Se ela foi completada
    private LocalDateTime DataAgora; //Data e hora de cadastro da tarefa

    //Construtor padrão

    public Tarefas(){
        this.DataAgora = LocalDateTime.now();
        this.completa = false;
    }

    //Construtor só com o título

    public Tarefas(String titulo){
        this(); //Chama o atributos do construtor padrão
        this.Titulo = titulo;
    }

    //Construtor com título e descrição

    public Tarefas(String titulo, String descri){
        this();
        this.Titulo = titulo;
        this.Descricao = descri;
    }

    //Construtor com ID e Completo

    public Tarefas(Long id, String titulo, String descri, boolean completa){
        this(titulo, descri); //Chama a descrição e titulo dos anteriores
        this.ID = id;
        this.completa = completa;
    }

    //Construtor com data

    public Tarefas(Long id, String titulo, String descri, String data,boolean completa){
        this(titulo, descri); //Chama a descrição e titulo dos anteriores
        this.ID = id;
        this.Data = data;
        this.completa = completa;
    }

    //Impressões (get) e inserções (set) de dados

    public long getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    public String getData() {
        return Data;
    }
    public void setData(String data) {
        Data = data;
    }
    public boolean getCompleta() {
        return completa;
    }
    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
    public LocalDateTime getDataAgora() {
        return DataAgora;
    }
    public void setDataAgora(LocalDateTime dataAgora) {
        DataAgora = dataAgora;
    }
}