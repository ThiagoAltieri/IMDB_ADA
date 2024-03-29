package service;

import dominio.Ator;
import dominio.Diretor;
import dominio.Filme;
import repository.AtorRepository;
import repository.DiretorRepository;

import java.util.List;

public class DiretorService {
    private DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository){
        this.diretorRepository = diretorRepository;
    }

    public Diretor buscarDiretorId(long id){
        return diretorRepository.buscarDiretorId(id);
    }

    public void cadastrarDiretor(Diretor diretor){
        try {
            diretorRepository.cadastrarDiretor(diretor);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Informação inválida!");
        }
    }

    public List<Diretor> listarDiretores(){
        return diretorRepository.listarDiretores();
    }

    public boolean deletarDiretor(long id){
        try {
            diretorRepository.deletarDiretor(id);
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

    public void adicionarFilmeAoDiretor(Diretor diretor, Filme filme, FilmeService filmeService){
        boolean adicionar = true;
        for (Filme filmeLista: filmeService.listarFilmes()) {
            if (diretor.equals(filmeLista.getDiretor())){
                adicionar = false;
                break;
            }
        }
        if (adicionar){
            diretorRepository.adicionarFilmeAoDiretor(diretor, filme);
        }
    }

    public boolean buscarFilme(Diretor diretor, Filme filme) {
        return diretor.getFilmes().contains(filme);
    }
}