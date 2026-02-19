package br.com.fiap.oficina.product_service.service.estoque;


import br.com.fiap.oficina.product_service.dto.request.estoque.MovimentacaoEstoqueRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.MovimentacaoEstoqueResponseDTO;
import br.com.fiap.oficina.product_service.enums.produto.TipoMovimentacao;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimentacaoEstoqueService {

    MovimentacaoEstoqueResponseDTO registrarEntrada(MovimentacaoEstoqueRequestDTO dto);

    MovimentacaoEstoqueResponseDTO registrarSaida(MovimentacaoEstoqueRequestDTO dto);

    List<MovimentacaoEstoqueResponseDTO> listarMovimentacoes(
            Long produtoCatalogoId,
            TipoMovimentacao tipo,
            LocalDateTime dataInicio,
            LocalDateTime dataFim
    );

    MovimentacaoEstoqueResponseDTO buscarPorId(Long id);
}
