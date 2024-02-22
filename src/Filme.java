import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
public class Filme {
    private Long id;
    private final String nome;
    private final Diretor diretor;
    private final LocalDate dataLancamento;
    private final String genero;
    private final List atores;
    public Filme(String nome, Diretor diretor, LocalDate dataLancamento, String genero, List atores) {
        this.nome = nome;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
        this.atores = atores;
    }
    public String getNome() {
        return nome;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public String getGenero() {
        return genero;
    }
    public List getAtores() {
        return Collections.unmodifiableList(atores);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
