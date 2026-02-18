package br.com.fiap.oficina.product_service.service.estoque;


import br.com.fiap.oficina.product_service.dto.response.estoque.ProdutoEstoqueResponseDTO;
import br.com.fiap.oficina.product_service.entity.estoque.ProdutoEstoque;

import java.util.List;

public interface ProdutoEstoqueService {

    ProdutoEstoque obterOuCriarSaldo(Long produtoCatalogoId);

    void atualizarSaldoAposMovimentacao(Long produtoCatalogoId);

    void recalcularPrecoMedio(Long produtoCatalogoId);

    ProdutoEstoqueResponseDTO getSaldoConsolidado(Long produtoCatalogoId);

    List<ProdutoEstoqueResponseDTO> listarTodos();

    ProdutoEstoqueResponseDTO buscarPorId(Long id);

    ProdutoEstoqueResponseDTO buscarPorProdutoCatalogo(Long produtoCatalogoId);

    List<ProdutoEstoqueResponseDTO> buscarPorTermo(String termo);

    List<ProdutoEstoqueResponseDTO> listarBaixoEstoque();

    ProdutoEstoqueResponseDTO atualizarEstoqueMinimo(Long id, Integer estoqueMinimo);
}
