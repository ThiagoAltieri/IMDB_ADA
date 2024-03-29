package service;

import dominio.Ator;
import dominio.Diretor;
import dominio.Filme;
import repository.FilmeRepository;

import java.util.List;

public class FilmeService {
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public void adicionarAtor(Filme filme, Ator ator){
        filme.adicionarAtor(ator);
        ator.addFilme(filme);
        filme.calcularNotaElenco();
    }

    public void adicionarDiretor(Filme filme, Diretor diretor){
        filme.adicionarDiretor(diretor);
        diretor.addFilme(filme);
    }

    public void cadastrarFilme(Filme filme){
        if (validarData(filme.getDataLancamento())) {
            filmeRepository.cadastrarFilme(filme);
        } else {
            System.out.println("Data de lançamento inválida!");
        }
    }

    public List<Filme> listarFilmes(){
        return filmeRepository.listarFilmes();
    }

    public List<Filme> buscarFilme(String nome){
        return filmeRepository.buscarFilme(nome);
    }

    public Filme buscarFilmeId(long id){
        return filmeRepository.buscarFilmeId(id);
    }

    public boolean buscarAtor(Ator ator, Filme filme){
        return filmeRepository.buscarAtor(ator, filme);
    }

    public boolean buscarDiretor(Diretor diretor, Filme filme){
        return filmeRepository.buscarDiretor(diretor, filme);
    }

    public boolean validarData(String dataLancamento){
        if (dataLancamento.length() < 8 || dataLancamento.length() > 10) {
            return false;
        }

        String parteNumerica = dataLancamento.replaceAll("[^0-9]", "");

        int dia = Integer.parseInt(parteNumerica.substring(0, 2));
        int mes = Integer.parseInt(parteNumerica.substring(2, 4));
        int ano = Integer.parseInt(parteNumerica.substring(4));

        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bissexto && mes == 2) {
            diasPorMes[2] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes] && mes >= 1 && mes <= 12;
    }

}