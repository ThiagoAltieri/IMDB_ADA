package services;

import modelo.Diretor;
import repositorio.DiretorRepositorio;
import repositorio.FilmeRepositorio;

import java.util.List;

public class DiretorService {
    final private DiretorRepositorio diretorRepositorio;
    final private FilmeRepositorio filmeRepositorio;

    public DiretorService(DiretorRepositorio diretorRepositorio, FilmeRepositorio filmeRepositorio) {
        this.diretorRepositorio = diretorRepositorio;
        this.filmeRepositorio = filmeRepositorio;
    }

    public Diretor findById(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");
        return (Diretor) this.diretorRepositorio.buscarPorId(id);
    }

    public Diretor findByNome(String nome) {
        if (nome == null)
            throw new RuntimeException("Nome nulo");

        List<Diretor> diretores = findAll();
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null;
    }

    public void create(Diretor newDiretor) {
        if (newDiretor == null)
            throw new RuntimeException("Diretor nulo");
        if (newDiretor.getNome() == null)
            throw new RuntimeException("Erro ao cadastrar diretor sem nome");
        if (newDiretor.getDataNascimento() == null)
            throw new RuntimeException("Erro ao cadastrar diretor sem data de nascimento");

        this.diretorRepositorio.gravar(newDiretor);
    }

    public boolean delete(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");

        Diretor diretor = (Diretor) this.diretorRepositorio.buscarPorId(id);
        if (diretor == null)
            throw new RuntimeException("Diretor de id " + id + " não encontrado");

        return this.diretorRepositorio.excluir(diretor);
    }

    public List<Diretor> findAll() {
        return this.diretorRepositorio.listar();
    }

    public List procurarFilmesDeDiretor(Long id) {
        if (id == null)
            throw new RuntimeException("Id nulo");

        Diretor diretor = (Diretor) this.diretorRepositorio.buscarPorId(id);
        if (diretor == null)
            throw new RuntimeException("Diretor inexistente");

        return this.filmeRepositorio.procurarPeloDiretor(diretor);
    }
}
