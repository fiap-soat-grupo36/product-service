package br.com.fiap.oficina.product_service.mapper.catalogo;


import br.com.fiap.oficina.product_service.dto.request.catalogo.ServicoRequestDTO;
import br.com.fiap.oficina.product_service.dto.response.catalogo.ServicoResponseDTO;
import br.com.fiap.oficina.product_service.entity.catalogo.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Duration;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    @Mapping(target = "tempoEstimadoMinutos", expression = "java(durationToMinutes(servico.getTempoEstimado()))")
    ServicoResponseDTO toDTO(Servico servico);

    @Mapping(target = "tempoEstimado", expression = "java(minutesToDuration(servicoDTO.getTempoEstimadoMinutos()))")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    Servico toEntity(ServicoRequestDTO servicoDTO);

    List<ServicoResponseDTO> toDTO(List<Servico> servicos);

    default Long durationToMinutes(Duration duration) {
        return duration != null ? duration.toMinutes() : null;
    }

    default Duration minutesToDuration(Long minutes) {
        return minutes != null ? Duration.ofMinutes(minutes) : null;
    }
}
