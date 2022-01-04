package estudo.apitemalivre.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataLancamento;

    private String descricao;

    private BigDecimal valor;

    @ManyToOne
    private Genero genero;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_jogo_plataforma")
    private List<Plataforma> plataforma;

    public Jogo() {
    }

    public Jogo(Long id, String nome, Date dataLancamento, String descricao, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Jogo(Long id, String nome, Date dataLancamento, String descricao, BigDecimal valor, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.genero = genero;
    }

    public Jogo(Long id, String nome, Date dataLancamento, String descricao, BigDecimal valor, Genero genero, List<Plataforma> plataformas) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.genero = genero;
        this.plataforma = plataformas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Plataforma> getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(List<Plataforma> plataforma) {
        this.plataforma = plataforma;
    }
}
