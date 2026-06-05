package cl.esperanza.notificacion.mapper;

import java.util.ArrayList;

import cl.esperanza.notificacion.dto.CreateNotificacionRequest;
import cl.esperanza.notificacion.model.Notificacion;

public class NotificacionMapper {

    public static Notificacion toModel(CreateNotificacionRequest request){
        return new Notificacion(null,
            request.fechaEmision(), request.asunto(), request.mensaje(),
            new ArrayList<>()
        );
    }

}
