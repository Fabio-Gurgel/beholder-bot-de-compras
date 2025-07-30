package br.com.beholder.compras.maestro;

import br.com.beholder.compras.dto.RelatorioDeBuscaDTO;
import br.com.beholder.compras.dto.SolicitacaoDeBuscaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/busca")
public class MaestroController {

    @Autowired
    private MaestroService service;

    @PostMapping
    public ResponseEntity<RelatorioDeBuscaDTO> buscar(@RequestBody @Valid SolicitacaoDeBuscaDTO solicitacao) {
        return ResponseEntity.ok(service.executarBusca(solicitacao));
    }
}
