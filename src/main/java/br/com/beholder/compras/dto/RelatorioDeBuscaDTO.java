package br.com.beholder.compras.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RelatorioDeBuscaDTO {

    private String resumo;
    private List<ProdutoEncontradoDTO> produtosAbaixoDoPrecoEsperado;
    private List<ProdutoEncontradoDTO> produtosAcimaDoPrecoEsperado;
    private LocalDateTime inicioDaExecucao;
    private LocalDateTime fimDaExecucao;

    public RelatorioDeBuscaDTO(List<ProdutoEncontradoDTO> produtosAbaixoDoPrecoEsperado, List<ProdutoEncontradoDTO> produtosAcimaDoPrecoEsperado, String resumo, LocalDateTime inicioDaExecucao, LocalDateTime fimDaExecucao) {
        this.produtosAbaixoDoPrecoEsperado = produtosAbaixoDoPrecoEsperado;
        this.produtosAcimaDoPrecoEsperado = produtosAcimaDoPrecoEsperado;
        this.resumo = resumo;
        this.inicioDaExecucao = inicioDaExecucao;
        this.fimDaExecucao = fimDaExecucao;
    }

    public RelatorioDeBuscaDTO() {}

    public List<ProdutoEncontradoDTO> getProdutosAbaixoDoPrecoEsperado() {return produtosAbaixoDoPrecoEsperado; }
    public void setProdutosAbaixoDoPrecoEsperado(List<ProdutoEncontradoDTO> lista) { this.produtosAbaixoDoPrecoEsperado = lista; }

    public List<ProdutoEncontradoDTO> getProdutosAcimaDoPrecoEsperado() { return produtosAcimaDoPrecoEsperado; }
    public void setProdutosAcimaDoPrecoEsperado(List<ProdutoEncontradoDTO> lista) { this.produtosAcimaDoPrecoEsperado = lista; }

    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }

    public LocalDateTime getInicioDaExecucao() { return inicioDaExecucao; }
    public void setInicioDaExecucao(LocalDateTime inicio) { this.inicioDaExecucao = inicio; }

    public LocalDateTime getFimDaExecucao() { return fimDaExecucao; }
    public void setFimDaExecucao(LocalDateTime fim) { this.fimDaExecucao = fim; }
}
