package br.com.fiap.oficina.product_service.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter
public class DurationToLongConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return duration == null ? null : duration.toMinutes();
    }

    @Override
    public Duration convertToEntityAttribute(Long minutes) {
        return minutes == null ? null : Duration.ofMinutes(minutes);
    }
}