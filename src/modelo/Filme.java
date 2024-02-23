package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme {
    private final String nome;
    private final Diretor diretor;
    private final LocalDate dataLancamento;
    private final String genero;
    private final List<Ator> atores;
    private final List<Diretor> diretores;

    public Filme(String nome, Diretor diretor, LocalDate dataLancamento, String genero, List<Ator> atores) {
        this.nome = nome;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
        this.atores = new ArrayList<>(atores);
        this.diretores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public List<Ator> getAtores() {
        return Collections.unmodifiableList(atores);
    }

    public void addAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Diretor> getDiretores() {
        return Collections.unmodifiableList(diretores);
    }

    public void addDiretor(Diretor diretor) {
        diretores.add(diretor);
    }
}
