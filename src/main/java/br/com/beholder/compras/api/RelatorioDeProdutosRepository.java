package br.com.beholder.compras.api;

import br.com.beholder.compras.entities.RelatorioDeProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioDeProdutosRepository extends JpaRepository<RelatorioDeProdutosEntity, Long> {
}
