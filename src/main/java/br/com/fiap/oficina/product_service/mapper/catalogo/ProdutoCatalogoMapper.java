package br.com.fiap.oficina.product_service.mapper.catalogo;


import br.com.fiap.oficina.product_service.dto.request.catalogo.ProdutoCatalogoRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.catalogo.ProdutoCatalogoResponseDTO;
import br.com.fiap.oficina.product_service.entity.catalogo.ProdutoCatalogo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoCatalogoMapper {

    ProdutoCatalogoResponseDTO toDTO(ProdutoCatalogo produto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    ProdutoCatalogo toEntity(ProdutoCatalogoRequestDTO produtoDTO);

    List<ProdutoCatalogoResponseDTO> toDTO(List<ProdutoCatalogo> produtos);
}
