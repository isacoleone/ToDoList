package ucb.aplicacao.model;

import java.time.LocalDateTime;

public class Tarefas {
    private long ID;
    private String Titulo;
    private String Descricao;
    private String Data;
    private boolean completa;
    private LocalDateTime DataAgora;

    public Tarefas(){
        this.DataAgora = LocalDateTime.now();
        this.completa = false;
    }

    public Tarefas(String titulo){
        this();
        this.Titulo = titulo;
    }

    public Tarefas(String titulo, String descri){
        this();
        this.Titulo = titulo;
        this.Descricao = descri;

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
