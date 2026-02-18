package br.com.fiap.oficina.product_service.dto.response.estoque;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemReservaResultDTO {
    private Long produtoCatalogoId;
    private Integer solicitada;
    private Integer reservada;
    private String status;
    private String detalhe;
    private Long reservaItemId;
}
