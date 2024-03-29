package repository;

import dominio.Ator;
import dominio.Diretor;
import dominio.Filme;

import java.util.ArrayList;
import java.util.List;

public class DiretorRepository {

    private List<Diretor> diretoresBanco;

    public DiretorRepository() {
        this.diretoresBanco = new ArrayList<>();
    }

    public Diretor buscarDiretorId(long id) {
        for (Diretor diretor : diretoresBanco){
            if (diretor.getId() == id){
                return diretor;
            }
        }

        return null;
    }

    public void cadastrarDiretor(Diretor diretor){
        this.diretoresBanco.add(diretor);
    }

    public boolean deletarDiretor(long id){
        if(diretoresBanco.get((int)id) != null){
            diretoresBanco.remove(buscarDiretorId(id));
            return true;
        }

        return false;
    }

    public List<Diretor> listarDiretores(){
        return diretoresBanco;
    }

    public void adicionarFilmeAoDiretor(Diretor diretor,Filme filme){
        diretor.addFilme(filme);
        filme.adicionarDiretor(diretor);
    }
}