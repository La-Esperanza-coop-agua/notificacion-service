package cl.esperanza.notificacion.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.esperanza.notificacion.dto.CreateNotificacionRequest;
import cl.esperanza.notificacion.mapper.NotificacionMapper;
import cl.esperanza.notificacion.model.Notificacion;
import cl.esperanza.notificacion.service.NotificacionService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v1/notificaciones")
public class NotificacionController {
    private final NotificacionService notificacionService;

    // Constructor de Inyeccion
    public NotificacionController(NotificacionService notifServ){
        this.notificacionService = notifServ;
    }
    
    // EndPoint 1 findByFechaEmision
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Notificacion>> getNotificacionPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<Notificacion> registros = notificacionService.obtenerPorFechaEmision(fecha);
        return ResponseEntity.ok(registros);
    }
    
    // EndPoint 2 guardar
    @PostMapping
    public ResponseEntity<Notificacion> addNotificacion(@Valid @RequestBody CreateNotificacionRequest request){
        Notificacion nuevaNotificacion = notificacionService.guardarNotificacion(NotificacionMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNotificacion);
    }

}
