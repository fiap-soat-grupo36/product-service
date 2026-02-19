package br.com.fiap.oficina.product_service.service.estoque;


import br.com.fiap.oficina.product_service.dto.request.estoque.ReservaLoteRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.ReservaLoteResponseDTO;

public interface ReservaEstoqueLoteService {

    ReservaLoteResponseDTO reservarEmLote(ReservaLoteRequestDTO request);
}
