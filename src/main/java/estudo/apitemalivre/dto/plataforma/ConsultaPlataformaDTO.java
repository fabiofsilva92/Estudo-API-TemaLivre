package estudo.apitemalivre.dto.plataforma;

import java.math.BigDecimal;

public class ConsultaPlataformaDTO {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer anoLancamento;

    public ConsultaPlataformaDTO() {
    }

    public ConsultaPlataformaDTO(Long id, String nome, BigDecimal valor, Integer anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.anoLancamento = anoLancamento;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
