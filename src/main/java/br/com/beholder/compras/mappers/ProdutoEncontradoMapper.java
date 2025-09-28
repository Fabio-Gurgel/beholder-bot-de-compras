package br.com.beholder.compras.mappers;

import br.com.beholder.compras.dtos.ProdutoEncontradoDTO;
import br.com.beholder.compras.entities.ProdutoEncontradoEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoEncontradoMapper {
    ProdutoEncontradoEntity toEntity(ProdutoEncontradoDTO dto);
    ProdutoEncontradoDTO toDto(ProdutoEncontradoEntity entity);

    List<ProdutoEncontradoEntity> toEntity(List<ProdutoEncontradoDTO> dtos);
    List<ProdutoEncontradoDTO> toDto(List<ProdutoEncontradoEntity> entities);
}

