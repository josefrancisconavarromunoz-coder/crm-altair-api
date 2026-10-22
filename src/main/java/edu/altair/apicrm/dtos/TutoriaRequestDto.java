package edu.altair.apicrm.dtos;

public record TutoriaRequestDto(
        String titulo,
        String descripcion,
        String profesor,
        Double precio,
        boolean disponible
) {}
