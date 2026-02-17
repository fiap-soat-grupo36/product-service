package br.com.fiap.oficina.product_service.service.catalogo;

import br.com.fiap.oficina.product_service.dto.request.catalogo.ProdutoCatalogoRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.catalogo.ProdutoCatalogoResponseDTO;
import br.com.fiap.oficina.product_service.entity.catalogo.ProdutoCatalogo;

import java.util.List;

public interface ProdutoCatalogoService {

    ProdutoCatalogoResponseDTO salvar(ProdutoCatalogoRequestDTO produto);

    ProdutoCatalogoResponseDTO atualizar(Long id, ProdutoCatalogoRequestDTO produto);

    ProdutoCatalogoResponseDTO buscarPorId(Long id);

    List<ProdutoCatalogoResponseDTO> listarTodos();

    List<ProdutoCatalogoResponseDTO> listarAtivos();

    List<ProdutoCatalogoResponseDTO> listarInativos();

    List<ProdutoCatalogoResponseDTO> buscarPorTermo(String termo);

    void deletar(Long id);

    ProdutoCatalogo getProduto(Long id);
}
