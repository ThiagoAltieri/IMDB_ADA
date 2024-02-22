package services;

import modelo.Ator;
import repositorio.AtorRepositorio;
import repositorio.FilmeRepositorio;
import java.util.List;

public class AtorService {
    final private AtorRepositorio atorRepositorio;
    final private FilmeRepositorio filmeRepositorio;

    public AtorService(AtorRepositorio atorRepositorio, FilmeRepositorio filmeRepositorio) {
        this.atorRepositorio = atorRepositorio;
        this.filmeRepositorio = filmeRepositorio;
    }

    public Ator buscarPorID(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");
        return (Ator) this.atorRepositorio.buscarPorId(id);
    }

    public Ator buscarPorNome(String nome) {
        if (nome == null)
            throw new RuntimeException("Nome nulo");
        return this.atorRepositorio.procurarPorNome(nome);
    }

    public void create(Ator newAtor) {
        if (newAtor == null)
            throw new RuntimeException("Ator nulo");
        if (newAtor.getNome() == null)
            throw new RuntimeException("Nome do ator nulo");
        this.atorRepositorio.gravar(newAtor);
    }

    public boolean delete(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");
        Ator ator = (Ator) this.atorRepositorio.buscarPorId(id);
        if (ator == null)
            throw new RuntimeException("Ator não encontrado");
        return this.atorRepositorio.excluir(ator);
    }

    public List<Ator> findAll() {
        return this.atorRepositorio.listar();
    }

    public List procurarFilmesDeAtor(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");
        Ator ator = (Ator) this.atorRepositorio.buscarPorId(id);
        if (ator == null)
            throw new RuntimeException("Ator não encontrado");
        return this.filmeRepositorio.procurarPeloAtor(ator);
    }
}


