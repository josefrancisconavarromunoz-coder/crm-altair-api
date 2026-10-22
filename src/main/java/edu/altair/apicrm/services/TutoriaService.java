package edu.altair.apicrm.services;

import edu.altair.apicrm.dtos.TutoriaRequestDto;
import edu.altair.apicrm.dtos.TutoriaResponseDto;
import java.util.List;

public interface TutoriaService {
    List<TutoriaResponseDto> obtenerTodas();
    TutoriaResponseDto obtenerPorId(Long id);
    TutoriaResponseDto crear(TutoriaRequestDto requestDto);
    TutoriaResponseDto actualizar(Long id, TutoriaRequestDto requestDto);
    void eliminar(Long id);
}
