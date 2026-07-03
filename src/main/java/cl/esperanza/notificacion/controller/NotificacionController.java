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
import cl.esperanza.notificacion.model.Notificacion;
import cl.esperanza.notificacion.service.NotificacionService;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/notificaciones")
@Tag(name = "Notificaciones", description = "Envío y simulación de alertas o correos masivos a los socios de la cooperativa.")
public class NotificacionController {
    
    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService){
        this.notificacionService = notificacionService;
    }
    
    @Operation(summary = "Obtener notificaciones por fecha", description = "Lista el historial de avisos emitidos en una fecha específica.")
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Notificacion>> getNotificacionPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<Notificacion> registros = notificacionService.obtenerPorFechaEmision(fecha);
        return ResponseEntity.ok(registros);
    }
    
    @Operation(summary = "Simular y enviar notificación", description = "Crea un aviso masivo obteniendo automáticamente todos los correos de los socios mediante WebClient.")
    @PostMapping
    public ResponseEntity<Notificacion> addNotificacion(@Valid @RequestBody CreateNotificacionRequest request){
        Notificacion nuevaNotificacion = notificacionService.registrarNotificacionConSocios(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNotificacion);
    }
}