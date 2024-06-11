package core.core.core.data.entities;

import core.core.core.data.enums.Specialite;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "Rv")
public class RV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private LocalDate dateHeure;
    private boolean valide;
    @Enumerated(value = EnumType.STRING)
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(nullable = false, columnDefinition = "boolean default true")
    protected Boolean active;

    public RV(Boolean active) {
        this.active = active;
    }

}
