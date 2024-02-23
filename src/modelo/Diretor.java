package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diretor extends Pessoa {
    private List<Filme> filmes;

    // Construtor
    public Diretor(String nome, LocalDate DataNascimento) {
        super(nome, DataNascimento);
        this.filmes = new ArrayList<>();
    }

    // Método para adicionar filme
    public void adicionarFilme(Filme filme) {
        this.filmes.add(filme);
    }

    // Método para obter filmes (retorna uma lista imutável)
    public List<Filme> getFilmes() {
        return Collections.unmodifiableList(this.filmes);
    }
}
