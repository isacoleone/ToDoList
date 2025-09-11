package ucb.aplicacao.cli.ToDoList.scr.ucb.aplicacao.model;

import java.time.LocalDateTime;

public class Tarefas {
    private long ID;
    private String titulo;
    private String descricao;
    private String data;
    private boolean completa;
    private LocalDateTime dataAgora;

    public Tarefas(){
        this.dataAgora = LocalDateTime.now();
        this.completa = false;
    }

    //Construtor só com o título

    public Tarefas(String titulo){
        this();
        this.titulo = titulo;
    }

    //Construtor com título e descrição

    public Tarefas(String titulo, String descri){
        this();
        this.titulo = titulo;
        this.descricao = descri;

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
        this.data = data;
        this.completa = completa;
    }

    //Impressões (get) e inserções (set) de dados

    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        data = data;
    }
    public boolean getCompleta() {
        return completa;
    }
    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
    public LocalDateTime getDataAgora() {
        return dataAgora;
    }
    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }
}