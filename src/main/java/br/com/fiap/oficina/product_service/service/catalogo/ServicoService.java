package br.com.fiap.oficina.product_service.service.catalogo;

import br.com.fiap.oficina.product_service.dto.request.catalogo.ServicoRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.catalogo.ServicoResponseDTO;
import br.com.fiap.oficina.product_service.entity.catalogo.Servico;

import java.util.List;

public interface ServicoService {

    ServicoResponseDTO salvar(ServicoRequestDTO servico);

    ServicoResponseDTO atualizar(Long id, ServicoRequestDTO servico);

    ServicoResponseDTO buscarPorId(Long id);

    List<ServicoResponseDTO> listarTodos();

    List<ServicoResponseDTO> listarAtivos();

    List<ServicoResponseDTO> listarInativos();

    List<ServicoResponseDTO> buscarPorTermo(String termo);

    void deletar(Long id);

    Servico getServico(Long id);
}
