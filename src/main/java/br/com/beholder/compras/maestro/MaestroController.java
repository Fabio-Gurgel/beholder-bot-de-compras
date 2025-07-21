package br.com.beholder.compras.maestro;

import br.com.beholder.compras.maestro.dto.RelatorioDeBuscaDTO;
import br.com.beholder.compras.maestro.dto.SolicitacaoDeBuscaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busca")
public class MaestroController {

    @Autowired
    private MaestroService service;

    @PostMapping
    public RelatorioDeBuscaDTO buscar(@RequestBody SolicitacaoDeBuscaDTO solicitacao) {
        return service.executarBusca(solicitacao);
    }
}
