package br.com.beholder.compras.api;

import br.com.beholder.compras.botcore.bots.BotVerificarPrecoDeProduto;
import br.com.beholder.compras.api.dtos.RelatorioDeProdutosDTO;
import br.com.beholder.compras.api.dtos.SolicitacaoDeBuscaDTO;
import br.com.beholder.compras.utils.Stopwatch;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public RelatorioDeProdutosDTO executarBusca(SolicitacaoDeBuscaDTO solicitacao) {
        Stopwatch cronometroDeExecucao = Stopwatch.iniciar();

        RelatorioDeProdutosDTO relatorioDeProdutosDTO = executarBotVerificarPrecoDeProduto(solicitacao);

        cronometroDeExecucao.finalizar();
        System.out.println(cronometroDeExecucao.toString());

        return relatorioDeProdutosDTO;
    }

    private RelatorioDeProdutosDTO executarBotVerificarPrecoDeProduto(SolicitacaoDeBuscaDTO solicitacao) {
        BotVerificarPrecoDeProduto bot = new BotVerificarPrecoDeProduto(new ChromeDriver());

        return bot.executar(solicitacao);
    }
}
