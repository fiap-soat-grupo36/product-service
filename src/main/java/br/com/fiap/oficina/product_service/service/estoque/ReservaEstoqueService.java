package br.com.fiap.oficina.product_service.service.estoque;

import br.com.fiap.oficina.product_service.entity.estoque.ReservaEstoque;

import java.util.List;

public interface ReservaEstoqueService {

    ReservaEstoque reservar(Long produtoCatalogoId, Long ordemServicoId, Integer quantidade);

    void cancelarPorOrdemServico(Long ordemServicoId);

    List<ReservaEstoque> listarReservasPorOrdemServico(Long ordemServicoId);
}
