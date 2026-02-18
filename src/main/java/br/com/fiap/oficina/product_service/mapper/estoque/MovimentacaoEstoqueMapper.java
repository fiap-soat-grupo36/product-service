package br.com.fiap.oficina.product_service.mapper.estoque;


import br.com.fiap.oficina.product_service.dto.request.estoque.MovimentacaoEstoqueRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.MovimentacaoEstoqueResponseDTO;
import br.com.fiap.oficina.product_service.entity.estoque.MovimentacaoEstoque;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimentacaoEstoqueMapper {

    @Mapping(source = "tipoMovimentacao", target = "tipoMovimentacao")
    MovimentacaoEstoque toEntity(MovimentacaoEstoqueRequestDTO dto);

    @Mapping(source = "produtoCatalogoId", target = "produtoId")
    @Mapping(source = "tipoMovimentacao", target = "tipo")
    MovimentacaoEstoqueResponseDTO toResponseDTO(MovimentacaoEstoque entity);
}
