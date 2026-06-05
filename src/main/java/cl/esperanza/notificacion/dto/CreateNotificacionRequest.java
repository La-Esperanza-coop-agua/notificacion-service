package cl.esperanza.notificacion.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateNotificacionRequest(
    @NotNull(message = "Fecha en formato invalido, debe ser (AAAA-MM-DD)") LocalDate fechaEmision,
    @NotBlank(message = "asunto no puede estar vacio") String asunto,
    @NotBlank(message = "mensaje no puede estar vacio") String mensaje
) {}