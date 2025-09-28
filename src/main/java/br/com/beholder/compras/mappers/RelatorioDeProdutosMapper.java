package br.com.beholder.compras.mappers;

import br.com.beholder.compras.dtos.RelatorioDeProdutosDTO;
import br.com.beholder.compras.entities.RelatorioDeProdutosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SolicitacaoDeBuscaMapper.class, ProdutoEncontradoMapper.class})
public interface RelatorioDeProdutosMapper {
    RelatorioDeProdutosEntity toEntity(RelatorioDeProdutosDTO dto);
    RelatorioDeProdutosDTO toDto(RelatorioDeProdutosEntity entity);
}