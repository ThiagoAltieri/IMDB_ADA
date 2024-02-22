package services;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;
import repositorio.FilmeRepositorio;

import java.util.List;

public class FilmeService {
    private FilmeRepositorio filmeRepositorio;

    public FilmeService(FilmeRepositorio filmeRepositorio) {
        this.filmeRepositorio = filmeRepositorio;
    }

    public void create(Filme filme) {
        if (filme == null)
            throw new RuntimeException("Filme não pode ser nulo");
        if (filme.getNome() == null)
            throw new RuntimeException("Nome do filme não pode ser nulo");
        if (filme.getDataLancamento() == null)
            throw new RuntimeException("Ano de lançamento não pode ser nulo");

        this.filmeRepositorio.gravar(filme);
    }

    public boolean delete(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");

        Filme filme = (Filme) this.filmeRepositorio.buscarPorId(id);
        if (filme == null)
            throw new RuntimeException("Filme não encontrado");

        return this.filmeRepositorio.excluir(filme);
    }

    public Filme findById(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");

        return (Filme) this.filmeRepositorio.buscarPorId(id);
    }

    public List findByName(String nome) {
        if (nome == null)
            throw new RuntimeException("Nome não pode ser nulo");

        return this.filmeRepositorio.procurarPorNome(nome);
    }

    public List findAll() {
        return this.filmeRepositorio.listar();
    }

    public void addAtorFilme(Long idFilme, Ator ator) {
        if (idFilme == null)
            throw new RuntimeException("Id do filme não pode estar vazio");
        if (ator == null)
            throw new RuntimeException("Ator não pode ser nulo");

        Filme filme = findById(idFilme);
        filme.addAtor(ator);
    }

    public void addDiretorFilme(Long id, Diretor diretor) {
        if (id == null)
            throw new RuntimeException("Id do filme não pode estar vazio");
        if (diretor == null)
            throw new RuntimeException("Diretor não pode ser nulo");

        Filme filme = findById(id);
        filme.addDiretor(diretor);
    }

    public List<Ator> findAtorById_filme(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");

        Filme filme = (Filme) this.filmeRepositorio.buscarPorId(id);
        if (filme == null)
            throw new RuntimeException("Filme não encontrado");

        return filme.getAtores();
    }

    public List<Diretor> findDiretorById_filme(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");

        Filme filme = (Filme) this.filmeRepositorio.buscarPorId(id);
        if (filme == null)
            throw new RuntimeException("Filme não encontrado");

        return filme.getDiretores();
    }
}
