package cl.esperanza.notificacion.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false, length = 255)
    private String asunto;

    @Column(nullable = false, length = 255)
    private String mensaje;

    @Column(name = "destinatario")
    private List<String> destinatarios;
}
