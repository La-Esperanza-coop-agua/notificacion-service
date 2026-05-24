package cl.esperanza.notificacion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.esperanza.notificacion.model.Notificacion;
import cl.esperanza.notificacion.repository.NotificacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacionService {
    @Autowired
    private NotificacionRepository notifRepo;

    public List<Notificacion> obtenerPorFechaEmision(LocalDate fecha){
        return notifRepo.findByFechaEmision(fecha);
    }

    public Notificacion guardarNotificacion(Notificacion notif){
        return notifRepo.save(notif);
    }
}
