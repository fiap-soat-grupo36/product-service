package br.com.fiap.oficina.product_service.dto.request.catalogo;

import br.com.fiap.oficina.product_service.enums.catalogo.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoCatalogoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "Categoria é obrigatória")
    private CategoriaProduto categoria;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private BigDecimal preco;
}
