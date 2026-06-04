package cl.esperanza.notificacion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.esperanza.notificacion.model.Notificacion;
import cl.esperanza.notificacion.repository.NotificacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacionService {
    @Autowired
    private NotificacionRepository notifRepo;
    private WebClient sociosWebClient;

    public List<Notificacion> obtenerPorFechaEmision(LocalDate fecha){
        return notifRepo.findByFechaEmision(fecha);
    }

    public NotificacionService(
        NotificacionRepository notifRepo, 
        @Qualifier("webClientSocios") WebClient sociosWebClient
    ) {
        this.notifRepo = notifRepo;
        this.sociosWebClient = sociosWebClient;
    }
    

    public Notificacion guardarNotificacion(Notificacion notif){
        return notifRepo.save(notif);
    }

    public List<String> obtenerCorreosDeSocios() {
        return sociosWebClient.get()
                .uri("/correo") .retrieve() .bodyToFlux(String.class) .collectList() .block();
    }

}
