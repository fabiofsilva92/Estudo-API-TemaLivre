package estudo.apitemalivre.dto.jogo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RegistroJogoDTO {

    private String nome;
    private Date dataLancamento;
    private String descricao;
    private BigDecimal valor;
    private Long genero_id;
    private List<Long> plataformas;

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

    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }

    public List<Long> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Long> plataformas) {
        this.plataformas = plataformas;
    }
}
