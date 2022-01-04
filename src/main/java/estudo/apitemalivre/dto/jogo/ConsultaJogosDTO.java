package estudo.apitemalivre.dto.jogo;

import estudo.apitemalivre.dto.plataforma.ConsultaPlataformaDTO;
import estudo.apitemalivre.dto.genero.ConsultaGeneroDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ConsultaJogosDTO {

    private Long id;
    private String nome;
    private Date dataLancamento;
    private String descricao;
    private BigDecimal valor;

    private ConsultaGeneroDTO genero;

    private List<ConsultaPlataformaDTO> plataformas;

    public ConsultaJogosDTO() {
    }

    public ConsultaJogosDTO(Long id, String nome, Date dataLancamento, String descricao, BigDecimal valor, ConsultaGeneroDTO genero, List<ConsultaPlataformaDTO> plataformas) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.genero = genero;
        this.plataformas = plataformas;
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

    public ConsultaGeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(ConsultaGeneroDTO genero) {
        this.genero = genero;
    }

    public List<ConsultaPlataformaDTO> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<ConsultaPlataformaDTO> plataformas) {
        this.plataformas = plataformas;
    }
}
