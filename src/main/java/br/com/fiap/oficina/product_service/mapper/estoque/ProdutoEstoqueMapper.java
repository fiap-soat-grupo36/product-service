package br.com.fiap.oficina.product_service.mapper.estoque;


import br.com.fiap.oficina.product_service.dto.response.estoque.ProdutoEstoqueResponseDTO;
import br.com.fiap.oficina.product_service.entity.estoque.ProdutoEstoque;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoEstoqueMapper {

    @Mapping(source = "produtoCatalogoId", target = "produtoCatalogoId")
    @Mapping(source = "updatedAt", target = "ultimaAtualizacao")
    @Mapping(target = "nomeProduto", ignore = true)
    @Mapping(target = "codigoProduto", ignore = true)
    @Mapping(target = "baixoEstoque", expression = "java(entity.getQuantidadeDisponivel() != null && entity.getEstoqueMinimo() != null && entity.getQuantidadeDisponivel() < entity.getEstoqueMinimo())")
    ProdutoEstoqueResponseDTO toResponseDTO(ProdutoEstoque entity);
}
