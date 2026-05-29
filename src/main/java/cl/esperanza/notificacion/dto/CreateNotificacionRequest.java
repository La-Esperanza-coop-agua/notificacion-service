package cl.esperanza.notificacion.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateNotificacionRequest(

    @NotBlank(message = "idNotificacion no puede estar vacio")
    String idNotificacion,

    @NotBlank(message = "asunto no puede estar vacio")
    String asunto,

    @NotBlank(message = "mensaje no puede estar vacio")
    String mensaje,

    @NotNull(message = "destinatarios no puede ser null")
    @NotEmpty(message = "Debe existir al menos un destinatario")
    List<String> destinatarios

) {
}