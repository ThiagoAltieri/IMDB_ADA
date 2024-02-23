import controller.Entrada;
import controller.MenuController;
import controller.views.FilmeView;
import dominio.Ator;
import dominio.Diretor;
import dominio.Filme;
import repository.AtorRepository;
import repository.DiretorRepository;
import repository.FilmeRepository;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;
import utils.InputHandler;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private MenuController menuController;
    public static void main(String[] args) {
        FilmeRepository filmeRepository = new FilmeRepository();
        AtorRepository atorRepository = new AtorRepository();
        DiretorRepository diretorRepository = new DiretorRepository();

        FilmeService filmeService = new FilmeService(filmeRepository);
        AtorService atorService = new AtorService(atorRepository);
        DiretorService diretorService = new DiretorService(diretorRepository);

        MenuController menuController = new MenuController(filmeService, atorService, diretorService);

        System.out.println("PROJETO POO - IMDb");
        int opcao;

        do {
            System.out.println("");
            menuController.menu();
            opcao = InputHandler.getIntInput("Qual a opcao desejada? ");
            System.out.println("");
            menuController.operacaoARealizar(opcao);
        } while (opcao != 0);
    }
}