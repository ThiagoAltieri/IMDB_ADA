package repositorio;

import banco.BancoDeDados;
import modelo.Diretor;
import java.util.List;
import java.util.Objects;

public class DiretorRepositorio extends AbstractRepositorio {

    public DiretorRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Boolean filtrarPorId(Object o, Long id) {
        Diretor diretor = (Diretor) o;
        return Objects.equals(diretor.getId(), id);
    }

    @Override
    protected Class classeModelo() {
        return Diretor.class;
    }

    @Override
    public void gravar(Object o) {
        Diretor diretor = (Diretor) o;
        if (diretor != null) {
            diretor.setId(this.bancoDeDados.getProximoId());
            this.bancoDeDados.inserirObjeto(diretor);
        }
    }
}
