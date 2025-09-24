package br.com.beholder.compras.api;

import br.com.beholder.compras.botcore.bots.BotVerificarPrecoDeProduto;
import br.com.beholder.compras.dtos.RelatorioDeProdutosDTO;
import br.com.beholder.compras.dtos.SolicitacaoDeBuscaDTO;
import br.com.beholder.compras.entities.RelatorioDeProdutosEntity;
import br.com.beholder.compras.utils.Stopwatch;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiService {

    private final RelatorioDeProdutosRepository repository;
    private final ModelMapper modelMapper;

    public ApiService(RelatorioDeProdutosRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public RelatorioDeProdutosDTO executarBusca(SolicitacaoDeBuscaDTO solicitacao) {
        Stopwatch cronometroDeExecucao = Stopwatch.iniciar();

        RelatorioDeProdutosDTO relatorioDeProdutosDTO = executarBotVerificarPrecoDeProduto(solicitacao);

        cronometroDeExecucao.finalizar();
        System.out.println(cronometroDeExecucao.toString());

        return relatorioDeProdutosDTO;
    }

    private RelatorioDeProdutosDTO executarBotVerificarPrecoDeProduto(SolicitacaoDeBuscaDTO solicitacao) {
        BotVerificarPrecoDeProduto bot = new BotVerificarPrecoDeProduto(new ChromeDriver());

        RelatorioDeProdutosDTO relatorio = bot.executar(solicitacao);
        salvarRelatorioDeProdutosNoBanco(relatorio);
        return relatorio;
    }

    @Transactional
    public void salvarRelatorioDeProdutosNoBanco(RelatorioDeProdutosDTO relatorio) {
        RelatorioDeProdutosEntity entity = modelMapper.map(relatorio, RelatorioDeProdutosEntity.class);
        repository.save(entity);
    }
}
