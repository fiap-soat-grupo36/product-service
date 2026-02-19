package br.com.fiap.oficina.product_service.service.estoque.impl;


import br.com.fiap.oficina.product_service.dto.request.estoque.ItemReservaDTO;
import br.com.fiap.oficina.product_service.dto.request.estoque.ReservaLoteRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.ItemReservaResultDTO;
import br.com.fiap.oficina.product_service.dto.response.estoque.ReservaLoteResponseDTO;
import br.com.fiap.oficina.product_service.entity.estoque.ReservaEstoque;
import br.com.fiap.oficina.product_service.exception.EstoqueInsuficienteException;
import br.com.fiap.oficina.product_service.service.estoque.ReservaEstoqueLoteService;
import br.com.fiap.oficina.product_service.service.estoque.ReservaEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaEstoqueLoteServiceImpl implements ReservaEstoqueLoteService {

    private final ReservaEstoqueService reservaEstoqueService;

    @Override
    @Transactional
    public ReservaLoteResponseDTO reservarEmLote(ReservaLoteRequestDTO request) {
        List<ItemReservaResultDTO> resultados = new ArrayList<>();
        boolean sucessoGeral = true;
        boolean houveErro = false;

        for (ItemReservaDTO item : request.getItens()) {
            ItemReservaResultDTO resultado = new ItemReservaResultDTO();
            resultado.setProdutoCatalogoId(item.getProdutoCatalogoId());
            resultado.setSolicitada(item.getQuantidade());

            try {
                ReservaEstoque reserva = reservaEstoqueService.reservar(
                        item.getProdutoCatalogoId(),
                        request.getOrdemServicoId(),
                        item.getQuantidade()
                );

                resultado.setReservada(item.getQuantidade());
                resultado.setStatus("OK");
                resultado.setDetalhe("Reserva realizada com sucesso");
                resultado.setReservaItemId(reserva.getId());

            } catch (EstoqueInsuficienteException e) {
                resultado.setReservada(0);
                resultado.setStatus("ERRO");
                resultado.setDetalhe(e.getMessage());
                resultado.setReservaItemId(null);
                houveErro = true;

                if (Boolean.TRUE.equals(request.getAllOrNothing())) {
                    throw e; // Rollback da transação
                }

            } catch (Exception e) {
                resultado.setReservada(0);
                resultado.setStatus("ERRO");
                resultado.setDetalhe(e.getMessage());
                resultado.setReservaItemId(null);
                houveErro = true;

                if (Boolean.TRUE.equals(request.getAllOrNothing())) {
                    throw e; // Rollback da transação
                }
            }

            resultados.add(resultado);
        }

        if (houveErro) {
            sucessoGeral = false;
        }

        return new ReservaLoteResponseDTO(request.getOrdemServicoId(), sucessoGeral, resultados);
    }
}
