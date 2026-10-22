package edu.altair.apicrm.exceptions;

public class TutoriaNotFoundException extends RuntimeException {
    public TutoriaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
