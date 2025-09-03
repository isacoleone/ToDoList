package ucb.aplicacao.model;

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

    public Tarefas(String titulo){
        this();
        this.titulo = titulo;
    }

    public Tarefas(String titulo, String descri){
        this();
        this.titulo = titulo;
        this.descricao = descri;

    }

    public Tarefas(Long id, String titulo, String descri, boolean completa){
        this(titulo, descri);
        this.ID = id;
        this.completa = completa;
    }

    public long getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
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
