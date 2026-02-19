package br.com.fiap.oficina.product_service.service.estoque;

import br.com.fiap.oficina.product_service.dto.request.estoque.ProdutoEntradaEstoqueRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.ProdutoEntradaEstoqueResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ProdutoEntradaEstoqueService {
    ProdutoEntradaEstoqueResponseDTO registrarEntrada(ProdutoEntradaEstoqueRequestDTO request);

    List<ProdutoEntradaEstoqueResponseDTO> listarEntradas(
            Long produtoCatalogoId,
            LocalDateTime dataInicio,
            LocalDateTime dataFim
    );

    ProdutoEntradaEstoqueResponseDTO buscarPorId(Long id);
}
