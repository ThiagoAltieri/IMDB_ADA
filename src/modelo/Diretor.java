package modelo;

import modelo.Filme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diretor extends Pessoa {
    private List filmes;
    private Boolean exclusivo;
    public Diretor(String nome, Boolean exclusivo) {
            super(nome);
            this.exclusivo = exclusivo;
            this.filmes = new ArrayList();
    }
    public void adicionarFilmes(Filme filme) {
        this.filmes.add(filme);
    }
    public List getFilmes() {
        return Collections.unmodifiableList(this.filmes);
    }
}
