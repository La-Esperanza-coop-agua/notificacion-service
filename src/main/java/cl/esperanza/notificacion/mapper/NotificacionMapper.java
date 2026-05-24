package cl.esperanza.notificacion.mapper;

import cl.esperanza.notificacion.dto.CreateNotificacionRequest;
import cl.esperanza.notificacion.model.Notificacion;

public class NotificacionMapper {
    public static Notificacion toModel(CreateNotificacionRequest request){
        return new Notificacion(null,
            request.idUsuarioDestino(), request.tipoAlerta(), request.mensaje(),
            request.leida(), request.fechaEmision()
        );
    }
}
