package cl.esperanza.notificacion.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateNotificacionRequest( 
    @NotBlank(message = "idUsuarioDestino no puede estar vacio") String idUsuarioDestino,
    @NotBlank(message = "tipoAlerta no puede estar vacia") String tipoAlerta,
    @NotBlank(message = "mensaje no puede estar vacia") String mensaje,
    @NotNull(message = "El estado de leido no puede estar nulo") boolean leida,
    @NotNull(message = "FechaEmision no puede estar vacia") LocalDate fechaEmision){
}
