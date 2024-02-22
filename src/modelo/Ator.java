package modelo;

import modelo.Filme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Ator extends Pessoa {
    private List filmes;
    private Boolean exclusivo;
    public Ator(String nome, Boolean exclusivo) {
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
