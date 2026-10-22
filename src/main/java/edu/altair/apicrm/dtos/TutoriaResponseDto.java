package edu.altair.apicrm.dtos;

public record TutoriaResponseDto(
        Long idTutoria,
        String titulo,
        String descripcion,
        String profesor,
        Double precio,
        boolean disponible
) {}
