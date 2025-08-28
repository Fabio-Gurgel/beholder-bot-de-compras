package br.com.beholder.compras.api;

import br.com.beholder.compras.dtos.RelatorioDeProdutosDTO;
import br.com.beholder.compras.dtos.SolicitacaoDeBuscaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/busca")
public class ApiController {

    @Autowired
    private ApiService service;

    @PostMapping
    public ResponseEntity<RelatorioDeProdutosDTO> buscar(@RequestBody @Valid SolicitacaoDeBuscaDTO solicitacao) {
        return ResponseEntity.ok(service.executarBusca(solicitacao));
    }
}
