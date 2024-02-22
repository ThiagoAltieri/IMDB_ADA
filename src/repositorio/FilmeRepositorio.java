package repositorio;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;
import banco.BancoDeDados;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilmeRepositorio extends AbstractRepositorio {

    public FilmeRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Boolean filtrarPorId(Object o, Long id) {
        Filme filme = (Filme) o;
        return Objects.equals(filme.getId(), id);
    }

    @Override
    protected Class classeModelo() {
        return Filme.class;
    }

    public List procurarPorNome(String nome) {
        if (nome == null)
            throw new RuntimeException("Nome nulo");
        List filmes = listar();
        if (filmes.isEmpty())
            throw new RuntimeException("Sem filmes");
        List filmesEncontrados = new ArrayList();
        for (Object o : filmes) {
            Filme filme = (Filme) o;
            if (filme.getNome().contains(nome)) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

    public List procurarPeloDiretor(Diretor diretor) {
        List filmes = listar();
        List filmesEncontrados = new ArrayList();
        for (Object o : filmes) {
            Filme filme = (Filme) o;
            if (diretor != null && filme != null && filme.getDiretor().equals(diretor)) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

    public List procurarPeloAtor(Ator ator) {
        List filmes = listar();
        List filmesEncontrados = new ArrayList();
        for (Object o : filmes) {
            Filme filme = (Filme) o;
            if (ator != null && filme != null && filme.getAtores().contains(ator)) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

    @Override
    public void gravar(Object o) {
        Filme filme = (Filme) o;
        if (filme != null)
            filme.setId(this.bancoDeDados.getProximoId());
        this.bancoDeDados.inserirObjeto(filme);
    }
}
