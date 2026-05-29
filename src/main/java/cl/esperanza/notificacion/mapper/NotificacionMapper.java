package cl.esperanza.notificacion.mapper;

import cl.esperanza.notificacion.dto.CreateNotificacionRequest;
import cl.esperanza.notificacion.model.Notificacion;

public class NotificacionMapper {

    public static Notificacion toModel(
            CreateNotificacionRequest request) {

        Notificacion notificacion =
                new Notificacion();

        notificacion.setAsunto(
                request.asunto());

        notificacion.setMensaje(
                request.mensaje());

        notificacion.setDestinatarios(
                request.destinatarios());

        return notificacion;
    }
}
