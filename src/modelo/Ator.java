package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ator extends Pessoa {
    private List<Filme> filmes;

    public Ator(String nome, LocalDate DataNascimento) {
        super(nome, DataNascimento);
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        this.filmes.add(filme);
    }

    public List<Filme> getFilmes() {
        return Collections.unmodifiableList(this.filmes);
    }

}

