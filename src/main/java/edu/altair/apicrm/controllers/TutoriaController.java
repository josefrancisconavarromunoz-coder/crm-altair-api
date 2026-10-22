package edu.altair.apicrm.controllers;

import edu.altair.apicrm.dtos.TutoriaRequestDto;
import edu.altair.apicrm.dtos.TutoriaResponseDto;
import edu.altair.apicrm.services.TutoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tutorias")
public class TutoriaController {

    private final TutoriaService tutoriaService;

    public TutoriaController(TutoriaService tutoriaService) {
        this.tutoriaService = tutoriaService;
    }

    // Consultar todas las tutorías
    @GetMapping
    public ResponseEntity<List<TutoriaResponseDto>> obtenerTodas() {
        return ResponseEntity.ok(tutoriaService.obtenerTodas());
    }

    // Consultar una tutoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<TutoriaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tutoriaService.obtenerPorId(id));
    }

    // Crear una tutoría (útil para registrar datos)
    @PostMapping
    public ResponseEntity<TutoriaResponseDto> crear(@RequestBody TutoriaRequestDto requestDto) {
        TutoriaResponseDto creada = tutoriaService.crear(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // Actualizar una tutoría
    @PutMapping("/{id}")
    public ResponseEntity<TutoriaResponseDto> actualizar(@PathVariable Long id, @RequestBody TutoriaRequestDto requestDto) {
        return ResponseEntity.ok(tutoriaService.actualizar(id, requestDto));
    }

    // Eliminar una tutoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tutoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
