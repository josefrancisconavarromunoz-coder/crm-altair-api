package edu.altair.apicrm.services.impl;

import edu.altair.apicrm.dtos.TutoriaRequestDto;
import edu.altair.apicrm.dtos.TutoriaResponseDto;
import edu.altair.apicrm.entities.Tutoria;
import edu.altair.apicrm.exceptions.TutoriaNotFoundException;
import edu.altair.apicrm.repositories.TutoriaRepository;
import edu.altair.apicrm.services.TutoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TutoriaServiceImpl implements TutoriaService {

    private final TutoriaRepository tutoriaRepository;

    public TutoriaServiceImpl(TutoriaRepository tutoriaRepository) {
        this.tutoriaRepository = tutoriaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TutoriaResponseDto> obtenerTodas() {
        return tutoriaRepository.findAll().stream().map(this::mapToResponseDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TutoriaResponseDto obtenerPorId(Long id) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new TutoriaNotFoundException("Tutoría no encontrada con el ID: " + id));
        return mapToResponseDto(tutoria);
    }

    @Override
    @Transactional
    public TutoriaResponseDto crear(TutoriaRequestDto dto) {
        Tutoria tutoria = new Tutoria(null, dto.titulo(), dto.descripcion(), dto.profesor(), dto.precio(), dto.disponible());
        return mapToResponseDto(tutoriaRepository.save(tutoria));
    }

    @Override
    @Transactional
    public TutoriaResponseDto actualizar(Long id, TutoriaRequestDto dto) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new TutoriaNotFoundException("Tutoría no encontrada con el ID: " + id));
        tutoria.setTitulo(dto.titulo());
        tutoria.setDescripcion(dto.descripcion());
        tutoria.setProfesor(dto.profesor());
        tutoria.setPrecio(dto.precio());
        tutoria.setDisponible(dto.disponible());
        return mapToResponseDto(tutoriaRepository.save(tutoria));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!tutoriaRepository.existsById(id)) {
            throw new TutoriaNotFoundException("Imposible eliminar. Tutoría no encontrada con el ID: " + id);
        }
        tutoriaRepository.deleteById(id);
    }

    private TutoriaResponseDto mapToResponseDto(Tutoria tutoria) {
        return new TutoriaResponseDto(tutoria.getIdTutoria(), tutoria.getTitulo(), tutoria.getDescripcion(),
                tutoria.getProfesor(), tutoria.getPrecio(), tutoria.isDisponible());
    }
}
