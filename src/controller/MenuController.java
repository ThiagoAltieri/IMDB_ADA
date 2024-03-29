package controller;

import controller.views.AtorView;
import controller.views.DiretorView;
import controller.views.FilmeView;
import dominio.Ator;
import dominio.Diretor;
import dominio.Filme;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;
import utils.InputHandler;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;

    public MenuController(FilmeService filmeService, AtorService atorService, DiretorService diretorService){
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
    }

    public void menu(){
        System.out.println("Menu de operacoes");
        System.out.println("____________________________________");
        System.out.println( "1) Cadastro de Filmes\n" +
                "2) Cadastro de atores\n" +
                "3) Cadastro de diretores\n" +
                "4) Listar Filmes\n" +
                "5) Listar Atores\n" +
                "6) Listar Diretores\n" +
                "7) Adicionar um ator ao filme\n" +
                "8) Adicionar um diretor ao filme\n" +
                "9) Adicionar um filme ao ator\n" +
                "10) Adicionar um filme ao diretor\n" +
                "11) Pesquisar filme pelo nome\n" +
                "0) Encerrar aplicativo");
        System.out.println("____________________________________");
    }

    public void operacaoARealizar(int operacao){

        switch (operacao){
            case 1:
                FilmeView.cadastrarFilmes(filmeService, atorService, diretorService);
                break;
            case 2:
                AtorView.cadastrarAtor(atorService);
                break;
            case 3:
                DiretorView.cadastrarDiretor(diretorService);
                break;
            case 4:
                FilmeView.listarFilmes(filmeService);
                break;
            case 5:
                AtorView.listarAtores(atorService);
                break;
            case 6:
                DiretorView.listarDiretores(diretorService);
                break;

            case 7:
                FilmeView.adicionarAtorAoFilme(atorService, filmeService);
                break;
            case 8:
                FilmeView.adicionarDiretorEmFilme(diretorService,filmeService);
                break;
            case 9:
                //adicionarAtorEmFilme();
                AtorView.adicionarFilmeAoAtor(atorService, filmeService);
                break;
            case 10:
                //adicionarDiretorEmFilme();
                DiretorView.adicionarFilmeAoDiretor(diretorService, filmeService);
                break;
            case 11:
                FilmeView.pesquisarFilmePorNome(filmeService);
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}