package dominio;

import java.util.ArrayList;

public class Person {
    private static long contadorId = 0;
    private long id = 0;
    private String nome;
    private String sexo;
    private int anosDeCarreira;
    private double prestigio;
    private ArrayList<Filme> filmes;

    public Person(String nome, String sexo, int anosDeCarreira, double prestigio) {
        this.id = ++contadorId;
        this.nome = nome;
        this.sexo = sexo;
        this.anosDeCarreira = anosDeCarreira;
        this.prestigio = prestigio;
        this.filmes = new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAnosDeCarreira() {
        return anosDeCarreira;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public double getPrestigio() {
        return prestigio;
    }

    public void addFilme(Filme filme){
        filmes.add(filme);
    }

}