package cl.esperanza.notificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.esperanza.notificacion.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer>{
    
}
