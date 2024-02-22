package modelo;

import java.util.Date;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private Boolean ativo;
    public Pessoa(String nome) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.ativo = true;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
