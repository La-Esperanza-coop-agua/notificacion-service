package cl.esperanza.notificacion.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.esperanza.notificacion.dto.CreateNotificacionRequest;
import cl.esperanza.notificacion.mapper.NotificacionMapper;
import cl.esperanza.notificacion.model.Notificacion;
import cl.esperanza.notificacion.repository.NotificacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacionService {
    private final NotificacionRepository notifRepo;
    private final WebClient sociosWebClient;

    public NotificacionService(NotificacionRepository notifRepo, WebClient sociosWebClient) {
        this.notifRepo = notifRepo;
        this.sociosWebClient = sociosWebClient;
    }

    public List<Notificacion> obtenerPorFechaEmision(LocalDate fecha){
        return notifRepo.findByFechaEmision(fecha);
    }

    public Notificacion guardarNotificacion(Notificacion notif){
        return notifRepo.save(notif);
    }

    public List<String> obtenerCorreosDeSocios() {
        try {
            return sociosWebClient.get()
                .uri("/correo")
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
        } catch (Exception e) {
            System.err.println("No se pudieron rescatar los correos de Socios-Service: " + e.getMessage());
            return new ArrayList<>(); 
        }
    }

    public Notificacion registrarNotificacionConSocios(CreateNotificacionRequest request) {
        Notificacion notificacion = NotificacionMapper.toModel(request);
        List<String> correosSocios = obtenerCorreosDeSocios();

        if (correosSocios != null) {
            notificacion.setDestinatarios(correosSocios);
        } else {
            notificacion.setDestinatarios(new ArrayList<>());
        }
        return notifRepo.save(notificacion);
    }
}