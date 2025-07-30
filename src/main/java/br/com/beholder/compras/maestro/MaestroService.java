package br.com.beholder.compras.maestro;

import br.com.beholder.compras.botcore.BotVerificarPrecoDeProduto;
import br.com.beholder.compras.dto.ProdutoEncontradoDTO;
import br.com.beholder.compras.dto.RelatorioDeBuscaDTO;
import br.com.beholder.compras.dto.SolicitacaoDeBuscaDTO;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaestroService {

    public RelatorioDeBuscaDTO executarBusca(SolicitacaoDeBuscaDTO solicitacao) {
        LocalDateTime inicio = LocalDateTime.now();

        executarBotVerificarPrecoDeProduto();

        List<ProdutoEncontradoDTO> abaixo = new ArrayList<>();
        List<ProdutoEncontradoDTO> acima = new ArrayList<>();

        ProdutoEncontradoDTO p1 = new ProdutoEncontradoDTO(solicitacao.nomeProduto() + " - Loja X", 1199.00);
        ProdutoEncontradoDTO p2 = new ProdutoEncontradoDTO(solicitacao.nomeProduto() + " - Loja Z", 1399.00);

        if (p1.preco() <= solicitacao.precoEsperado()) abaixo.add(p1); else acima.add(p1);
        if (p2.preco() <= solicitacao.precoEsperado()) abaixo.add(p2); else acima.add(p2);

        RelatorioDeBuscaDTO relatorio = new RelatorioDeBuscaDTO();
        relatorio.setInicioDaExecucao(inicio);
        relatorio.setFimDaExecucao(LocalDateTime.now());
        relatorio.setProdutosAbaixoDoPrecoEsperado(abaixo);
        relatorio.setProdutosAcimaDoPrecoEsperado(acima);
        relatorio.setResumo("Encontrados " + (abaixo.size() + acima.size()) + " produtos. " + abaixo.size() + " abaixo do esperado.");

        return relatorio;
    }

    private void executarBotVerificarPrecoDeProduto() {
        BotVerificarPrecoDeProduto bot = new BotVerificarPrecoDeProduto(new ChromeDriver());
        bot.executar();
    }
}
