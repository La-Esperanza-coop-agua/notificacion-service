package cl.esperanza.notificacion.model;

import java.util.List;
import java.time.LocalDate;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ElementCollection
    @CollectionTable(
        name = "notificacion_destinatarios",
        joinColumns = @JoinColumn(name = "notificacion_id")
    )

    @Column(name = "destinatario")
    private List<String> destinatarios;
}
