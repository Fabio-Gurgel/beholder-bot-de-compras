package br.com.beholder.compras.mappers;

import br.com.beholder.compras.dtos.SolicitacaoDeBuscaDTO;
import br.com.beholder.compras.entities.SolicitacaoDeBuscaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitacaoDeBuscaMapper {
    SolicitacaoDeBuscaEntity toEntity(SolicitacaoDeBuscaDTO dto);
    SolicitacaoDeBuscaDTO toDto(SolicitacaoDeBuscaEntity entity);
}
